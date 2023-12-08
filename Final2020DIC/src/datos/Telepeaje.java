package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Telepeaje extends Peaje {
	private Rodado rodado;
	private String lector;
	
	public Telepeaje() {}

	public Telepeaje(Rodado rodado, String lector, LocalDate fecha, LocalTime hora, double precio) {
		super(fecha, hora, precio);
		this.rodado = rodado;
		this.lector = lector;
	}

	public Rodado getRodado() {
		return rodado;
	}

	protected void setRodado(Rodado rodado) {
		this.rodado = rodado;
	}

	public String getLector() {
		return lector;
	}

	public void setLector(String lector) {
		this.lector = lector;
	}

	@Override
	public String toString() {
		return "Telepeaje: [rodado=" + rodado + ", lector=" + lector + "]";
	}
}
