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
				.usingColumns("descripcion","precio","codigo_barras","existencia","activo")
				.usingGeneratedKeyColumns("id");
		Map<String, Object> datos=new HashMap<>();
		datos.put("descripcion", productos.getDescripcion());
		datos.put("precio", productos.getPrecio());
		datos.put("codigo_barras", productos.getCodigo_barras());
		datos.put("existencia", productos.getExistencia());
		datos.put("activo", 1);
		Number id=insert.executeAndReturnKey(datos);
		productos.setId(id.intValue());
		
		return productos;
	}

	@Override
	public List<Producto> consultarProductos() {
		String sql_query="SELECT* FROM productos where activo=1";
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
		String sql_query = "SELECT * FROM productos WHERE id = ? and activo=1";
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

	@Override
	public void actualizar(Producto producto) {
		String sql_update="UPDATE productos SET descripcion=?, precio=?,"
				+ "codigo_barras=?, existencia=? WHERE id=?";
		conexion.update(sql_update, producto.getDescripcion(),
				producto.getPrecio(),
				producto.getCodigo_barras(),
				producto.getExistencia(),
				producto.getId());
		
	}

	@Override
	public void eliminar(int id) {
		String sql_update="UPDATE productos SET activo=0 WHERE id=?";
		conexion.update(sql_update,id);
		
	}
	

}
