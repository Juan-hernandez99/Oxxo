package mx.edu.itlapiedad.services;

import java.util.List;

import mx.edu.itlapiedad.models.Cajeros;
import mx.edu.itlapiedad.models.Totales;

public interface CajerosService {

	List<Cajeros> consultarCajeros();

	Cajeros insertarCajeros(Cajeros cajeros);

	void actualizarCajeros(Cajeros cajeros);

	void eliminarCajeros(int id);

	Cajeros buscarID(int id);

	List<Totales> consultarTotalCajeros(int id);

}
