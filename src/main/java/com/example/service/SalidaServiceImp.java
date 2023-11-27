package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entidad.Salida;
import com.example.repository.SalidaRepository;

@Service
public class SalidaServiceImp implements SalidaService{
	
	@Autowired
	private SalidaRepository repository;

	@Override
	public List<Salida> listarSalidas() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public Salida insertaActualizaSalida(Salida obj) {
		Salida e = repository.save(obj);
		repository.actualizaStock(e.getCantidad(), e.getTipoProductoSali().getCodigoProducto());
	    return e;
	}

	@Override
	public void eliminaSalida(int idSalida) {
		repository.deleteById(idSalida);
	}
	
	

}
