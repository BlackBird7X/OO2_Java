package test;

import java.time.LocalDate;

import negocio.EmpleadoABM;
import negocio.FichadaABM;

public class Test {

	public static void main(String[] args) {
		EmpleadoABM empleado = new EmpleadoABM();
		FichadaABM fichada = new FichadaABM();
		
		System.out.println("CU: 1  " + empleado.traerEmpleado(2));
		
		System.out.println("CU: 2");
		System.out.println(fichada.traerFichadas(empleado.traerEmpleado(1), LocalDate.of(2023, 9, 04), LocalDate.of(2023, 9, 05), true));
		
		System.out.println("CU: 3");
		System.out.println(fichada.cantidadHorasExtras(empleado.traerEmpleado(1), LocalDate.of(2023, 9, 04), LocalDate.of(2023, 9, 05)));
		
		System.out.println("CU: 4");
		System.out.println(fichada.tienePresentismo(empleado.traerEmpleado(3), LocalDate.of(2023, 9, 04), LocalDate.of(2023, 9, 05)));
		
		System.out.println("CU: 5");
		System.out.println(fichada.calcularSueldoFinal(empleado.traerEmpleado(1), LocalDate.of(2023, 9, 04), LocalDate.of(2023, 9, 05)));
		
		
		
		
	}
}
