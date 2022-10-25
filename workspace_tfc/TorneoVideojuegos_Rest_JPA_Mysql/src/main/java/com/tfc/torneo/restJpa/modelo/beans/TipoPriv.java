package com.tfc.torneo.restJpa.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_priv database table.
 * 
 */
@Entity
@Table(name="tipo_priv")
@NamedQuery(name="TipoPriv.findAll", query="SELECT t FROM TipoPriv t")
public class TipoPriv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TPRIV")
	private int idTpriv;

	private String descripcion;

	public TipoPriv() {
	}

	public int getIdTpriv() {
		return this.idTpriv;
	}

	public void setIdTpriv(int idTpriv) {
		this.idTpriv = idTpriv;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}