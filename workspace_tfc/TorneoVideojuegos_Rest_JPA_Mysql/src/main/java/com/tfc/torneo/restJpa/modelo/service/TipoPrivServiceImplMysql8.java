package com.tfc.torneo.restJpa.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfc.torneo.restJpa.modelo.beans.TipoPriv;
import com.tfc.torneo.restJpa.repository.TipoPrivRepository;

@Service
public class TipoPrivServiceImplMysql8 implements IntTipoPrivService{

	@Autowired
	private TipoPrivRepository tpRep;
	
	@Override
	public TipoPriv selectTipoPriv(int idTpriv) {
		return tpRep.selectTipoPriv(idTpriv);
	}

}
