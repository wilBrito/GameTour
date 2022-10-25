package com.tfc.torneo.restJpa.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUARIO")
	private String idUsuario;

	private String apellidos;

	private String clave;

	private String direccion;


	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="FECH_NAC")
	private Date fechNac;

	private String nick;

	private String nombre;

	//bi-directional many-to-one association to Club
	@ManyToOne
	@JoinColumn(name="ID_CLUB")
	private Club club;

	//uni-directional many-to-one association to TipoUsuario
	@ManyToOne
	@JoinColumn(name="ID_TUSU")
	private TipoUsuario tipoUsuario;

	//uni-directional many-to-many association to TipoPriv
	@ManyToMany
	@JoinTable(
		name="usuarios_priv"
		, joinColumns={
			@JoinColumn(name="ID_USUARIO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_TPRIV")
			}
		)
	private List<TipoPriv> tipoPrivs;

	//uni-directional many-to-many association to Tarjeta
	@ManyToMany
	@JoinTable(
		name="usuarios_tarjetas"
		, joinColumns={
			@JoinColumn(name="ID_USUARIO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="NUMERO")
			}
		)
	private List<Tarjeta> tarjetas;

	public Usuario() {
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechNac() {
		return this.fechNac;
	}

	public void setFechNac(Date fechNac) {
		this.fechNac = fechNac;
	}

	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Club getClub() {
		return this.club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<TipoPriv> getTipoPrivs() {
		return this.tipoPrivs;
	}

	public void setTipoPrivs(List<TipoPriv> tipoPrivs) {
		this.tipoPrivs = tipoPrivs;
	}

	public List<Tarjeta> getTarjetas() {
		return this.tarjetas;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

}