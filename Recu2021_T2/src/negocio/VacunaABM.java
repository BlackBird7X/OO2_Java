package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.VacunaDao;
import datos.Vacuna;

public class VacunaABM {
	VacunaDao dao = new VacunaDao();
	
	public Vacuna traerVacuna(int codigo) {
		return dao.traerVacuna(codigo);
	}
	
	public List<Vacuna> traerVacuna(int mesesDesde, int mesesHasta){
		List<Vacuna> aux = new ArrayList<Vacuna>();
		List<Vacuna> vacunas = dao.traerVacuna();
		
		for(Vacuna v : vacunas) {
			int num = v.calcularMesesDesdeElaboracion(LocalDate.now());
			if(num>= mesesDesde && num >= mesesHasta) {
				aux.add(v);
			}
		}
		return aux;
	}
}
