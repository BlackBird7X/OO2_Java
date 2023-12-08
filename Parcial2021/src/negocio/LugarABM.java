package negocio;

import dao.LugarDao;
import datos.Localidad;
import datos.Lugar;
import datos.Ubicacion;

public class LugarABM {
	LugarDao dao = new LugarDao();
	
//CU 2)
	public Ubicacion traerUbicacion(int id) {
		return dao.traerUbicacion(id);
	}
	
//CU 3)
	public Localidad traerLocalidad(int id) {
		return dao.traerLocalidad(id);
	}
	
//CU 4)
	public Lugar traerLugar(int id) {
		return dao.traerLugar(id);
	}
	
}
