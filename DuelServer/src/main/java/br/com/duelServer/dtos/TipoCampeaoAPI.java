package br.com.duelServer.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TipoCampeaoAPI {

	private String nomeTecnico;
	private String descricao;

}