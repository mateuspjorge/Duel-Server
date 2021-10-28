package br.com.duelServer.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampeaoException extends Exception {

	private static final long serialVersionUID = -7313819224288459830L;

	private String msg;

	public CampeaoException(String msg) {
		super(msg);
		this.msg = msg;
	}

}