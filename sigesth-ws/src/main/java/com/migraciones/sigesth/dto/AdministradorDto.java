package com.migraciones.sigesth.dto;

import java.io.Serializable;

public class AdministradorDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String cedula;
	private String login;
	private int tipo;

	public AdministradorDto() {
	}

	public AdministradorDto(String cedula, String login, String password, int tipo) {
		this.cedula = cedula;
		this.login = login;
		this.tipo = tipo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
