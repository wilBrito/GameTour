package com.tfc.torneo.restJpa.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ligas database table.
 * 
 */
@Entity
@Table(name="ligas")
@NamedQuery(name="Liga.findAll", query="SELECT l FROM Liga l")
public class Liga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_LIGA")
	private String idLiga;

	private String descripcion;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FECH_FIN")
	private Date fechFin;

	@Temporal(TemporalType.DATE)
	@Column(name="FECH_INIC")
	private Date fechInic;

	private String nombre;

	//uni-directional many-to-one association to TipoJuego
	@ManyToOne
	@JoinColumn(name="ID_TJUEGO")
	private TipoJuego tipoJuego;

	//bi-directional many-to-many association to Club
	@ManyToMany
	@JoinTable(
		name="ligas_clubs"
		, joinColumns={
			@JoinColumn(name="ID_LIGA")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_CLUB")
			}
		)
	private List<Club> clubs;

	public Liga() {
	}

	public String getIdLiga() {
		return this.idLiga;
	}

	public void setIdLiga(String idLiga) {
		this.idLiga = idLiga;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechFin() {
		return this.fechFin;
	}

	public void setFechFin(Date fechFin) {
		this.fechFin = fechFin;
	}

	public Date getFechInic() {
		return this.fechInic;
	}

	public void setFechInic(Date fechInic) {
		this.fechInic = fechInic;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoJuego getTipoJuego() {
		return this.tipoJuego;
	}

	public void setTipoJuego(TipoJuego tipoJuego) {
		this.tipoJuego = tipoJuego;
	}

	public List<Club> getClubs() {
		return this.clubs;
	}

	public void setClubs(List<Club> clubs) {
		this.clubs = clubs;
	}

}