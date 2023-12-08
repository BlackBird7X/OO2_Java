package datos;

import java.util.Objects;

public class SensorTemperatura extends Dispositivo {
	private double valorMinimo;
	private double valorMaximo;
	
	public SensorTemperatura() {}
	
	public SensorTemperatura(String nombre, boolean activo, double valorMinimo, double valorMaximo) {
		super(nombre, activo);
		this.valorMinimo = valorMinimo;
		this.valorMaximo = valorMaximo;
	}

	public double getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public double getValorMaximo() {
		return valorMaximo;
	}

	public void setValorMaximo(double valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(valorMaximo, valorMinimo);
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
		SensorTemperatura other = (SensorTemperatura) obj;
		return Double.doubleToLongBits(valorMaximo) == Double.doubleToLongBits(other.valorMaximo)
				&& Double.doubleToLongBits(valorMinimo) == Double.doubleToLongBits(other.valorMinimo);
	}

	@Override
	public String toString() {
		return "SensorTemperatura: [valorMinimo=" + valorMinimo + ", valorMaximo=" + valorMaximo + "]";
	}
	
}
