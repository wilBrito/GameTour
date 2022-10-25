package com.tfc.torneo.restJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfc.torneo.restJpa.modelo.beans.Torneo;
import com.tfc.torneo.restJpa.modelo.service.IntTipoJuegoService;
import com.tfc.torneo.restJpa.modelo.service.IntTorneoService;
import com.tfc.torneo.restJpa.modelo.service.IntUsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/rest/torneo")
public class TorneoRestController {
	@Autowired
	private IntTorneoService tSer;
	@Autowired 
	private IntTipoJuegoService tjSer;
	@Autowired
	private IntUsuarioService uSer;
	
	@GetMapping("/todos")
	public List<Torneo> allTorneo(){
		return tSer.allTorneos();
	}
	
	@PostMapping("/crearTorneo/{idUsuario}/{tJuego}")
	public int crearTorneo(@RequestBody Torneo torneo, @PathVariable String idUsuario, @PathVariable String tJuego){
		int flag = 1;
		
		torneo.setIdTorneo("TOR" + tSer.countTorneo());
		torneo.setEstado("Activo");
		torneo.setTipoJuego(tjSer.findTiJuByVideo(tJuego));
		torneo.setUsuario(uSer.findByIdUsuario(idUsuario));
		
		tSer.addTorneo(torneo);
		
		return flag;
	}
	
	@GetMapping("/buscador/{nombre}")
	public List<Torneo> mostrarBusqueda(@PathVariable String nombre){
		return tSer.findByNombreLike(nombre);
	}
	
	@GetMapping("/buscadorTj/{videojuego}")
	public List<Torneo> mostrarBusquedaTj(@PathVariable String videojuego){
		System.err.println(videojuego);
		return tSer.buscByVideo(videojuego);
	}

	@GetMapping("/todosCreados/{idUsuario}")
	public List<Torneo> allTorneosCreados(@PathVariable String idUsuario){
		return tSer.findListTorByUsu(idUsuario);
	}
}
