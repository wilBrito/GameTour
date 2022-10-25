package com.tfc.torneo.restJpa.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tarjetas database table.
 * 
 */
@Entity
@Table(name="tarjetas")
@NamedQuery(name="Tarjeta.findAll", query="SELECT t FROM Tarjeta t")
public class Tarjeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String numero;

	private int cvv;

	@Temporal(TemporalType.DATE)
	@Column(name="FECH_CADUCIDAD")
	private Date fechCaducidad;

	private String propietario;

	public Tarjeta() {
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getCvv() {
		return this.cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public Date getFechCaducidad() {
		return this.fechCaducidad;
	}

	public void setFechCaducidad(Date fechCaducidad) {
		this.fechCaducidad = fechCaducidad;
	}

	public String getPropietario() {
		return this.propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

}