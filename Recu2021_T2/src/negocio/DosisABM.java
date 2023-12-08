package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.DosisDao;
import datos.Dosis;
import datos.Persona;
import datos.Vacuna;

public class DosisABM {
	DosisDao dao = new DosisDao();
	
	public List<Dosis> traerDosis(Vacuna vacuna) {
		return dao.traerDosis(vacuna);
	}
	
	public List<Dosis> traerDosis(LocalDate fechaDesde, LocalDate fechaHasta) {
		return dao.traerDosis(fechaDesde, fechaHasta);
	}
	
	public List<Dosis> traerDosis(LocalDate fechaDesde, LocalDate fechaHasta, boolean tieneComorbilidades) {
		return dao.traerDosis(fechaDesde, fechaHasta, tieneComorbilidades);
	}
	
	public List<Dosis> traerDosis(Persona persona) {
		return dao.traerDosis(persona);
	}
}
