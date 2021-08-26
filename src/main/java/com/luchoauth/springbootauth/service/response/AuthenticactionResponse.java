package com.luchoauth.springbootauth.service.response;

import java.io.Serializable;

public class AuthenticactionResponse implements Serializable{

	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private String token;
	
	private static final String TYPE = "Bearer";
	
	private int id;
	
	private String usuario;
	
	public AuthenticactionResponse(String token, Integer id, String userName) {
		this.token = token;
		this.id = id;
		this.usuario = userName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getType() {
		return TYPE;
	}
	
}
