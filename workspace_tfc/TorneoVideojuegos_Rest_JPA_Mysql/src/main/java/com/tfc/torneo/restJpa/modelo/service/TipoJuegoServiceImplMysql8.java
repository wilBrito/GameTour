package com.tfc.torneo.restJpa.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfc.torneo.restJpa.modelo.beans.TipoJuego;
import com.tfc.torneo.restJpa.repository.TipoJuegoRepository;

@Service
public class TipoJuegoServiceImplMysql8 implements IntTipoJuegoService{
	
	@Autowired
	private TipoJuegoRepository tjRep;

	@Override
	public TipoJuego findTiJuByVideo(String videojuego) {
		return tjRep.findTiJuByVideo(videojuego);
	}

}
