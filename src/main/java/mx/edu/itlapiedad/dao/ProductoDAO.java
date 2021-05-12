package mx.edu.itlapiedad.dao;
import java.util.List;

import mx.edu.itlapiedad.models.Producto;


public interface ProductoDAO {
	public Producto insertarProductos(Producto productos);
	public List<Producto>consultarProductos();
	public Producto buscar(int id);
}
