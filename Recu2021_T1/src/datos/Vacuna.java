package datos;

import java.time.LocalTime;

public class Vacuna {
	private int idVacuna;
	private int codigo;
	private String nombre;
	private LocalTime fechaElaboracion;
	
	public Vacuna() {}
	
	public Vacuna(int codigo, String nombre, LocalTime fechaElaboracion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaElaboracion = fechaElaboracion;
	}
	
	public int getIdVacuna() {
		return idVacuna;
	}
	
	protected void setIdVacuna(int idVacuna) {
		this.idVacuna = idVacuna;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public LocalTime getFechaElaboracion() {
		return fechaElaboracion;
	}
	
	public void setFechaElaboracion(LocalTime fechaElaboracion) {
		this.fechaElaboracion = fechaElaboracion;
	}
	
	@Override
	public String toString() {
		return "Vacuna: [idVacuna=" + idVacuna + " codigo=" + codigo + ", nombre=" + nombre
				+ ", fechaElaboracion=" + fechaElaboracion + "]";
	}
}
