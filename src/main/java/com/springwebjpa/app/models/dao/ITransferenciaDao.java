package com.springwebjpa.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springwebjpa.app.models.entity.Transaccion;

public interface ITransferenciaDao extends CrudRepository<Transaccion, Integer> {

}
