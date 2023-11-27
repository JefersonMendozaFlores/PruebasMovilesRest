package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entidad.Categoria;
import com.example.service.CategoriaService;

@RestController
@RequestMapping("/rest/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	// LISTADO TODO
	@GetMapping
    public List<Categoria> listaEntradas() {
        return service.listarCategorias();
    }

}
