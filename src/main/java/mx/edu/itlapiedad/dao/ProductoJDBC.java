package mx.edu.itlapiedad.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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

	@Override
	public List<Producto> consultarProductos() {
		String sql_query="SELECT* FROM productos";
		return conexion.query(sql_query, new RowMapper<Producto>() {

			@Override
			public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
				Producto producto=new Producto();
				producto.setId(rs.getInt("id"));
				producto.setDescripcion(rs.getString("descripcion"));
				producto.setPrecio(rs.getFloat("precio"));
				producto.setCodigo_barras(rs.getString("codigo_barras"));
				producto.setExistencia(rs.getInt("existencia"));
				return producto;
			}
			
			
		});
	}
	@Override
	public Producto buscar(int id) {
		String sql_query = "SELECT * FROM productos WHERE id = ?";
		return conexion.queryForObject(sql_query, new RowMapper<Producto>() {
			public Producto mapRow(ResultSet rs, int rowNum) throws SQLException{
				Producto producto = new Producto();
				producto.setId(rs.getInt("id"));
				producto.setDescripcion(rs.getString("descripcion"));
				producto.setPrecio(rs.getFloat("precio"));
				producto.setCodigo_barras(rs.getString("codigo_barras"));
				producto.setExistencia(rs.getInt("existencia"));
				return producto;
			}
		}, id);
		
	}
	

}
