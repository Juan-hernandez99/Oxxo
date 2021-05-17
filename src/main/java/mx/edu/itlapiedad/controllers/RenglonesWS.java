package mx.edu.itlapiedad.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
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

import mx.edu.itlapiedad.models.Renglones;
import mx.edu.itlapiedad.services.RenglonesService;

@RestController
@RequestMapping("/oxxo/renglones")
public class RenglonesWS {
	
	@Autowired
	RenglonesService servicio;
	
	@GetMapping()
	public ResponseEntity<?> consultarRenglones(){
		List<Renglones> resultado;
		
		try {
			resultado = servicio.consultarRenglones();
		} catch(DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Renglones>>(resultado, HttpStatus.OK); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable int id){
		Renglones resultado;
		
		try {
			resultado = servicio.buscar(id);
			
		} catch(DataAccessException e) {
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Renglones>(resultado, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<?> insertarRenglones(@RequestBody Renglones renglones){
		Renglones resultado;
		
		try {
			resultado = servicio.insertarRenglones(renglones);
			
		}catch(DataAccessException e) {
			System.out.print(e);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Renglones>(resultado, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarRenglones(@PathVariable int id){
		
		try {
			servicio.eliminarRenglones(id);
			
		}catch(DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Renglones>(HttpStatus.OK);
	}
	
	@PutMapping()
	public ResponseEntity<?> actualizarRenglones(@RequestBody Renglones renglones){
		try {
			servicio.actualizarRenglones(renglones);
			
		}catch(DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}


}