package com.springwebjpa.app.models.service;

import java.util.List;

import com.springwebjpa.app.models.entity.Transaccion;

public interface ITransaccionService {

	public List<Transaccion> findAll();

	public void save(Transaccion transaccion);

	public Transaccion findOne(Integer id);

	public void delete(Integer id);
}
