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

import com.tfc.torneo.restJpa.modelo.beans.Reserva;
import com.tfc.torneo.restJpa.modelo.beans.Torneo;
import com.tfc.torneo.restJpa.modelo.service.IntReservaService;
import com.tfc.torneo.restJpa.modelo.service.IntTorneoService;
import com.tfc.torneo.restJpa.modelo.service.IntUsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/rest/reserva")
public class ReservaRestController {
	@Autowired
	private IntReservaService rSer;
	@Autowired
	private IntUsuarioService uSer;
	@Autowired 
	private IntTorneoService tSer;
	
	@PostMapping("/reTor/{idUsuario}")
	public int addReservaTor(@RequestBody Reserva reserva, @PathVariable String idUsuario) {
		int flag = 0;
		
		if(rSer.findReserByUsuAndTor(reserva.getTorneo().getIdTorneo(), idUsuario) == null) {
			reserva.setIdReserva("RE"+ rSer.countReserva());
			reserva.setUsuario(uSer.findByIdUsuario(idUsuario));
			rSer.addReserva(reserva);
			
			Torneo tr = reserva.getTorneo();
			tr.setPlazas(tr.getPlazas() - 1);
			tSer.editByTorneo(tr);
			
			flag = 1;
		}

		return flag;
	}
	
	@GetMapping("/todos/{idUsuario}")
	public List<Reserva> historialTor(@PathVariable String idUsuario){
		
		/*List<Torneo> aux = new ArrayList<Torneo>();
		
		for(int i = 0 ; i<listRe.size(); i++) {
			aux.add(listRe.get(i).getTorneo());
		}*/
		
		return rSer.findListtReserByIdUsuario(idUsuario);
	}
	
	
	
	
	

}
