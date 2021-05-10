package mx.edu.itlapiedad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.itlapiedad.dao.ProductoDAO;
import mx.edu.itlapiedad.models.Producto;



@Service
public class ProductoLogic implements ProductoService {

	@Autowired
	ProductoDAO repositorio;
	
	@Override
	public Producto insertarProductos(Producto productos) {
		return repositorio.insertarProductos(productos);
	}

	@Override
	public List<Producto> consultarProductos() {
		return repositorio.consultarProductos();
	}
}
