package mx.edu.itlapiedad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.itlapiedad.dao.TicketsDAO;
import mx.edu.itlapiedad.models.Tickets;

@Service
public class TicketLogic implements TicketService{
	@Autowired
	TicketsDAO repositorio;
	
	@Override
	public Tickets insertarTickets (Tickets tickets) {
		return repositorio.insertarTickets(tickets);
	}
	
	@Override
	public List<Tickets> consultarTickets(){
		return repositorio.consultarTickets();
		
	}
	
	@Override
	public Tickets buscar(int id) {
		return repositorio.buscar(id);
	}
	@Override
	public void actualizarTickets(Tickets tickets) {
		repositorio.actualizarTickets(tickets);
		
	}
	@Override
	public void eliminarTickets(int id) {
		repositorio.eliminarTickets(id);
		
	}


}
