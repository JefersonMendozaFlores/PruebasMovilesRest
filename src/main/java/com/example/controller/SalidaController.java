package com.example.controller;

import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entidad.Salida;
import com.example.service.SalidaService;
import com.example.utilidad.Constantes;

@RestController
@RequestMapping("/rest/salida")
public class SalidaController {

	@Autowired
	private SalidaService service;
	
	// LISTADO TODO
	@GetMapping
    public List<Salida> listaEntradas() {
        return service.listarSalidas();
    }
	
	// REGISTRAR ENTRADA
	@PostMapping("/registra")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> inserta(@RequestBody Salida obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setCodigoSalida(0);

			obj.setFechaSalida(new Date());
			
			Salida objSalida =  service.insertaActualizaSalida(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	// ACTUALIZAR ENTRADA
	@PutMapping("/actualiza")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaProveedor(@RequestBody Salida obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setFechaSalida(new Date());
			
			Salida objSalida =  service.insertaActualizaSalida(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	// ELIMINAR ENTRADA
	@DeleteMapping("/elimina/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> elimina(@PathVariable("id") int idSalida) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminaSalida(idSalida);
			salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
}
