package mx.edu.itlapiedad.dao;

import java.util.List;

import mx.edu.itlapiedad.models.Cajeros;

public interface CajerosDAO {

	List<Cajeros> consultarCajeros();

	Cajeros insertarCajeros(Cajeros cajeros);

	void actualizarCajeros(Cajeros cajeros);

	void eliminarCajeros(int id);

	Cajeros buscarID(int id);

}
