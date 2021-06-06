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

import mx.edu.itlapiedad.models.Cajeros;
import mx.edu.itlapiedad.models.Totales;
@Repository
public class CajerosJDBC implements CajerosDAO {

	@Autowired
	JdbcTemplate conexion;

	
	
	@Override
	public List<Cajeros> consultarCajeros() {
		String sql_query="SELECT* FROM cajeros WHERE activo=1";
		return conexion.query(sql_query, new RowMapper<Cajeros>() {

			@Override
			public Cajeros mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cajeros cajero=new Cajeros();
				cajero.setId(rs.getInt("id"));
				cajero.setNombre(rs.getString("nombre"));
				cajero.setActivo(rs.getInt("activo"));
				return cajero;
			}


		});
	}

	@Override
	public Cajeros insertarCajeros(Cajeros cajeros) {
		
		SimpleJdbcInsert insert=new SimpleJdbcInsert(conexion).withTableName("cajeros")
				.usingColumns("nombre","activo")
				
				.usingGeneratedKeyColumns("id");
		Map<String, Object> datos=new HashMap<>();
		datos.put("nombre", cajeros.getNombre());
		datos.put("activo", 1);
		Number id=insert.executeAndReturnKey(datos);
		cajeros.setId(id.intValue());
		
		return cajeros;
	}

	@Override
	public void actualizarCajeros(Cajeros cajeros) {
		String sql_update="UPDATE cajeros SET nombre=? WHERE id=?";
		conexion.update(sql_update,cajeros.getNombre(),
				cajeros.getId());
		

	}

	@Override
	public void eliminarCajeros(int id) {
		String sql_update="UPDATE cajeros SET activo=0 WHERE id=?";
		conexion.update(sql_update,id);

	}

	@Override
	public Cajeros buscarID(int id) {
		String sql_query = "SELECT * FROM cajeros WHERE id = ? and activo=1";
		return conexion.queryForObject(sql_query, new RowMapper<Cajeros>() {
			public Cajeros mapRow(ResultSet rs, int rowNum) throws SQLException{
				Cajeros cajero = new Cajeros();
				cajero.setId(rs.getInt("id"));
				cajero.setNombre(rs.getString("nombre"));
				cajero.setActivo(rs.getInt("activo"));
				return cajero;
			}
		}, id);
	}



	@Override
	public List<Totales> consultarTotalCajeros(int id) {
		String sql_query = "SELECT c.id, c.nombre, total FROM tickets t JOIN cajeros c ON c.id=t.CAJERO_id WHERE c.id= ?";
		return conexion.query(sql_query, new RowMapper<Totales>() {

			@Override
			public Totales mapRow(ResultSet rs, int rowNum) throws SQLException {
				Totales tot=new Totales();
				tot.setId(rs.getInt("id"));
				tot.setNombre(rs.getString("nombre"));
				tot.setTotal(rs.getFloat("total"));
				return tot;
			}


		},id);

	
	}


}
