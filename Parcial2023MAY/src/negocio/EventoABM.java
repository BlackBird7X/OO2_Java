package negocio;

import java.time.LocalDateTime;
import java.util.List;

import dao.EventoDao;
import datos.Dispositivo;
import datos.Evento;

public class EventoABM {
	EventoDao dao = new EventoDao();
	
//CASO DE USO: 3
	public Evento traer(Dispositivo dispositivo, LocalDateTime fechaHora) {
		return dao.traer(dispositivo, fechaHora);
	}
	
//CASO DE USO: 4	
	public int agregar(String descripcion, Dispositivo dispositivo, LocalDateTime fechaHora) throws Exception {
		Evento aux = traer(dispositivo, fechaHora);
		if(aux != null) {
			throw new Exception("Ya existe un evento para ese dispositivo en la misma fecha y hora.");
		}
		return dao.agregar(new Evento(descripcion, dispositivo, fechaHora));
	}
	
//CASO DE USO: 5
	public List<Evento> traer(){
		return dao.traer();
	}
	
//CASO DE USO: 6	
	public List<Evento> traer(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta){
		return dao.traer(fechaHoraDesde, fechaHoraHasta);
	}
	
//CASO DE USO: 7	
	public List<Evento> traer(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta, Dispositivo dispositivo){
		return dao.traer(fechaHoraDesde, fechaHoraHasta, dispositivo);
	}
}
