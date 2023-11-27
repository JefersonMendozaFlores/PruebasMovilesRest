package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entidad.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	

}
