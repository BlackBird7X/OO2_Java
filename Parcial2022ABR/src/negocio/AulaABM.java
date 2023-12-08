package negocio;

import dao.AulaDao;
import datos.Aula;

public class AulaABM {
	AulaDao dao = new AulaDao();
	
//CU: 2
	public Aula traer(int id) {
		return dao.traer(id);
	}
	
	
	
}
