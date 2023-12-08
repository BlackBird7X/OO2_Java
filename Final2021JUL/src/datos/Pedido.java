package datos;

import java.util.Set;

public class Pedido extends Stock{
	private Set<NotaPedido> notasPedidos;

	public Pedido() {}

	public Pedido(Producto producto) {
		super(producto);
	}

	public Set<NotaPedido> getNotasPedidos() {
		return notasPedidos;
	}

	public void setNotasPedidos(Set<NotaPedido> notasPedidos) {
		this.notasPedidos = notasPedidos;
	}

    @Override
    public String toString() {
        return "{" +
            " notasPedidos='" + getNotasPedidos() + "'" +
            "}";
    }
	
	public int calcularCantidadAPedir(){
    	int n = 0;
    	for(NotaPedido nota : notasPedidos) {
    		if(nota.isEntregado()) {
    			n++;
    		}
    	}
    	return n;
    }
	
}
