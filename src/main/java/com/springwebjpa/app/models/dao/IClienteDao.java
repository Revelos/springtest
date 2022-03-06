package com.springwebjpa.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springwebjpa.app.models.entity.Cliente;
//Utilizamos la interfaz CrudRepository del API Spring.data
public interface IClienteDao extends CrudRepository<Cliente, Integer>{

	//query nos permiter generar una consulta JPA query Language
	@Query("select c from Cliente c  where c.dui=?1")
	public Cliente fetchByDui(String dui);

}
