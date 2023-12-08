package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import datos.Persona;

public class PersonaABM {
	PersonaDao dao = new PersonaDao();
	
	public List<Persona> traerPersona(int edadDesde, int edadHasta){
		List<Persona> personas = new ArrayList<Persona>();
		List<Persona> aux = dao.traerPersona(edadDesde, edadHasta);
		//si calcularEdad (le mando fecha de hoy porque la va a restar con fechaNacimiento) es menor y hago el rango
		for(Persona p : aux) {
			if((p.calcularEdad(LocalDate.now())>edadDesde) && (p.calcularEdad(LocalDate.now())<edadHasta)) {
				personas.add(p);
			}
		}
		return personas;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
