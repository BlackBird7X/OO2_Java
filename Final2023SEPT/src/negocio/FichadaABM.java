package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.FichadaDao;
import datos.Empleado;
import datos.Fichada;
import datos.Operario;
import datos.Supervisor;

public class FichadaABM {
	FichadaDao dao = new FichadaDao();
	
//CU: 2
	public List<Fichada> traerFichadas(Empleado empleado, LocalDate fechaDesde, LocalDate fechaHasta, boolean entrada) {
		return dao.traerFichadas(empleado, fechaDesde, fechaHasta, entrada);
	}
	
//CU: 3
		public int cantidadHorasExtras(Empleado empleado, LocalDate fechaDesde, LocalDate fechaHasta) {
			int total = 0;
			int jornadaInicio = empleado.getHoraInicioJornada();
			int jornadaFin = empleado.getHoraFinJornada();
			List<Fichada> listaAux = traerFichadas(empleado, fechaDesde, fechaHasta, true);
				
			for(Fichada f : listaAux) {
				if(f.getFecha().isAfter(fechaDesde) || f.getFecha().equals(fechaDesde) && f.getFecha().isBefore(fechaHasta) || f.getFecha().equals(fechaHasta)) {
					if(f.getHora().getHour() < jornadaInicio || f.getHora().getHour() > jornadaFin) {
						total += (f.getHora()).getHour();
					}
					if(f.getHora().getHour() > jornadaInicio || f.getHora().getHour() < jornadaFin) {
						total -= f.getHora().getHour() - jornadaInicio;
					}
				}
			}	
			return total;
		}

//CU: 4
	public boolean tienePresentismo(Empleado empleado, LocalDate fechaDesde, LocalDate fechaHasta) {
		boolean verificador = false;
		int aux = 0;
		List<Fichada> listaAux = traerFichadas(empleado, fechaDesde, fechaHasta, true);
		
		for(Fichada f : listaAux) {
			aux = (fechaHasta.getDayOfMonth() - fechaDesde.getDayOfMonth()) + 1;
			if(aux == 2) {
				verificador = true;
			}
		}
		return verificador;
	}
	
//CU: 5	
	public double calcularSueldoFinal(Empleado empleado, LocalDate fechaDesde, LocalDate fechaHasta) {
		double total = 0;
		List<Fichada> listaAux = traerFichadas(empleado, fechaDesde, fechaHasta, true);
		
		for(Fichada f : listaAux) {
			if(f.getFecha().isAfter(fechaDesde) || f.getFecha().equals(fechaDesde) && f.getFecha().isBefore(fechaHasta) || f.getFecha().equals(fechaHasta)) {
				if(empleado instanceof Operario) {
					total = empleado.getSueldoBase() + (cantidadHorasExtras(empleado, fechaDesde, fechaHasta) + empleado.getSueldoBase() + ((Operario) empleado).getPlusHoraExtra() / 100);
				} else {
					total = empleado.getSueldoBase() + (empleado.getSueldoBase() * ((Supervisor) empleado).getPlusPresentismo() / 100);
				}
			}
		}
		return total;
	}	
		
	
}
