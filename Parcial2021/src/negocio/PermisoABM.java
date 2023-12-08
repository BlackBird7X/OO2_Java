package negocio;

import dao.PermisoDao;
import datos.Permiso;

public class PermisoABM {
	PermisoDao dao = new PermisoDao();
	
//CU 1)
	public Permiso traerPermiso(int id) {
		return dao.traerPermiso(id);
	}
}
