package com.springwebjpa.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springwebjpa.app.models.entity.TipoTransaccion;

public interface ITipoTransferencia extends CrudRepository<TipoTransaccion, Integer>{

}
