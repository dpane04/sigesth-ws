package com.migraciones.sigesth.dao;

import java.util.List;

import com.migraciones.sigesth.dto.AdministradorDto;


public interface IAdministradorDao {

	List<AdministradorDto> getAll();

	AdministradorDto getByLogin(String login, String password);
}
