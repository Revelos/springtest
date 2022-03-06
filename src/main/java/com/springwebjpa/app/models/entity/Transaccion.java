package com.springwebjpa.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="transaccion") 
public class Transaccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_transaccion;
	
	@NotNull
	private Double valor_monetario;
	
	
	@Temporal(TemporalType.DATE)
	private Date fecha_transaccion;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="id_tipo_transaccion")
	private TipoTransaccion tipo_transaccion;
	
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	private Cuenta cuenta;
	
	@PrePersist //Lo que este bajo esta notacion se invoca justo antes de insertar el registro en la base de datos
	public void prePersist() {
		fecha_transaccion = new Date();
	}
	
	public Integer getId_transaccion() {
		return id_transaccion;
	}
	public void setId_transaccion(Integer id_transaccion) {
		this.id_transaccion = id_transaccion;
	}
	public Double getValor_monetario() {
		return valor_monetario;
	}
	public void setValor_monetario(Double valor_monetario) {
		this.valor_monetario = valor_monetario;
	}
	public Date getFecha_transaccion() {
		return fecha_transaccion;
	}
	public void setFecha_transaccion(Date fecha_transaccion) {
		this.fecha_transaccion = fecha_transaccion;
	}
	@JsonBackReference
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	@JsonIgnore
	public TipoTransaccion getTipo_transaccion() {
		return tipo_transaccion;
	}
	public void setTipo_transaccion(TipoTransaccion tipo_transaccion) {
		this.tipo_transaccion = tipo_transaccion;
	}
	

}
