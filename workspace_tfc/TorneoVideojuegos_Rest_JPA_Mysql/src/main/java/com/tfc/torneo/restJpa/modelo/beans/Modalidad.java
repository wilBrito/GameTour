package com.tfc.torneo.restJpa.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the modalidad database table.
 * 
 */
@Entity
@NamedQuery(name="Modalidad.findAll", query="SELECT m FROM Modalidad m")
public class Modalidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_MODALIDAD")
	private int idModalidad;

	private String descripcion;

	public Modalidad() {
	}

	public int getIdModalidad() {
		return this.idModalidad;
	}

	public void setIdModalidad(int idModalidad) {
		this.idModalidad = idModalidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}