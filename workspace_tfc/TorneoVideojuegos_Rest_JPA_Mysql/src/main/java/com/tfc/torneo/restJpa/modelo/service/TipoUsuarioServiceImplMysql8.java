package com.tfc.torneo.restJpa.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfc.torneo.restJpa.modelo.beans.TipoUsuario;
import com.tfc.torneo.restJpa.repository.TipoUsuarioRepository;

@Service
public class TipoUsuarioServiceImplMysql8 implements IntTipoUsuarioService{
	@Autowired
	private TipoUsuarioRepository tuRep;
	
	@Override
	public TipoUsuario selectTipoUsuario(int idTusu) {
		return tuRep.selectTipoUsuario(idTusu);
	}

}
