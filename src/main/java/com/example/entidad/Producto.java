package com.example.entidad;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tb_producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prod")
	private Integer codigoProducto;
	
	@Column(name = "nom_prod")
	private String nombreProducto;
	
	@Column(name = "color")
	private String color;

	@Column(name = "talla")
	private String talla;
	
	@Column(name = "precio")
	private Double precio;
	
	@Column(name = "stock")
	private int stock;
	
	@Column(name = "estado")
	private String estado;
	
	// CATEGORIA A PRODUCTO
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria tipoCategoria;
	
	// PRODUCTO A ENTRADA
	@JsonIgnore
	@OneToMany(mappedBy = "tipoProductoEntra")
	private List<Entrada> tipoEntra;
	
	// PRODUCTO A SALIDA
	@JsonIgnore
	@OneToMany(mappedBy = "tipoProductoSali")
	private List<Salida> tipoSali;

}
