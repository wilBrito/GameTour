package com.tfc.torneo.restJpa.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_usuario database table.
 * 
 */
@Entity
@Table(name="tipo_usuario")
@NamedQuery(name="TipoUsuario.findAll", query="SELECT t FROM TipoUsuario t")
public class TipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TUSU")
	private int idTusu;

	private String descripcion;

	public TipoUsuario() {
	}

	public int getIdTusu() {
		return this.idTusu;
	}

	public void setIdTusu(int idTusu) {
		this.idTusu = idTusu;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}