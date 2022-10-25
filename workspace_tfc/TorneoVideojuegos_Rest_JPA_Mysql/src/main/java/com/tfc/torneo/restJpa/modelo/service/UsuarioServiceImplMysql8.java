package com.tfc.torneo.restJpa.modelo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tfc.torneo.restJpa.modelo.beans.Usuario;
import com.tfc.torneo.restJpa.repository.UsuarioRepository;

@Service
public class UsuarioServiceImplMysql8 implements IntUsuarioService{
	@Autowired
	private UsuarioRepository uRep; 

	@Override
	public Usuario findByIdUsuario(String idUsuario) {
		return uRep.findById(idUsuario).orElse(null);
	}

	@Override
	public int addUsuario(Usuario usuario) {
		int filas = 0;
		try {
			uRep.save(usuario);
			filas = 1;
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		return filas;
	}

	@Override
	public Usuario findUserByNick(String nick) {
		return uRep.findUserByNick(nick);
	}

	@Override
	public Usuario findUserByEmail(String email) {
		return uRep.findUserByEmail(email);
	}

	@Override
	public Integer countUser() {
		return uRep.countUser();
	}

	@Override
	public Usuario findByUsuByNickAndClave(String nick, String clave) {
		return uRep.findByUsuByNickAndClave(nick, clave);
	}

	@Override
	public int editByUsuario(Usuario usuario) {
		int flag = 0;
		try {
			uRep.save(usuario);
			flag = 1;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	

}
