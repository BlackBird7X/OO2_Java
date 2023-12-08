package negocio;

import java.util.List;

import dao.DispositivoDao;
import datos.Dispositivo;

public class DispositivoABM {
	DispositivoDao dao = new DispositivoDao();
	
//CASO DE USO: 1	
	public List<Dispositivo> traer(){
		return dao.traer();
	}
	
//CASO DE USO: 2	
	public Dispositivo traer(String nombre) {
		return dao.traer(nombre);
	}
	
//CASO DE USO: 8	
	public List<Dispositivo> traerTodosLosDispositivosSensorTemperatura() {
		return dao.traerTodosLosDispositivosSensorTemperatura();
	}

}
