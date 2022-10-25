package com.tfc.torneo.restJpa.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the monedero database table.
 * 
 */
@Entity
@NamedQuery(name="Monedero.findAll", query="SELECT m FROM Monedero m")
public class Monedero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_MONEDERO")
	private String idMonedero;

	private int token;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public Monedero() {
	}

	public String getIdMonedero() {
		return this.idMonedero;
	}

	public void setIdMonedero(String idMonedero) {
		this.idMonedero = idMonedero;
	}

	public int getToken() {
		return this.token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}