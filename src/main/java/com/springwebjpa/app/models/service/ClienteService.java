package com.springwebjpa.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springwebjpa.app.models.dao.IClienteDao;
import com.springwebjpa.app.models.entity.Cliente;

@Service
public class ClienteService implements IClienteService{
	
	@Autowired
	private IClienteDao clientedao;
	
	@Override
	@Transactional(readOnly = true) // Envuelve el contenido del metodo en una transaccion
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clientedao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		// TODO Auto-generated method stub
		clientedao.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Integer id) {
		// TODO Auto-generated method stub
		return clientedao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		clientedao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findByDui(String dui) {
		// TODO Auto-generated method stub
		return clientedao.fetchByDui(dui);
	}

}
