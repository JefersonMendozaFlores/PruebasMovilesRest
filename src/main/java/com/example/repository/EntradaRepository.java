package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entidad.Entrada;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EntradaRepository extends JpaRepository<Entrada, Integer>{
	
	@Modifying
	@Query("update Producto x set x.stock = x.stock + :can where x.codigoProducto = :pro")
	public abstract void actualizaStock(@Param("can")int cantidad, @Param("pro")int idProducto);

}
