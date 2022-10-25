package com.tfc.torneo.restJpa.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfc.torneo.restJpa.modelo.beans.TipoPriv;
import com.tfc.torneo.restJpa.modelo.beans.TipoUsuario;
import com.tfc.torneo.restJpa.modelo.beans.Usuario;
import com.tfc.torneo.restJpa.modelo.service.TarjetaServiceImplMysql8;
import com.tfc.torneo.restJpa.modelo.service.TipoPrivServiceImplMysql8;
import com.tfc.torneo.restJpa.modelo.service.TipoUsuarioServiceImplMysql8;
import com.tfc.torneo.restJpa.modelo.service.UsuarioServiceImplMysql8;

@RestController
@CrossOrigin
@RequestMapping("/rest/usuario")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioServiceImplMysql8 uSer;
	
	@Autowired
	private TipoUsuarioServiceImplMysql8 tuSer;
	
	@Autowired
	private TipoPrivServiceImplMysql8 tpSer;
	
	@Autowired
	private TarjetaServiceImplMysql8 tSer;
	
	@PostMapping("/alta")
	public int procAlta(@RequestBody Usuario usuario) {
		
		
		int aux = 0; 
		
		if(uSer.findUserByNick(usuario.getNick())==null && uSer.findUserByEmail(usuario.getEmail())==null) {
			
			usuario.setIdUsuario("USU"+ uSer.countUser());
			usuario.setTipoUsuario(tuSer.selectTipoUsuario(1));
			ArrayList<TipoPriv> tpv = new ArrayList<TipoPriv>();
			tpv.add(tpSer.selectTipoPriv(1));
			usuario.setTipoPrivs(tpv);
	
			uSer.addUsuario(usuario);
			
			aux = 1;
		}
		
		return aux;
	}

	@PostMapping("/iniciar/{nick}/{clave}")
	public Usuario procIniSe(@PathVariable String nick, @PathVariable String clave) {
		Usuario usu = null;
		
		if(uSer.findByUsuByNickAndClave(nick, clave) != null) {
			usu = uSer.findUserByNick(nick);
		}
		
		return usu;
	}
	
	@GetMapping("/mostrarUsu/{idUsuario}")
	public Usuario mostrUsu(@PathVariable String idUsuario) {
		return uSer.findByIdUsuario(idUsuario);
	}
	

	@PutMapping("/editarUsu")
	public int editUsu(@RequestBody Usuario usuario) {
		int flag = 1;
		Usuario u = uSer.findByIdUsuario(usuario.getIdUsuario());
		
		usuario.setTarjetas(u.getTarjetas());
		usuario.setTipoPrivs(u.getTipoPrivs());
		usuario.setTipoUsuario(tuSer.selectTipoUsuario(1)); // Esto es solo para probar
		//ArrayList<TipoPriv> tpv = new ArrayList<TipoPriv>();
		//tpv.add(tpSer.selectTipoPriv(1));
		//usuario.setTipoPrivs(tpv);
		
		uSer.editByUsuario(usuario);
		return flag;
	}
	
	@GetMapping("/tipoUsu/{idUsuario}")
	public TipoUsuario buscTipoUsu(@PathVariable String idUsuario) {
		return  uSer.findByIdUsuario(idUsuario).getTipoUsuario();
	}
	
	@PutMapping("/suscribirseTusu/{idUsuario}/{idTusu}/{numero}")
	public int subTusu(@PathVariable String idUsuario, @PathVariable int idTusu, @PathVariable String numero) {
		int flag = 0;
		if(tSer.findByNum(numero) != null) {
			Usuario u = uSer.findByIdUsuario(idUsuario);
			u.setTipoUsuario(tuSer.selectTipoUsuario(idTusu));
			uSer.editByUsuario(u);
			flag = 1;
		}
		
		
		return flag;
	}
	
	
	
	
	
	
	
	
	
	
}
