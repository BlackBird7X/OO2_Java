package test;

import java.time.LocalDate;

import negocio.AbonadoABM;
import negocio.PeajeABM;
import negocio.RodadoABM;

public class Test {

	public static void main(String[] args) {
		AbonadoABM a = new AbonadoABM();
		RodadoABM r = new RodadoABM();
		PeajeABM p = new PeajeABM();

		System.out.println("CU 1: " + p.traerManual());
		System.out.println("CU 2:");
		System.out.println(p.traerTelepeaje());
		System.out.println("CU 3:");
		System.out.println(p.traerManual(LocalDate.of(2020, 11, 02)));
		System.out.println("CU 4:");
		System.out.println(p.cerrarCaja(LocalDate.of(2020, 11, 02)));
		System.out.println("CU 5:");
		System.out.println(r.traerRodado("AAA111"));
		System.out.println("CU 6:");
//		System.out.println(p.traerTelepeaje(r.traerRodado("AAA111")));
		System.out.println("CU 7:");
		System.out.println(a.traerAbonado(11111111));
		System.out.println("CU 8:");
		System.out.println(p.traerTelepeaje(a.traerAbonado(11111111)));
		
		
//FALTA: traerTelepeaje por Rodado - CU: 6
//calcularDescuento (CU: 7) PORQUE NO DICE DE CUÁNTO ES
		
		
		
		
		
		
		
	}
}

