package com.springwebjpa.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springwebjpa.app.models.dao.ICuentaDao;
import com.springwebjpa.app.models.entity.Cuenta;

@Service
public class CuentaService implements ICuentaService{

	@Autowired
	private ICuentaDao cuentadao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cuenta> findAll() {
		// TODO Auto-generated method stub
		return (List<Cuenta>) cuentadao.findAll();
	}

	@Override
	@Transactional
	public void save(Cuenta cuenta) {
		// TODO Auto-generated method stub
		cuentadao.save(cuenta);
	}

	@Override
	@Transactional(readOnly = true)
	public Cuenta findOne(String id) {
		
		return cuentadao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		cuentadao.deleteById(id);
	}

}
