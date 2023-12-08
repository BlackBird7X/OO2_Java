package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import negocio.DispositivoABM;
import negocio.EventoABM;

import datos.Dispositivo;
import datos.Evento;

public class test {

	public static void main(String[] args) {
		DispositivoABM d = new DispositivoABM();
		EventoABM e = new EventoABM();
		
		System.out.println("CU: 1  \n" + d.traer());
		
		System.out.println("CU: 2");
		try {
			System.out.println(e.agregar("Apertura de la cortina", d.traer("cortina pieza"), LocalDateTime.of(LocalDate.of(2023, 04, 03), LocalTime.of(9, 10))));
		} catch (Exception excp) {
			System.out.println(excp);
		}
		try {
			System.out.println(e.agregar("Cierre de la cortina", d.traer("cortina pieza"), LocalDateTime.of(LocalDate.of(2023, 04, 03), LocalTime.of(19, 05))));
		} catch (Exception excp) {
			System.out.println(excp);
		}
		try {
			System.out.println(e.agregar("Apertura de la cortina", d.traer("cortina pieza"), LocalDateTime.of(LocalDate.of(2023, 04, 04), LocalTime.of(9, 00))));
		} catch (Exception excp) {
			System.out.println(excp);
		}
		try {
			System.out.println(e.agregar("Cierre de la cortina", d.traer("cortina pieza"), LocalDateTime.of(LocalDate.of(2023, 04, 04), LocalTime.of(19, 01))));
		} catch (Exception excp) {
			System.out.println(excp);
		}
		try {
			System.out.println(e.agregar("23 grados. Prender aire acondicionado", d.traer("temp pieza"), LocalDateTime.of(LocalDate.of(2023, 04, 04), LocalTime.of(11, 30))));
		} catch (Exception excp) {
			System.out.println(excp);
		}
		try {
			System.out.println(e.agregar("20 grados. Apagar aire acondicionado", d.traer("temp pieza"), LocalDateTime.of(LocalDate.of(2023, 04, 04), LocalTime.of(12, 00))));
		} catch (Exception excp) {
			System.out.println(excp);
		}
		try {
			System.out.println(e.agregar("Apertura de la cortina", d.traer("cortina pieza"), LocalDateTime.of(LocalDate.of(2023, 04, 05), LocalTime.of(9, 05))));
		} catch (Exception excp) {
			System.out.println(excp);
		}
		try {
			System.out.println(e.agregar("Cierre de la cortina", d.traer("cortina pieza"), LocalDateTime.of(LocalDate.of(2023, 04, 05), LocalTime.of(19, 05))));
		} catch (Exception excp) {
			System.out.println(excp);
		}
		
		System.out.println("CU: 3");
		System.out.println(e.traer(LocalDateTime.of(LocalDate.of(2023, 4, 3), LocalTime.of(12, 00)), LocalDateTime.of(LocalDate.of(2023, 4, 5), LocalTime.of(12, 00))));
		
		//Los creo para usar de parametros
		LocalDate fechaDesde = LocalDate.of(2023, 4, 3);
		LocalTime horaDesde = LocalTime.of(12, 00);
		LocalDateTime fechaHoraDesde = LocalDateTime.of(fechaDesde, horaDesde);
		
		LocalDate fechaHasta = LocalDate.of(2023, 4, 5);
		LocalTime horaHasta = LocalTime.of(12, 00);
		LocalDateTime fechaHoraHasta = LocalDateTime.of(fechaHasta, horaHasta);
		
		System.out.println("CU: 4");
		System.out.println(e.traer(fechaHoraDesde, fechaHoraHasta, d.traer("cortina pieza")));
		
		System.out.println("CU: 5");
		System.out.println(d.traerTodosLosDispositivosSensorTemperatura());
		
		
		
		
		
		
		
		
		

	}
}
