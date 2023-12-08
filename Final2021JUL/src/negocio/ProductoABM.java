package negocio;

import dao.ProductoDao;
import datos.Producto;

public class ProductoABM {
	ProductoDao dao = new ProductoDao();
	
	public Producto traerProducto(String codigo) {
		return dao.traerProducto(codigo);
	}
	
	

}