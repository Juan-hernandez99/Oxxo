package mx.edu.itlapiedad.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import mx.edu.itlapiedad.models.Producto;

@Repository
public class ProductoJDBC implements ProductoDAO{

	@Autowired
	JdbcTemplate conexion;
	
	@Override
	public Producto insertarProductos(Producto productos) {
		SimpleJdbcInsert insert=new SimpleJdbcInsert(conexion).withTableName("productos")
				.usingColumns("descripcion","precio","codigo_barras","existencia")
				.usingGeneratedKeyColumns("id");
		Map<String, Object> datos=new HashMap<>();
		datos.put("descripcion", productos.getDescripcion());
		datos.put("precio", productos.getPrecio());
		datos.put("codigo_barras", productos.getCodigo_barras());
		datos.put("existencia", productos.getExistencia());
		Number id=insert.executeAndReturnKey(datos);
		productos.setId(id.intValue());
		return productos;
	}

}
