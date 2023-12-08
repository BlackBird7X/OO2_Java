package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Fichada {
	private int idFichada;
	private LocalDate fecha;
	private LocalTime hora;
	private boolean entrada;
	private Empleado empleado;
	
	public Fichada() {}
	
	public Fichada(LocalDate fecha, LocalTime hora, boolean entrada, Empleado empleado) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.entrada = entrada;
		this.empleado = empleado;
	}

	public int getIdFichada() {
		return idFichada;
	}

	protected void setIdFichada(int idFichada) {
		this.idFichada = idFichada;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public boolean isEntrada() {
		return entrada;
	}

	public void setEntrada(boolean entrada) {
		this.entrada = entrada;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Fichada: [idFichada=" + idFichada + ", fecha=" + fecha + ", hora=" + hora + ", entrada=" + entrada
				+ ", empleado=" + empleado + "]";
	}
	

	
	
}
