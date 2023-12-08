package negocio;

import dao.AbonadoDao;
import datos.Abonado;

public class AbonadoABM {
	AbonadoDao dao = new AbonadoDao();
	
// CU: 8	
	public Abonado traerAbonado(long dni) {
		return dao.traerAbonado(dni);
	}
}
