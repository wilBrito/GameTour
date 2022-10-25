package com.tfc.torneo.restJpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tfc.torneo.restJpa.modelo.beans.TipoJuego;

public interface TipoJuegoRepository extends CrudRepository<TipoJuego, Integer>{
	@Query("select t from TipoJuego t where t.videojuego = ?1")
	TipoJuego findTiJuByVideo(String videojuego);
}
