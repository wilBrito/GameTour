package com.tfc.torneo.restJpa.modelo.service;

import com.tfc.torneo.restJpa.modelo.beans.TipoJuego;

public interface IntTipoJuegoService {

	TipoJuego findTiJuByVideo(String videojuego);
}
