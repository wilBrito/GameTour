package com.tfc.torneo.restJpa.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfc.torneo.restJpa.modelo.beans.Torneo;
import com.tfc.torneo.restJpa.repository.TorneoRepository;

@Service
public class TorneoServiceImplMysql8 implements IntTorneoService{
	@Autowired
	private TorneoRepository tRep;

	@Override
	public List<Torneo> allTorneos() {
		return (List<Torneo>) tRep.findAll();
	}

	@Override
	public Integer countTorneo() {
		return tRep.countTorneo();
	}

	@Override
	public int addTorneo(Torneo torneo) {
		int filas = 0;
		try {
			tRep.save(torneo);
			filas = 1;
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		return filas;
	}

	@Override
	public List<Torneo> findByNombreLike(String nombre) {
		return tRep.findByNombreContaining(nombre);
	}

	@Override
	public List<Torneo> buscByVideo(String videojuego) {
		return tRep.buscByVideo(videojuego);
	}

	@Override
	public int editByTorneo(Torneo torneo) {
		int flag = 0;
		try {
			tRep.save(torneo);
			flag = 1;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Torneo> findListTorByUsu(String idUsuario) {
		return tRep.findListTorByUsu(idUsuario);
	}

}
