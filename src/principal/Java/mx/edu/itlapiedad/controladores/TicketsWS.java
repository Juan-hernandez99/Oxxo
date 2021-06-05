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

import mx.edu.itlapiedad.models.Tickets;
import mx.edu.itlapiedad.services.TicketService;

@RestController
@RequestMapping("/oxxo")
public class TicketsWS {
	@Autowired
	TicketService servicio;
	
	
	@PostMapping("/tickets/insertar")
	public ResponseEntity<?>insertarTickets(@RequestBody Tickets tickets){
		Tickets resultado=null;
		//try {
			resultado=servicio.insertarTickets(tickets);
		//}catch(DataAccessException e) {
			//return new ResponseEntity<> (HttpStatus.CONFLICT);
		//}
		return new ResponseEntity<Tickets>(resultado,HttpStatus.CREATED);
	}
	
	@GetMapping("/tickets")
	public ResponseEntity<?> consultarTickets(){
		List<Tickets>resultado;
		try {
			resultado=servicio.consultarTickets();
		}catch(DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Tickets>>(resultado, HttpStatus.OK);
	}
	
	   @GetMapping("/tickets/{id}")
	   public ResponseEntity<?> buscar(@PathVariable int id){
		   Tickets resultado;
		   try {
			   resultado= servicio.buscar(id);
		   }catch(DataAccessException e) {
			   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		   }
		   return new ResponseEntity<Tickets>(resultado,HttpStatus.OK);
	   }
	   @PutMapping("tickets/actualizar")
	 		public ResponseEntity<?>actualizarTickets(@RequestBody Tickets tickets){
	 			try {
	 				servicio.actualizarTickets(tickets);
	 			}catch(DataAccessException e) {
	 				System.out.println(e);
	 				return new ResponseEntity<>(HttpStatus.CONFLICT);

	 			}


	 			return new ResponseEntity<>(HttpStatus.CREATED);
	 		}
	   @DeleteMapping("tickets/eliminar/{id}")
		public ResponseEntity<?>eliminarTickets(@PathVariable int id){

			try {
				servicio.eliminarTickets(id);
			}catch(DataAccessException e) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			}

			return new ResponseEntity<Tickets>(HttpStatus.OK);

		}
}
