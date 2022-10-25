package com.tfc.torneo.restJpa.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clubs database table.
 * 
 */
@Entity
@Table(name="clubs")
@NamedQuery(name="Club.findAll", query="SELECT c FROM Club c")
public class Club implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CLUB")
	private String idClub;

	private String nombre;

	//bi-directional many-to-many association to Liga
	@ManyToMany(mappedBy="clubs")
	private List<Liga> ligas;

	//uni-directional many-to-many association to TipoJuego
	@ManyToMany
	@JoinTable(
		name="tjuego_clubs"
		, joinColumns={
			@JoinColumn(name="ID_CLUB")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_TJUEGO")
			}
		)
	private List<TipoJuego> tipoJuegos;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="club")
	private List<Usuario> usuarios;

	public Club() {
	}

	public String getIdClub() {
		return this.idClub;
	}

	public void setIdClub(String idClub) {
		this.idClub = idClub;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Liga> getLigas() {
		return this.ligas;
	}

	public void setLigas(List<Liga> ligas) {
		this.ligas = ligas;
	}

	public List<TipoJuego> getTipoJuegos() {
		return this.tipoJuegos;
	}

	public void setTipoJuegos(List<TipoJuego> tipoJuegos) {
		this.tipoJuegos = tipoJuegos;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setClub(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setClub(null);

		return usuario;
	}

}