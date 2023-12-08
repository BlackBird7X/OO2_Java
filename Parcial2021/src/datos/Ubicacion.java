package datos;

import java.time.LocalDate;

import dao.PermisoDao;

public class Ubicacion extends Lugar{
	private double longitud;
	private double latitud;
	
	public Ubicacion() {}

	public Ubicacion(String lugar, double longitud, double latitud) {
		super(lugar);
		this.longitud = longitud;
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	@Override
	public String toString() {
		return super.toString() + "Ubicacion: [longitud=" + longitud + ", latitud=" + latitud + "]";
	}
	
//CU 4)
	public boolean ingresoHabilitado(int idPermiso, LocalDate dia) {
		boolean autorizacion = false;
		Permiso permiso = PermisoDao.getInstance().traerPermiso(idPermiso);

		if (permiso.getFecha().isEqual(dia)) {
			autorizacion = true;
		}
		return autorizacion;
	}
	
}
