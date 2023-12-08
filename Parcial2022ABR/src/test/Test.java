package test;

import java.time.LocalDate;

import negocio.AulaABM;
import negocio.EdificioABM;
import negocio.EspacioABM;

public class Test {

	public static void main(String[] args) {
		
		AulaABM aul = new AulaABM();
		EdificioABM edif = new EdificioABM();
		EspacioABM esp = new EspacioABM();
		
		
		System.out.println("CU 1: \n" + edif.traerEdificioConAulas(1));
	
		System.out.println("\nCU 2: ");
		System.out.println(aul.traer(5));	
		
		System.out.println("\nCU 3: ");
		System.out.println(esp.traer(LocalDate.of(2022, 05, 01), 'M', aul.traer(5)));
	
		System.out.println("\nCU 4: ");
		System.out.println();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
