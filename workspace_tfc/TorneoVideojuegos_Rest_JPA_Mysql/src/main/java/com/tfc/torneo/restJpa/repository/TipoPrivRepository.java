package com.tfc.torneo.restJpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tfc.torneo.restJpa.modelo.beans.TipoPriv;

public interface TipoPrivRepository extends CrudRepository<TipoPriv, Integer>{
	
	@Query("select tp from TipoPriv tp where tp.idTpriv = ?1")
	TipoPriv selectTipoPriv(int idTpriv);

}
