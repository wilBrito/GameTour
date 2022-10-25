package com.tfc.torneo.restJpa.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.tfc.torneo.restJpa.modelo.beans.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
	
	@Query("select u from Usuario u where u.nick = ?1")
	Usuario findUserByNick(String nick);
	
	@Query("select u from Usuario u where u.email = ?1")
	Usuario findUserByEmail(String email);
	
	@Query("select count(nick) from Usuario")
	Integer countUser();
	
	@Query("select u from Usuario u where u.nick = ?1 and u.clave = ?2")
	Usuario findByUsuByNickAndClave(String nick, String clave);
	
}

