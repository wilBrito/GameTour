package com.tfc.torneo.restJpa.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfc.torneo.restJpa.modelo.beans.Tarjeta;
import com.tfc.torneo.restJpa.modelo.beans.Usuario;
import com.tfc.torneo.restJpa.modelo.service.IntTarjetaService;
import com.tfc.torneo.restJpa.modelo.service.IntUsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/rest/tarjeta")
public class TarjetaRestController {

	@Autowired
	private IntTarjetaService tSer;
	
	@Autowired
	private IntUsuarioService uSer;
	
	
	@GetMapping("/all/{idUsuario}")
	public List<Tarjeta> findAllByIdUsu(@PathVariable String idUsuario){
		//ArrayList<Tarjeta> aux = new ArrayList<Tarjeta>();
		//aux.add(tSer.findByNum("1122334455667788"));
		//aux.add(tSer.findByNum("1122334455667799"));
		
		//Usuario u = uSer.findByIdUsuario(idUsuario);
		//u.setTarjetas(aux);
		//uSer.editByUsuario(u);
		System.out.println(uSer.findByIdUsuario(idUsuario).getTarjetas());
		return uSer.findByIdUsuario(idUsuario).getTarjetas();
	}
	
	@GetMapping("/num/{numero}")
	public Tarjeta findTarByNum(@PathVariable String numero){
		return tSer.findByNum(numero);
	}
	
	@DeleteMapping("/deleteTar/{numero}/{idUsuario}")
	public int deleteTar(@PathVariable String numero, @PathVariable String idUsuario) {
		int flag  = 0;
		
		if(tSer.findByNum(numero) != null) {
			Usuario usuAux = uSer.findByIdUsuario(idUsuario);
			List<Tarjeta> listTar = usuAux.getTarjetas();
			for(int i = 0 ; i<listTar.size();i++) {
				if(listTar.get(i).getNumero().equals(numero)) {
					listTar.remove(i);
				}
			}
			tSer.deleteTarjeta(tSer.findByNum(numero));
			flag = 1;
		}
		
		return flag;
	}
	
	@PostMapping("/addTar/{idUsuario}")
	public int addTarjeta(@RequestBody Tarjeta tarjeta, @PathVariable String idUsuario) {
		int flag = 0;
		
		if(tSer.findByNum(tarjeta.getNumero()) == null) {
			tSer.addTarjeta(tarjeta);
			Usuario u = uSer.findByIdUsuario(idUsuario);
			
			List<Tarjeta> aux = u.getTarjetas();
			aux.add(tarjeta);
			u.setTarjetas(aux);
			uSer.editByUsuario(u);
			
			flag = 1;
		}
		
		return flag;
	}
	
	
	
	
	
}
