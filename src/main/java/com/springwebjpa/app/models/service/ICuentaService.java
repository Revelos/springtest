package com.springwebjpa.app.models.service;

import java.util.List;

import com.springwebjpa.app.models.entity.Cuenta;

public interface ICuentaService {

	public List<Cuenta> findAll();

	public void save(Cuenta cuenta);

	public Cuenta findOne(String id);

	public void delete(String id);
}
