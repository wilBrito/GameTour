package com.tfc.torneo.restJpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tfc.torneo.restJpa.modelo.beans.Torneo;


public interface TorneoRepository extends CrudRepository<Torneo, String>{
	@Query("select count(idTorneo) from Torneo")
	Integer countTorneo();
	
	@Query("select t from Torneo t where t.tipoJuego.videojuego = ?1")
	List<Torneo> buscByVideo(String videojuego);
	
	@Query("select t from Torneo t where t.usuario.idUsuario = ?1")
	List<Torneo> findListTorByUsu(String idUsuario);
	
	List<Torneo> findByNombreContaining(@Param("nombre")String nombre);
}
