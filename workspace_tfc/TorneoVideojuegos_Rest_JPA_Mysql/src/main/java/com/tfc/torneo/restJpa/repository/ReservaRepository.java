package com.tfc.torneo.restJpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tfc.torneo.restJpa.modelo.beans.Reserva;

public interface ReservaRepository extends CrudRepository<Reserva, String>{
	@Query("select count(idReserva) from Reserva")
	Integer countReserva();
	
	@Query("select r from Reserva r where r.torneo.idTorneo = ?1 and r.usuario.idUsuario = ?2")
	Reserva findReserByUsuAndTor(String idTorneo, String idUsuario);
	
	@Query("select r from Reserva r where r.usuario.idUsuario = ?1")
	List<Reserva> findListtReserByIdUsuario(String idUsuario);
}
