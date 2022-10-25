package com.tfc.torneo.restJpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tfc.torneo.restJpa.modelo.beans.TipoUsuario;

public interface TipoUsuarioRepository extends CrudRepository<TipoUsuario, Integer>{
	
	@Query("select tu from TipoUsuario tu where tu.idTusu = ?1")
	TipoUsuario selectTipoUsuario(int idTusu);

}
