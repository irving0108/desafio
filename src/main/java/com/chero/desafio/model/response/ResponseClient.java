package com.chero.desafio.model.response;

import java.io.Serializable;

public class ResponseClient implements Serializable{
	private static final long serialVersionUID = 1L;
	private int status;
	private String message;
	
	public ResponseClient() {
		super();
	}

	public ResponseClient(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
