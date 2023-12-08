package test;

import negocio.ProductoABM;
import negocio.StockABM;

public class Test {
	public static void main(String[] args) {
		ProductoABM producto = new ProductoABM();
		StockABM stock = new StockABM();
		
		System.out.println("CU 1: " + producto.traerProducto("003"));
		System.out.println("CU 2: ");
// Retorna el objeto Almacen con todos los atributos: idStock / producto / cantDeseable / cantMinima / lotes
// Para cada objeto Lote con sus atributos: idLote / fecha / cantInicial / cantExistente
		System.out.println(stock.traerAlmacen(producto.traerProducto("003")));
		System.out.println("CU 3: ");
		System.out.println("Cantidad de productos existentes: " + stock.traerAlmacen(producto.traerProducto("003")).cantProductosExistentes());
		System.out.println("CU 4: ");
		System.out.println(stock.traerPedido(producto.traerProducto("003")));
		System.out.println("CU 5: ");
		System.out.println(stock.calcularCantidadAPedir(producto.traerProducto("003")));
		
	}
}