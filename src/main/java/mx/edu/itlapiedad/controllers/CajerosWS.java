package mx.edu.itlapiedad.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import mx.edu.itlapiedad.models.Cajeros;
import mx.edu.itlapiedad.services.CajerosService;

@RestController
@RequestMapping("/oxxo")

public class CajerosWS {

	@Autowired
	CajerosService servicio;	

	@GetMapping("/Cajeros")
	public ResponseEntity<?> consultarCajeros() {
		List<Cajeros>resultado;
		try {
			resultado= servicio.consultarCajeros();
		}catch(DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Cajeros>>(resultado, HttpStatus.OK);

	
	}

	@GetMapping("/Cajeros/{id}")
	public ResponseEntity<?> buscarID(@PathVariable int id){
		Cajeros resultado;
		try {
			resultado = servicio.buscarID(id);

		}catch(DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Cajeros>(resultado,HttpStatus.OK);
	}

	@PostMapping("/Cajeros/insertar")
	public ResponseEntity<?>insertarCajeros(@RequestBody Cajeros cajeros){
		Cajeros resultado=null;
		try {
			resultado=servicio.insertarCajeros(cajeros);
		}catch(DataAccessException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Cajeros>(resultado,HttpStatus.CREATED);

	}
	@PutMapping("Cajeros/actualizar")
	public ResponseEntity<?>actualizarCajeros(@RequestBody Cajeros cajeros){
		try {
			servicio.actualizarCajeros(cajeros);
		}catch(DataAccessException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.CONFLICT);

		}


		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@DeleteMapping("Cajeros/eliminar/{id}")
	public ResponseEntity<?>eliminarCajeros(@PathVariable int id){

		try {
			servicio.eliminarCajeros(id);
		}catch(DataAccessException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}

		return new ResponseEntity<Cajeros>(HttpStatus.OK);

	}
	
}