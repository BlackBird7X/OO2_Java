package test;

import java.time.LocalDate;

import negocio.AlquilerABM;
import negocio.PropiedadABM;

public class Test {

	public static void main(String[] args) {

		PropiedadABM p = new PropiedadABM();
		AlquilerABM a = new AlquilerABM();
		
		System.out.println("CU 1:" + p.traerPropiedad());
		
		System.out.println("CU 2:");
		System.out.println(a.traerAlquiler(1));
		
		System.out.println("CU 3:");
		System.out.println(p.traerPropiedad(true));
		
		System.out.println("CU 4:");
		System.out.println(a.calcularPrecioFinal(a.traerAlquiler(1)));
		
		System.out.println("CU 5:");
		System.out.println(a.calcularPrecioFinal(LocalDate.of(2022, 3, 2), LocalDate.of(2022, 3, 9)));
	}

}
