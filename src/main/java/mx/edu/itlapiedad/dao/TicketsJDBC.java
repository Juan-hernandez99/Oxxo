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

import mx.edu.itlapiedad.models.Tickets;

@Repository
public class TicketsJDBC implements TicketsDAO{

	@Autowired
	JdbcTemplate conexion;
	
	@Override
	public Tickets insertarTickets(Tickets tickets) {
		SimpleJdbcInsert insert=new SimpleJdbcInsert(conexion).withTableName("tickets")
				.usingColumns("fecha_hora","total","CAJERO_id","activo")
				.usingGeneratedKeyColumns("id");
		Map<String, Object> datos=new HashMap<>();
		datos.put("fecha_hora", tickets.getFecha_hora());
		datos.put("total", tickets.getTotal());
		datos.put("CAJERO_id", tickets.getCAJERO_id());
		datos.put("activo", 1);
		Number id=insert.executeAndReturnKey(datos);
		tickets.setId(id.intValue());
		tickets.setActivo(1);
		return tickets;
	}
	
	@Override
	public List<Tickets> consultarTickets(){
		String sql_query="SELECT* FROM tickets WHERE activo= 1";
		return conexion.query(sql_query, new RowMapper<Tickets>() {
			
			
			public Tickets mapRow(ResultSet rs, int rowNum) throws SQLException{
				Tickets tickets=new Tickets();
				tickets.setId(rs.getInt("id"));
				tickets.setActivo(rs.getInt("activo"));
				tickets.setFecha_hora(rs.getString("fecha_hora"));
				tickets.setTotal(rs.getFloat("total"));
				tickets.setCAJERO_id(rs.getInt("CAJERO_id"));
				return tickets;
			}
			
		});
	}
	
	@Override
	public Tickets buscar(int id) {
		String sql_query="SELECT * FROM tickets WHERE id= ?";
		return conexion.queryForObject(sql_query, new RowMapper<Tickets>() {
			public Tickets mapRow(ResultSet rs, int rouNum) throws SQLException{
				Tickets tickets = new Tickets();
				tickets.setId(rs.getInt("id"));
				tickets.setFecha_hora(rs.getString("fecha_hora"));
				tickets.setTotal(rs.getFloat("total"));
				tickets.setCAJERO_id(rs.getInt("CAJERO_id"));
				return tickets;
			}
		}, id);
	}
	@Override
	public void actualizarTickets(Tickets tickets) {
		String sql_update="UPDATE tickets SET fecha_hora=?, total=?, cajero_id=? WHERE id=?";
		conexion.update(sql_update,tickets.getFecha_hora(), tickets.getTotal(),
		tickets.getCAJERO_id(),
		tickets.getId());
		

	}
	@Override
	public void eliminarTickets(int id) {
		String sql_update="UPDATE tickets SET activo=0 WHERE id=?";
		conexion.update(sql_update,id);

	}
	


}
