package com.tfc.torneo.restJpa.modelo.service;

import com.tfc.torneo.restJpa.modelo.beans.Tarjeta;

public interface IntTarjetaService {

	int addTarjeta(Tarjeta tarjeta);
	int deleteTarjeta(Tarjeta tarjeta);
	
	Tarjeta findByNum(String numero);
}
