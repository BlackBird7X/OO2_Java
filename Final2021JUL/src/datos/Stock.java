package datos;


public abstract class Stock {
	protected int idStock;
	protected Producto producto;

	public Stock() {}

	public Stock(Producto producto) {
		super();
		this.producto = producto;
	}
	
	public int getIdStock() {
		return idStock;
	}

	protected void setIdStock(int idStock) {
		this.idStock = idStock;
	}
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Stock [idStock=" + idStock + ", producto=" + producto + "]";
	}
}
