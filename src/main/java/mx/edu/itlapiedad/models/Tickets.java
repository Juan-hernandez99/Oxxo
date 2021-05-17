package mx.edu.itlapiedad.models;

public class Tickets {
	private int id;
	 private String fecha_hora;
	 private float total;
	 private int CAJERO_id;
	 private int activo;
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha_hora() {
		return fecha_hora;
	}
	public void setFecha_hora(String fecha_hora) {
		this.fecha_hora = fecha_hora;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getCAJERO_id() {
		return CAJERO_id;
	}
	public void setCAJERO_id(int cAJERO_id) {
		CAJERO_id = cAJERO_id;
	}

}
