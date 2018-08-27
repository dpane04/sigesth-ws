package com.migraciones.sigesth.service;

import java.util.List;

import com.migraciones.sigesth.dto.AdministradorDto;


public interface IAdministradorService {

	List<AdministradorDto> getAll();

	AdministradorDto getByLogin(String login, String password);
}
