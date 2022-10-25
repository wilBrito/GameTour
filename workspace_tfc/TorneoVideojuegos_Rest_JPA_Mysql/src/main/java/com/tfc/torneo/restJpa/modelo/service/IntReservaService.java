package com.tfc.torneo.restJpa.modelo.service;

import java.util.List;

import com.tfc.torneo.restJpa.modelo.beans.Reserva;

public interface IntReservaService {
	int addReserva(Reserva reserva);
	
	Integer countReserva();
	Reserva findReserByUsuAndTor(String idTorneo, String idUsuario);
	
	List<Reserva> findListtReserByIdUsuario(String idUsuario);

}
