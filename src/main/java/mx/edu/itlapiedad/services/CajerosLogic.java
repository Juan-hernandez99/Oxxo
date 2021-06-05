package mx.edu.itlapiedad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.itlapiedad.dao.CajerosDAO;
import mx.edu.itlapiedad.models.Cajeros;
import mx.edu.itlapiedad.models.Totales;
@Service
public class CajerosLogic implements CajerosService {

	@Autowired
	CajerosDAO repositorio;
	
	@Override
	public List<Cajeros> consultarCajeros() {
		
		return repositorio.consultarCajeros();
	}

	@Override
	public Cajeros insertarCajeros(Cajeros cajeros) {
		
		return repositorio.insertarCajeros(cajeros);
	}

	@Override
	public void actualizarCajeros(Cajeros cajeros) {
		repositorio.actualizarCajeros(cajeros);
		
	}

	@Override
	public void eliminarCajeros(int id) {
		repositorio.eliminarCajeros(id);
		
	}

	@Override
	public Cajeros buscarID(int id) {
		
		
		
		return repositorio.buscarID(id);
	}

	@Override
	public List<Totales> consultarTotalCajeros(int id) {
		// TODO Auto-generated method stub
		return repositorio.consultarTotalCajeros(id);
	}

}
