package com.springwebjpa.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springwebjpa.app.models.dao.ITipoTransferencia;
import com.springwebjpa.app.models.entity.TipoTransaccion;

@Service
public class TipoTransService implements ITipoTransaccion{

	@Autowired
	private ITipoTransferencia tipoTransferencia;
	
	@Override
	public List<TipoTransaccion> findAll() {
		// TODO Auto-generated method stub
		return (List<TipoTransaccion>) tipoTransferencia.findAll();
	}

}
