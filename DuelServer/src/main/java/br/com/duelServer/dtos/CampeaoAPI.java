package br.com.duelServer.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CampeaoAPI {

	private String nome;
	private String email;
	private String corSabre;
	private String erro;

	private TipoCampeaoAPI tipoCapeao;

	private Long hp;
	private Long forcaFisica;
	private Long mental;
	private Long previsao;
	private Long habilidadeComSabre;
	private Long afinadadeForca;

}