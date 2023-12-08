package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Manual extends Peaje {
	private String codCabina;

	public Manual() {}

	public Manual(String codCabina, LocalDate fecha, LocalTime hora, double precio) {
		super(fecha, hora, precio);
		this.codCabina = codCabina;
	}

	public String getCodCabina() {
		return codCabina;
	}

	public void setCodCabina(String codCabina) {
		this.codCabina = codCabina;
	}

	@Override
	public String toString() {
		return "Manual: [codCabina=" + codCabina + "]";
	}
}
