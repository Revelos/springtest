package com.springwebjpa.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_cliente;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellidos;
	
	@NotEmpty
	private String dui;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_registro")//Este solo se agrega si el campo no tiene el nombre exacto que en la tabla de la base de datos
	private Date creatAt;
	
	
	@OneToMany(mappedBy="cliente",fetch=FetchType.LAZY, cascade=CascadeType.ALL)//Carga perezosa se ejecuta cuando se invoca; realiza operaciones en cadena delete y update
	private List<Cuenta> cuentas;
	
	@PrePersist //Lo que este bajo esta notacion se invoca justo antes de insertar el registro en la base de datos
	public void prePersist() {
		creatAt = new Date();
	}
	
	
	public Cliente() {
		cuentas = new ArrayList<Cuenta>();
	}


	public Integer getCod_cliente() {
		return cod_cliente;
	}
	public void setCod_cliente(Integer cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDui() {
		return dui;
	}
	public void setDui(String dui) {
		this.dui = dui;
	}
	public Date getCreatAt() {
		return creatAt;
	}
	public void setCreatAt(Date creatAt) {
		this.creatAt = creatAt;
	}

	@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
	public void addCuenta(Cuenta cuenta){
		cuentas.add(cuenta);
	}
	
}
