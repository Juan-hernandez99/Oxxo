package mx.edu.itlapiedad.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.itlapiedad.models.Producto;

import mx.edu.itlapiedad.services.ProductoService;





@RestController
@RequestMapping("/oxxo")
public class ProductosWS {

	@Autowired
	ProductoService servicio;	

	

	@PostMapping("/productos/insertar")
	public ResponseEntity<?>insertarProductos(@RequestBody Producto productos){
		Producto resultado=null;
		try {
			resultado=servicio.insertarProductos(productos);
		}catch(DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Producto>(resultado,HttpStatus.CREATED);
		
	}
	@GetMapping("/productos")
	public ResponseEntity<?> consultarProductos() {
		List<Producto>resultado;
		try {
			resultado= servicio.consultarProductos();
		}catch(DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Producto>>(resultado, HttpStatus.OK);
		
	}

	

}
