package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.PeajeDao;
import datos.Abonado;
import datos.Manual;
//import datos.Peaje;
import datos.Rodado;
import datos.Telepeaje;

public class PeajeABM {
	PeajeDao dao = new PeajeDao();
	
// CU: 1	
	public List<Manual> traerManual() {
		return dao.traerManual();
	}
	
// CU: 2
	public List<Telepeaje> traerTelepeaje() {
		return dao.traerTelepeaje();
	}
	
// CU: 3
	public List<Manual> traerManual(LocalDate fecha) {
		List<Manual> aux = new ArrayList<Manual>();
		
		for(Manual m : traerManual()) {
			if(m.getFecha().isEqual(fecha)) {
				aux.add(m);
			}
		}
		return aux;
	}
	
// CU: 4
	public double cerrarCaja(LocalDate fecha) {
		double total = 0;
		
		for(Manual m : traerManual(fecha)) {
			total += m.getPrecio();
		}
		return total;
	}
	
// CU: 6	
	public List<Telepeaje> traerTelepeaje(Rodado rodado) {
		return dao.traerTelepeaje(rodado);
	}
	
// CU: 9
	public List<Telepeaje> traerTelepeaje(Abonado abonado) {
		return dao.traerTelepeaje(abonado);
	}
}
