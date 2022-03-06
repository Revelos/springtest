package com.springwebjpa.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springwebjpa.app.models.dao.ITransferenciaDao;
import com.springwebjpa.app.models.entity.Transaccion;

@Service
public class TransaccionService implements ITransaccionService {

	@Autowired
	private ITransferenciaDao transacciondao;
	
	@Override
	public List<Transaccion> findAll() {
		// TODO Auto-generated method stub
		return (List<Transaccion>) transacciondao.findAll();
	}

	@Override
	public void save(Transaccion transaccion) {
		transacciondao.save(transaccion);
		
	}

	@Override
	public Transaccion findOne(Integer id) {
		// TODO Auto-generated method stub
		return transacciondao.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		transacciondao.deleteById(id);
	}

}
