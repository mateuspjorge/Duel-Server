package br.com.duelServer.dtos;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DuelDTO implements Serializable {

	private static final long serialVersionUID = 6862841462026341003L;

	private Long id;

	private Long champion;

	private Long rival;

	private Long winner;

}