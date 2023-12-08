package datos;

import java.time.LocalTime;
import java.util.Objects;

public class SensorCortinaVentana extends Dispositivo {
	private LocalTime aperturaDesde;
	private LocalTime aperturaHasta;
	
	public SensorCortinaVentana() {}
	
	public SensorCortinaVentana(String nombre, boolean activo, LocalTime aperturaDesde, LocalTime aperturaHasta) {
		super(nombre, activo);
		this.aperturaDesde = aperturaDesde;
		this.aperturaHasta = aperturaHasta;
	}

	public LocalTime getAperturaDesde() {
		return aperturaDesde;
	}

	public void setAperturaDesde(LocalTime aperturaDesde) {
		this.aperturaDesde = aperturaDesde;
	}

	public LocalTime getAperturaHasta() {
		return aperturaHasta;
	}

	public void setAperturaHasta(LocalTime aperturaHasta) {
		this.aperturaHasta = aperturaHasta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(aperturaDesde, aperturaHasta);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SensorCortinaVentana other = (SensorCortinaVentana) obj;
		return Objects.equals(aperturaDesde, other.aperturaDesde) && Objects.equals(aperturaHasta, other.aperturaHasta);
	}

	@Override
	public String toString() {
		return super.toString() + "SensorCortinaVentana: [aperturaDesde=" + aperturaDesde + ", aperturaHasta=" + aperturaHasta + "]";
	}
	
}
