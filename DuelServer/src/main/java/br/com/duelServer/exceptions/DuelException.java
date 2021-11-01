package br.com.duelServer.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DuelException extends Exception {

	private static final long serialVersionUID = 5506758880812750233L;

	private String msg;

	public DuelException(String msg) {
		super(msg);
		this.msg = msg;
	}

}