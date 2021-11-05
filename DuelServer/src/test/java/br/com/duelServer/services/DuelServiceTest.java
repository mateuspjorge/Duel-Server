package br.com.duelServer.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.duelServer.dtos.CampeaoAPI;
import br.com.duelServer.dtos.TipoCampeaoAPI;
import br.com.duelServer.entitys.Duel;
import br.com.duelServer.exceptions.DuelException;
import br.com.duelServer.repositorys.IDuelRepository;
import br.com.duelServer.services.impl.DuelServiceImpl;

@SpringBootTest
public class DuelServiceTest {

	@Mock
	IDuelRepository duelRepository;

	@InjectMocks
	DuelServiceImpl duelServiceImpl;

	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldStartDuelSuccessfully() throws DuelException {
		CampeaoAPI champion = createCampeaoAPI("Gimli", "gimli@gmail.com", "verde", 300L, 50L, 5L, 5L, 15L, 5L);
		champion.setTipoCapeao(createTipoCampeaoAPI());
		CampeaoAPI rival = createCampeaoAPI("Legolas", "legolas@gmail.com", "azul", 150L, 20L, 30L, 25L, 50L, 30L);
		rival.setTipoCapeao(createTipoCampeaoAPI());
		when(duelRepository.save(any())).thenReturn(createDuel(1L, "gimli@gmail.com", "legolas@gmail.com", "legolas@gmail.com"));
		Assert.assertNotNull(duelServiceImpl.startDuel(champion, rival));
	}

	private CampeaoAPI createCampeaoAPI(String nome, String email, String sabre, Long hp,
			Long forca, Long mental, Long previsao, Long habilidade, Long afinidade) {
		return CampeaoAPI.builder()
						 .nome(nome)
						 .email(email)
						 .corSabre(sabre)
						 .hp(hp)
						 .forcaFisica(forca)
						 .mental(mental)
						 .previsao(previsao)
						 .habilidadeComSabre(habilidade)
						 .afinadadeForca(afinidade)
						 .build();
	}

	private TipoCampeaoAPI createTipoCampeaoAPI() {
		return TipoCampeaoAPI.builder().nomeTecnico("JEDI").descricao("JEDI").build();
	}

	private Duel createDuel(Long id, String champion, String rival, String winner) {
		return Duel.builder()
				   .id(id)
				   .champion(champion)
				   .rival(rival)
				   .winner(winner)
				   .build();
	}

}