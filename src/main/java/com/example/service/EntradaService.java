package com.example.service;

import java.util.List;

import com.example.entidad.Entrada;

public interface EntradaService {
	
	// METODOS ABSTRACTOS
	public abstract List<Entrada> listarEntradas();
	
	public abstract Entrada insertaActualizaEntrada (Entrada obj);
	public abstract void eliminaEntrada(int idEntrada);

}
