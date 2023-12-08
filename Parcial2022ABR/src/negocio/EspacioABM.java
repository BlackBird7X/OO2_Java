package negocio;

import java.time.LocalDate;

import dao.EspacioDao;
import datos.Aula;
import datos.Espacio;

public class EspacioABM {
	EspacioDao dao = new EspacioDao();
	
//CU: 3
	public Espacio traer(LocalDate fecha, char turno, Aula aula) {
		return dao.traer(fecha, turno, aula);
	}
}
