package com.example.entidad;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tb_salida")
public class Salida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_salida")
	private Integer codigoSalida;
	
	@Column(name = "fecha_salida")
	private Date fechaSalida;

	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "observaciones")
	private String observaciones;
	
	// PRODUCTO A SALIDA
	@ManyToOne
	@JoinColumn(name="id_prod")
	private Producto tipoProductoSali;

}
