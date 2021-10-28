package br.com.duelServer.dtos;

import java.io.Serializable;

import br.com.duelServer.entitys.Duel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DuelDTO implements Serializable {

	private static final long serialVersionUID = 6862841462026341003L;

	private Long id;

	private String champion;

	private String rival;

	private String winner;

	public static DuelDTO convertDuelToDto(Duel duel) {
		return DuelDTO.builder()
					  .champion(duel.getChampion())
					  .rival(duel.getRival())
					  .winner(duel.getWinner())
					  .build();
	}

}