package negocio;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import dao.DosisDao;
import datos.Dosis;
import datos.Vacuna;

public class DosisABM {
	DosisDao dao = new DosisDao();
	
	public List<Dosis> traerDosis(Vacuna vacuna) {
		return dao.traerDosis(vacuna);
	}
	
	public List<Dosis> traerDosis(LocalTime horaDesde, LocalTime horaHasta) {
		List<Dosis> aux = dao.traerDosis();
		List<Dosis> dosis = new ArrayList<Dosis>();
		
		for(Dosis d : aux) {
			if(d.getHora().isAfter(horaDesde) || d.getHora().equals(horaHasta) && d.getHora().isBefore(horaHasta) || d.getHora().equals(horaHasta)) {
				dosis.add(d);
			}
		}
		return dosis;
	}
	
	public List<Dosis> traerDosis(LocalTime horaDesde, LocalTime horaHasta, boolean tieneComorbilidades) {
		List<Dosis> dosis = new ArrayList<Dosis>();
		
		for(Dosis d : dao.traerDosis(horaDesde, horaHasta)) {
			if(d.getPersona().isTieneComorbilidad()==tieneComorbilidades) {
				dosis.add(d);
			}
		}
		return dosis;
	}

}
