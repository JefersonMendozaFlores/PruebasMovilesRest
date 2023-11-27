package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.example.entidad.Producto;
import com.example.service.ProductoService;
import com.example.utilidad.Constantes;

@RestController
@RequestMapping("/rest/producto")
public class ProductoController {
	
	/* http://localhost:8092/rest/producto || http://localhost:8092/rest/producto/8 */
	
	@Autowired
	private ProductoService service;

	@GetMapping
	public List<Producto> getAllProducts() {
		return service.listarProductos();
	}

	@GetMapping("/{id}")
	public Producto getProducto(@PathVariable Integer id) {
		return service.listarProductos(id);
	}

	@PostMapping("/registra")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> crearProducto(@RequestBody Producto producto) {
		Map<String, Object> salida = new HashMap<>();
		try {
			producto.setCodigoProducto(0);
			
			Producto objSalida =  service.createProducto(producto);
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

	
	  @PutMapping("/actualiza/{id}")
	    public ResponseEntity<Map<String, Object>> updateProducto(@PathVariable Integer id, @RequestBody Producto producto) {
	        Map<String, Object> salida = new HashMap<>();
	        try {
	            Producto productoActualizado = service.updateProducto(id, producto);
	            if (productoActualizado != null) {
	                salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO); // Mensaje de actualización exitosa
	                salida.put("producto", productoActualizado); // Opcional: Devuelve el objeto actualizado
	            } else {
	                salida.put("mensaje", "El producto no pudo ser actualizado."); // Mensaje de error en la actualización
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR); // Mensaje de error genérico
	        }
	        return ResponseEntity.ok(salida);
	    }
	

    @DeleteMapping("/elimina/{id}")
    @ResponseBody
	public ResponseEntity<Map<String, Object>> elimina(@PathVariable("id") int idProducto) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminaProducto(idProducto);
			salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
    }

}
