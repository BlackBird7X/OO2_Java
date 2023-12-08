package datos;

public class Supervisor extends Empleado {
	private double plusPresentismo;
	
	public Supervisor() {}

	public Supervisor(String nombre, String apellido, int dni, double sueldoBase, int horaInicioJornada,
			int horaFinJornada, double plusPresentismo) {
		super(nombre, apellido, dni, sueldoBase, horaInicioJornada, horaFinJornada);
		this.plusPresentismo = plusPresentismo;
	}

	public double getPlusPresentismo() {
		return plusPresentismo;
	}

	public void setPlusPresentismo(double plusPresentismo) {
		this.plusPresentismo = plusPresentismo;
	}

	@Override
	public String toString() {
		return super.toString() + "Supervisor [plusPresentismo=" + plusPresentismo + "]";
	}

	

	
	
	
	
}
