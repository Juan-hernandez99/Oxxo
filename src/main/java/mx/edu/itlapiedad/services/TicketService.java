package mx.edu.itlapiedad.services;

import java.util.List;

import mx.edu.itlapiedad.models.Tickets;

public interface TicketService {
		
	Tickets insertarTickets(Tickets tickets);
	List<Tickets> consultarTickets();
	Tickets buscar(int id);
	void actualizarTickets(Tickets tickets);
	void eliminarTickets(int id);
}
