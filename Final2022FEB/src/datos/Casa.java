package datos;

public class Casa extends Propiedad{
	private boolean tienePatio;

	public Casa() {}
	
	public Casa(boolean tienePatio, double precioBase, String direccion) {
		super(precioBase, direccion);
		this.tienePatio = tienePatio;
	}

	public boolean isTienePatio() {
		return tienePatio;
	}

	public void setTienePatio(boolean tienePatio) {
		this.tienePatio = tienePatio;
	}

	@Override
	public String toString() {
		return super.toString() + "Casa: [tienePatio=" + tienePatio + "]";
	}
	
	public double precioPorNoche() {
		double n=0;
		if(this.tienePatio) {
			n = this.precioBase + (this.precioBase * 0.1);
		} else {
			n = this.precioBase;
		}
		return n;
	}
}
