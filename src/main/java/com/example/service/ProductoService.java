package com.example.service;

import java.util.List;

import com.example.entidad.Producto;

public interface ProductoService {
	
	// METODOS ABSTRACTOS
	public abstract List<Producto> listarProductos();
	public abstract Producto listarProductos(Integer id);
	
	public abstract Producto createProducto (Producto obj);
	public abstract Producto updateProducto (Integer id, Producto obj);
	
	public abstract void eliminaProducto(int idProducto);

}
