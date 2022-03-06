package com.springwebjpa.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="cuenta")
public class Cuenta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	private String numero_cuenta;
	
	@NotEmpty
	private String nombre_cuenta;
	
	
	private Double monto_apertura;
	
	
	@Temporal(TemporalType.DATE)
	private Date fecha_apertura;
	
	
	private Double saldo;
	
	
	private char estado_cuenta;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Cliente cliente;
	
	
	@OneToMany(mappedBy="cuenta",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Transaccion> transacciones;
	
	
	
	
	@PrePersist //Lo que este bajo esta notacion se invoca justo antes de insertar el registro en la base de datos
	public void prePersist() {
		
		fecha_apertura = new Date();
		Random num = new Random();
		
		this.saldo = this.monto_apertura;
		this.numero_cuenta = String.valueOf(this.cliente.getNombre().substring(0, 1) + this.cliente.getApellidos().substring(0, 1)+ (num.nextInt(7500-205+10)+250));
	}
	
	
	public Cuenta() {
		this.transacciones = new ArrayList<Transaccion>();
	}

	public String getNumero_cuenta() {
		return numero_cuenta;
	}
	public void setNumero_cuenta(String numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}
	public String getNombre_cuenta() {
		return nombre_cuenta;
	}
	public void setNombre_cuenta(String nombre_cuenta) {
		this.nombre_cuenta = nombre_cuenta;
	}
	public Double getMonto_apertura() {
		return monto_apertura;
	}
	public void setMonto_apertura(Double monto_apertura) {
		this.monto_apertura = monto_apertura;
	}
	public Date getFecha_apertura() {
		return fecha_apertura;
	}
	public void setFecha_apertura(Date fecha_apertura) {
		this.fecha_apertura = fecha_apertura;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	@JsonBackReference
	public Cliente getCod_cliente() {
		return cliente;
	}
	public void setCod_cliente(Cliente cod_cliente) {
		this.cliente = cod_cliente;
	}
	public char getEstado_cuenta() {
		return estado_cuenta;
	}
	public void setEstado_cuenta(char estado_cuenta) {
		this.estado_cuenta = estado_cuenta;
	}
	@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	public List<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}

	public void addTransaccion (Transaccion transaccion) {
		transacciones.add(transaccion);
	}
	
	
	
}
