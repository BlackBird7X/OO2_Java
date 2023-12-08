package test;

import java.time.LocalDate;

import negocio.DosisABM;
import negocio.PersonaABM;
import negocio.VacunaABM;

public class Test {

	public static void main(String[] args) {
		// public Persona traerPersona(long documento)
		// public int calcularMesesDesdeElaboracion(LocalDate hoy)  - ESTA HECHO EN datos.Persona
		// public List<Vacuna> traerVacuna(int mesesDesde, int mesesHasta)
		// public List<Dosis> traerDosis(Persona persona)
		// public List<Dosis> traerDosis(LocalDate fechaDesde, LocalDate fechaHasta)
		// public List<Dosis> traerDosis(LocalDate fechaDesde, LocalDate fechaHasta, boolean tieneComorbilidades)

		PersonaABM persona = new PersonaABM();
		VacunaABM vacuna = new VacunaABM();
		DosisABM dosis = new DosisABM();
		
		System.out.println("CU: 1 " + persona.traerPersona(33333333));
		System.out.println("CU: 2");
		System.out.println(vacuna.traerVacuna(1, 2));
		System.out.println("CU: 3");
		System.out.println(dosis.traerDosis(persona.traerPersona(33333333)));
		System.out.println("CU: 4");
		System.out.println(dosis.traerDosis(LocalDate.of(2020, 06, 01), LocalDate.of(2020, 06, 05)));
		System.out.println("CU: 5");
		System.out.println(dosis.traerDosis(LocalDate.of(2020, 06, 01), LocalDate.of(2020, 06, 05), true));
	}
	
}
