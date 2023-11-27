package com.example.entidad;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tb_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Integer codigoCategoria;
	
	@Column(name = "nom_categoria")
	private String nombreCategoria;
	
	// CATEGORIA A PRODUCTO
	@JsonIgnore
	@OneToMany(mappedBy = "tipoCategoria")
	private List<Producto> tipo;

}
