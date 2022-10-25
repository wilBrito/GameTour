package com.tfc.torneo.restJpa.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the reservas database table.
 * 
 */
@Entity
@Table(name="reservas")
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_RESERVA")
	private String idReserva;

	@Temporal(TemporalType.DATE)
	@Column(name="FECH_RESERVA")
	private Date fechReserva;

	private String posi;

	private BigDecimal precio;

	//uni-directional many-to-one association to Torneo
	@ManyToOne
	@JoinColumn(name="ID_TORNEO")
	private Torneo torneo;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public Reserva() {
	}

	public String getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}

	public Date getFechReserva() {
		return this.fechReserva;
	}

	public void setFechReserva(Date fechReserva) {
		this.fechReserva = fechReserva;
	}

	public String getPosi() {
		return this.posi;
	}

	public void setPosi(String posi) {
		this.posi = posi;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Torneo getTorneo() {
		return this.torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}