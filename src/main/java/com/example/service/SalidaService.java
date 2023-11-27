package com.example.service;

import java.util.List;

import com.example.entidad.Salida;

public interface SalidaService {
	
	// METODOS ABSTRACTOS
	public abstract List<Salida> listarSalidas();
	
	public abstract Salida insertaActualizaSalida (Salida obj);
	public abstract void eliminaSalida(int idSalida);

}
