package com.migraciones.sigesth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.migraciones.sigesth.dto.AdministradorDto;
import com.migraciones.sigesth.service.AdministradorService;

@RestController
public class AdministradorController {

	@Autowired
	AdministradorService admService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public AdministradorDto getByLogin(String username, String password) {
		return admService.getByLogin(username, password);
	}
}
