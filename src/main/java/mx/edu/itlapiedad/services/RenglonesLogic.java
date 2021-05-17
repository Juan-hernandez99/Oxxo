package mx.edu.itlapiedad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.itlapiedad.dao.RenglonesDAO;
import mx.edu.itlapiedad.models.Renglones;

@Service
public class RenglonesLogic implements RenglonesService{
	
	@Autowired
	RenglonesDAO repositorio;
	
	@Override
	public List<Renglones> consultarRenglones() {
		return repositorio.consultarRenglones();
	}

	@Override
	public Renglones buscar(int id) {
		return repositorio.buscar(id);
	}

	@Override
	public Renglones insertarRenglones(Renglones renglones) {
		return repositorio.insertarRenglones(renglones);
	}

	@Override
	public void eliminarRenglones(int id) {
		repositorio.eliminarRenglones(id);
		
	}


	@Override
	public void actualizarRenglones(Renglones renglones) {
		repositorio.actualizarRenglones(renglones);
		
	}

}
