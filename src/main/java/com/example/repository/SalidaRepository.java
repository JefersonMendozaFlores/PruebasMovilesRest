package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entidad.Salida;

public interface SalidaRepository extends JpaRepository<Salida, Integer>{
	
	@Modifying
	@Query("update Producto x set x.stock = x.stock - :can where x.codigoProducto = :pro")
	public abstract void actualizaStock(@Param("can")int cantidad, @Param("pro")int idProducto);

}
