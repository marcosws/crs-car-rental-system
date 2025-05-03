package com.github.marcosws.crs.model.service.utils;

public enum LoginStatus {
	
	EMPTY_PASSWORD("Senha vazia"),
	DIFFERENT_PASSWORD("Senhas diferentes"),
	NEW_PASSWORD_EQUALS_TO_ACTUAL("A nova senha é igual a senha atual"),
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
