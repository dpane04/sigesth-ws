package com.migraciones.sigesth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.migraciones.sigesth.dao.AdministradorDao;
import com.migraciones.sigesth.dto.AdministradorDto;

@Service
public class AdministradorService implements IAdministradorService {

	@Autowired
	AdministradorDao administradorDao;

	@Override
	public List<AdministradorDto> getAll() {
		return administradorDao.getAll();
	}

	@Override
	public AdministradorDto getByLogin(String login, String password) {
		return administradorDao.getByLogin(login, password);
	}

}
