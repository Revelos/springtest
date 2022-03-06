package com.springwebjpa.app.models.service;

import java.util.List;

import com.springwebjpa.app.models.entity.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();

	public void save(Cliente cliente);

	public Cliente findOne(Integer id);

	public void delete(Integer id);
	
	public Cliente findByDui(String dui);
}
