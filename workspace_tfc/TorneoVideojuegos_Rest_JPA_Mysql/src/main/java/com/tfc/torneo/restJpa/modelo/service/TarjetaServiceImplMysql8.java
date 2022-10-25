package com.tfc.torneo.restJpa.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfc.torneo.restJpa.modelo.beans.Tarjeta;
import com.tfc.torneo.restJpa.repository.TarjetaRepository;

@Service
public class TarjetaServiceImplMysql8 implements IntTarjetaService{
	
	@Autowired
	private TarjetaRepository tRep;
	
	@Override
	public int addTarjeta(Tarjeta tarjeta) {
		int flag = 0;
		try {
			tRep.save(tarjeta);
			flag = 1;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Tarjeta findByNum(String numero) {
		return tRep.findById(numero).orElse(null);
	}

	@Override
	public int deleteTarjeta(Tarjeta tarjeta) {
		int flag = 0;
		try {
			tRep.delete(tarjeta);
			flag = 1;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
