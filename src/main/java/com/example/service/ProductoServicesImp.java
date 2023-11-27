package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entidad.Producto;
import com.example.repository.ProductoRepository;

@Service
public class ProductoServicesImp implements ProductoService{
	
	@Autowired
	private ProductoRepository repository;
	
	@Override
	public List<Producto> listarProductos() {
		return repository.findAll();
	}

	@Override
	public Producto listarProductos(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Producto createProducto(Producto obj) {
		return repository.save(obj);
	}

	@Override
	public Producto updateProducto(Integer id,Producto objProducto) {
		if(repository.existsById(id)) {
			objProducto.setCodigoProducto(id);
			return repository.save(objProducto);
		}
		return null;
	}

	@Override
	public void eliminaProducto(int idProducto) {
		repository.deleteById(idProducto);
		
	}

}
