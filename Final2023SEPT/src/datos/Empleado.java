package datos;

public abstract class Empleado {
	protected int idEmpleado;
	protected String nombre;
	protected String apellido;
	protected int dni;
	protected double sueldoBase;
	protected int horaInicioJornada;
	protected int horaFinJornada;
	
	public Empleado() {}
	
	public Empleado(String nombre, String apellido, int dni, double sueldoBase, int horaInicioJornada,
			int horaFinJornada) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.sueldoBase = sueldoBase;
		this.horaInicioJornada = horaInicioJornada;
		this.horaFinJornada = horaFinJornada;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	protected void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public int getHoraInicioJornada() {
		return horaInicioJornada;
	}

	public void setHoraInicioJornada(int horaInicioJornada) {
		this.horaInicioJornada = horaInicioJornada;
	}

	public int getHoraFinJornada() {
		return horaFinJornada;
	}

	public void setHoraFinJornada(int horaFinJornada) {
		this.horaFinJornada = horaFinJornada;
	}

	@Override
	public String toString() {
		return "Empleado: [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", sueldoBase=" + sueldoBase + ", horaInicioJornada=" + horaInicioJornada + ", horaFinJornada="
				+ horaFinJornada + "]";
	}
	
	
	
}
