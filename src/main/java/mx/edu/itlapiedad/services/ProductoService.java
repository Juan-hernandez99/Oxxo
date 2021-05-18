package mx.edu.itlapiedad.services;

import java.util.List;

import mx.edu.itlapiedad.models.Producto;


public interface ProductoService {

	Producto insertarProductos(Producto productos);
	List<Producto> consultarProductos();
	Producto buscar(int id);
	void actualizar(Producto producto);
	void eliminar(int id);
}
