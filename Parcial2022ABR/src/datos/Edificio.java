package datos;

import java.util.Objects;
import java.util.Set;

public class Edificio {
	private int idEdificio;
	private String edificio;
	private Set<Aula> aulas;
	
	public Edificio() {}
	
	public Edificio(String edificio) {
		super();
		this.edificio = edificio;
	}

	public int getIdEdificio() {
		return idEdificio;
	}

	protected void setIdEdificio(int idEdificio) {
		this.idEdificio = idEdificio;
	}

	public String getEdificio() {
		return edificio;
	}

	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}

	public Set<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(Set<Aula> aulas) {
		this.aulas = aulas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aulas, edificio, idEdificio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edificio other = (Edificio) obj;
		return Objects.equals(aulas, other.aulas) && Objects.equals(edificio, other.edificio) && idEdificio == other.idEdificio;
	}

	@Override
	public String toString() {
		return "Edificio [idEdificio=" + idEdificio + ", edificio=" + edificio + ", aulas=" + aulas + "]";
	}
	
}
