package negocio;

import dao.VacunaDao;
import datos.Vacuna;

public class VacunaABM {
	VacunaDao dao = new VacunaDao();
	
	public Vacuna traerVacuna(int codigo) {
		return dao.traerVacuna(codigo);
	}
	
}
