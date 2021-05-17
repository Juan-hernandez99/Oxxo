package mx.edu.itlapiedad.services;

import java.util.List;

import mx.edu.itlapiedad.models.Renglones;


public interface RenglonesService {
	
	List<Renglones> consultarRenglones();
	Renglones buscar(int id);
	Renglones insertarRenglones(Renglones productos);
	void eliminarRenglones(int id);
	void actualizarRenglones(Renglones renglones);
}
