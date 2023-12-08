package datos;

import java.util.Set;

public class Almacen extends Stock{
	private int cantDeseable;
	private int cantMinima;
	private  Set<Lote> lotes;
	
	public Almacen(){}

	public Almacen(int cantDeseable, int cantMinima) {
		super();
		this.cantDeseable = cantDeseable;
		this.cantMinima = cantMinima;
	}

	public int getCantDeseable() {
		return cantDeseable;
	}

	public void setCantDeseable(int cantDeseable) {
		this.cantDeseable = cantDeseable;
	}

	public int getCantMinima() {
		return cantMinima;
	}

	public void setCantMinima(int cantMinima) {
		this.cantMinima = cantMinima;
	}
	
	public Set<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(Set<Lote> lotes) {
		this.lotes = lotes;
	}

    @Override
    public String toString() {       
        return "{" + " stock='" + super.toString() + "'" +
            " lotes='" + this.lotes.toString() + "'" +
            " cantDeseable='" + getCantDeseable() + "'" +
            ", cantMinima='" + getCantMinima() + "'" +
            "}";
    }
	
	public int cantProductosExistentes(){
		int n = 0;
		for(Lote l : lotes) {
			n = n + l.getCantExistente();
		}
		return n;
	}
}
