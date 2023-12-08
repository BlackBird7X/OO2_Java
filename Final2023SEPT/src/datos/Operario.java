package datos;

public class Operario extends Empleado{
	private double plusHoraExtra;
	
	public Operario() {}

	public Operario(String nombre, String apellido, int dni, double sueldoBase, int horaInicioJornada,
			int horaFinJornada, double plusHoraExtra) {
		super(nombre, apellido, dni, sueldoBase, horaInicioJornada, horaFinJornada);
		this.plusHoraExtra = plusHoraExtra;
	}

	public double getPlusHoraExtra() {
		return plusHoraExtra;
	}

	public void setPlusHoraExtra(double plusHoraExtra) {
		this.plusHoraExtra = plusHoraExtra;
	}

	@Override
	public String toString() {
		return super.toString() + "Operario: [plusHoraExtra=" + plusHoraExtra + "]";
	}

	
	
}
