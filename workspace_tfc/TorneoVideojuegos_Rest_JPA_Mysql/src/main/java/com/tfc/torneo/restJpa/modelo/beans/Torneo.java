package com.tfc.torneo.restJpa.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the torneos database table.
 * 
 */
@Entity
@Table(name="torneos")
@NamedQuery(name="Torneo.findAll", query="SELECT t FROM Torneo t")
public class Torneo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TORNEO")
	private String idTorneo;

	private String descripcion;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FECH_FIN")
	private Date fechFin;

	@Temporal(TemporalType.DATE)
	@Column(name="FECH_INIC")
	private Date fechInic;

	private String img;

	private String nombre;

	private int plazas;

	private BigDecimal precio;

	//uni-directional many-to-one association to TipoJuego
	@ManyToOne
	@JoinColumn(name="ID_TJUEGO")
	private TipoJuego tipoJuego;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;
	

	private String moda;
	private Time hora;

	public Torneo() {
	}

	public String getIdTorneo() {
		return this.idTorneo;
	}

	public void setIdTorneo(String idTorneo) {
		this.idTorneo = idTorneo;
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

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPlazas() {
		return this.plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public TipoJuego getTipoJuego() {
		return this.tipoJuego;
	}

	public void setTipoJuego(TipoJuego tipoJuego) {
		this.tipoJuego = tipoJuego;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getModa() {
		return moda;
	}

	public void setModa(String moda) {
		this.moda = moda;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	

	
	

}