package com.tfc.torneo.restJpa.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_juego database table.
 * 
 */
@Entity
@Table(name="tipo_juego")
@NamedQuery(name="TipoJuego.findAll", query="SELECT t FROM TipoJuego t")
public class TipoJuego implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TJUEGO")
	private int idTjuego;

	private String videojuego;

	//uni-directional many-to-many association to Modalidad
	@ManyToMany
	@JoinTable(
		name="modalidad_tjuego"
		, joinColumns={
			@JoinColumn(name="ID_TJUEGO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_MODALIDAD")
			}
		)
	private List<Modalidad> modalidades;

	public TipoJuego() {
	}

	public int getIdTjuego() {
		return this.idTjuego;
	}

	public void setIdTjuego(int idTjuego) {
		this.idTjuego = idTjuego;
	}

	public String getVideojuego() {
		return this.videojuego;
	}

	public void setVideojuego(String videojuego) {
		this.videojuego = videojuego;
	}

	public List<Modalidad> getModalidades() {
		return this.modalidades;
	}

	public void setModalidades(List<Modalidad> modalidades) {
		this.modalidades = modalidades;
	}

}