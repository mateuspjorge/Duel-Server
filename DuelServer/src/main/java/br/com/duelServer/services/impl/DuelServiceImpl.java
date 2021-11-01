package br.com.duelServer.services.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.duelServer.dtos.CampeaoAPI;
import br.com.duelServer.entitys.Duel;
import br.com.duelServer.exceptions.DuelException;
import br.com.duelServer.repositorys.IDuelRepository;
import br.com.duelServer.services.IDuelService;
import io.micrometer.core.instrument.util.StringUtils;

@Service
public class DuelServiceImpl implements IDuelService {

	private IDuelRepository duelRepository;

	@Autowired
	public DuelServiceImpl(IDuelRepository duelRepository) {
		super();
		this.duelRepository = duelRepository;
	}

	@Override
	public Duel startDuel(CampeaoAPI champion, CampeaoAPI rival) throws DuelException {
		validateChampionData(champion);
		validateChampionData(rival);
		Long damageInflictedOnChampion = calculateAttackDamage(rival) - calculateDefense(champion);
		Long damageInflictedOnRival = calculateAttackDamage(champion) - calculateDefense(rival);
		Long numberAttacksInflictedChampion = champion.getHp() / damageInflictedOnRival;
		Long numberAttacksInflictedRival = rival.getHp() / damageInflictedOnChampion;
		if (Long.compare(numberAttacksInflictedChampion, numberAttacksInflictedRival) > 0) {
			return duelRepository.save(new Duel(null, champion.getEmail(), rival.getEmail(), champion.getEmail()));
		} else if (Long.compare(numberAttacksInflictedChampion, numberAttacksInflictedRival) < 0) {
			return duelRepository.save(new Duel(null, champion.getEmail(), rival.getEmail(), rival.getEmail()));
		} else {
			return duelRepository.save(new Duel(null, champion.getEmail(), rival.getEmail(), null));
		}
	}

	private Long calculateAttackDamage(CampeaoAPI champion) {
		return (champion.getForcaFisica() + champion.getHabilidadeComSabre() + champion.getMental())
				* champion.getAfinadadeForca();
	}

	private Long calculateDefense(CampeaoAPI champion) {
		return (champion.getForcaFisica() + champion.getPrevisao()) * champion.getAfinadadeForca();
	}

	private void validateChampionData(CampeaoAPI champion) throws DuelException {
		if (Objects.isNull(champion)) {
			throw new DuelException("Campeão não encontrado.");
		}
		if (StringUtils.isBlank(champion.getEmail())) {
			throw new DuelException("Campeão não possui email cadastrado.");
		}
		if (Objects.isNull(champion.getForcaFisica())) {
			throw new DuelException("Campeão não possui força fisica.");
		}
		if (Objects.isNull(champion.getHabilidadeComSabre())) {
			throw new DuelException("Campeão não possui habilidades com o sabre");
		}
		if (Objects.isNull(champion.getMental())) {
			throw new DuelException("Campeão não possui habilidade mental");
		}
		if (Objects.isNull(champion.getAfinadadeForca())) {
			throw new DuelException("Campeão não possui afinidade com a força");
		}
		if (Objects.isNull(champion.getPrevisao())) {
			throw new DuelException("Campeão não possui previsão");
		}
	}

}