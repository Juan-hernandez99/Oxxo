package mx.edu.itlapiedad.dao;

import java.util.List;

import mx.edu.itlapiedad.models.Tickets;

public interface TicketsDAO {
	public Tickets insertarTickets(Tickets tickets);
	public List<Tickets>consultarTickets();
	public Tickets buscar(int id);
	public void actualizarTickets(Tickets tickets);
	public	void eliminarTickets(int id);

}
