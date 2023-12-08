package datos;

import java.time.LocalDate;

import dao.PermisoDao;

public class Localidad extends Lugar{
	private String codPostal;
	private boolean cumplirCuarentena;
	
	public Localidad() {}
	
	public Localidad(String lugar, String codPostal, boolean cumplirCuarentena) {
		super(lugar);
		this.codPostal = codPostal;
		this.cumplirCuarentena = cumplirCuarentena;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public boolean isCumplirCuarentena() {
		return cumplirCuarentena;
	}

	public void setCumplirCuarentena(boolean cumplirCuarentena) {
		this.cumplirCuarentena = cumplirCuarentena;
	}

	@Override
	public String toString() {
		return super.toString() + "Localidad: [codPostal=" + codPostal + ", cumplirCuarentena=" + cumplirCuarentena + "]";
	}
	
//CU 4)
	public boolean ingresoHabilitado(int idPermiso, LocalDate dia) {
		boolean autorizacion = false;
		Permiso permiso = PermisoDao.getInstance().traerPermiso(idPermiso);
		LocalDate fechaVencimiento = permiso.getFecha().plusDays(permiso.getCantDias());
		
		if(dia.isAfter(permiso.getFecha())&& dia.isBefore(fechaVencimiento) || dia.isEqual(permiso.getFecha()) || dia.isEqual(fechaVencimiento)) {
			autorizacion = true;
		}
		return autorizacion;
	}
	
}
