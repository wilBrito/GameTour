package com.tfc.torneo.restJpa.modelo.service;


import com.tfc.torneo.restJpa.modelo.beans.Usuario;

public interface IntUsuarioService {
	
	Usuario findByIdUsuario(String idUsuario);
	Usuario findUserByNick(String nick);
	Usuario findUserByEmail(String email);
	Usuario findByUsuByNickAndClave(String nick, String clave);
	
	int addUsuario(Usuario usuario);
	int editByUsuario(Usuario usuario);
	
	Integer countUser();
	
}
