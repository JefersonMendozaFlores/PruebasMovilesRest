package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entidad.Categoria;
import com.example.repository.CategoriaRepository;

@Service
public class CategoriaServicesImp implements CategoriaService{
	
	@Autowired
	private CategoriaRepository repo;

	@Override
	public List<Categoria> listarCategorias() {
		return repo.findAll();
	}

}
