package com.springwebjpa.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springwebjpa.app.models.entity.Cuenta;

public interface ICuentaDao extends CrudRepository<Cuenta, String>
{

}
