package com.tfc.torneo.restJpa.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfc.torneo.restJpa.modelo.beans.Reserva;
import com.tfc.torneo.restJpa.repository.ReservaRepository;

@Service
public class ReservaServiceImplMysql8 implements IntReservaService{
	@Autowired
	private ReservaRepository rRep;

	@Override
	public int addReserva(Reserva reserva) {
		int filas = 0;
		try {
			rRep.save(reserva);
			filas = 1;
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		return filas;
	}

	@Override
	public Integer countReserva() {
		return rRep.countReserva();
	}

	@Override
	public Reserva findReserByUsuAndTor(String idTorneo, String idUsuario) {
		return rRep.findReserByUsuAndTor(idTorneo, idUsuario);
	}

	@Override
	public List<Reserva> findListtReserByIdUsuario(String idUsuario) {
		return rRep.findListtReserByIdUsuario(idUsuario);
	}

}
