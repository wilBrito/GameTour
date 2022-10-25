package com.tfc.torneo.restJpa.modelo.service;

import java.util.List;

import com.tfc.torneo.restJpa.modelo.beans.Torneo;

public interface IntTorneoService {

	List<Torneo> allTorneos();
	int addTorneo(Torneo torneo);
	int editByTorneo(Torneo torneo);
	
	Integer countTorneo();
	
	List<Torneo> findByNombreLike(String nombre);
	List<Torneo> buscByVideo(String videojuego);
	List<Torneo> findListTorByUsu(String idUsuario);
}
