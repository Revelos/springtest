package com.springwebjpa.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="tipo_transaccion")
public class TipoTransaccion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer id_tipo_transaccion;
	
	@NotEmpty
	private String nombre_transaccion;
	
	
	public Integer getId_tipo_transaccion() {
		return id_tipo_transaccion;
	}
	public void setId_tipo_transaccion(Integer id_tipo_transaccion) {
		this.id_tipo_transaccion = id_tipo_transaccion;
	}
	public String getNombre_transaccion() {
		return nombre_transaccion;
	}
	public void setNombre_transaccion(String nombre_transaccion) {
		this.nombre_transaccion = nombre_transaccion;
	}
}
