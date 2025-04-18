package com.github.marcosws.crs.service;

public enum LoginStatus {
	
	EMPTY_PASSWORD("Senha vazia"),
	DIFFERENT_PASSWORD("Senhas diferentes"),
	RESET_PASSWORD("Alterar senha"),
	INACTIVE("Usuário inativo"),
	INVALID_USER_AND_PASSWORD("Login e senha incorretos"),
	USER_OK("Ok");

	private final String status;
	
	LoginStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	

}
