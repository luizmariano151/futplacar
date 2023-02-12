package com.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.entities.Campeonato;
import com.backend.services.CampeonatoService;

@RestController
@RequestMapping(value = "/campeonatos")
public class CampeonatoController {
	
	@Autowired
	private CampeonatoService service;
	
	@GetMapping("/jogos-de-hoje")
	public ResponseEntity<List<Campeonato>> findTodayMatches (){
		List<Campeonato> campeonatos = service.findTodayMatches();
		return ResponseEntity.status(HttpStatus.OK).body(campeonatos);
	}
	
}
