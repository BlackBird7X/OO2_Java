package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Almacen;
import datos.NotaPedido;
import datos.Pedido;
import datos.Producto;

public class StockDao {
	private static Session session;
	private Transaction tx;
	
	public void iniciaOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	public void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso de datos --> "+he);
	}
	
	public Almacen traerAlmacen(Producto producto) {
		Almacen aux = null;
		try {
			iniciaOperacion();
			String hql="from Almacen a inner join fetch a.producto p where p.idProducto="+producto.getIdProducto();
			aux = (Almacen) session.createQuery(hql).uniqueResult();	
			Hibernate.initialize(aux.getProducto());
			Hibernate.initialize(aux.getLotes());
		}finally {
			session.close();
		}
		return aux;
	}
	
	public Pedido traerPedido(Producto producto){
		Pedido aux = null;
	    try {
	        iniciaOperacion();
	        String hql = "from Pedido pe inner join fetch pe.producto p where p.idProducto=" + producto.getIdProducto();
	        aux = (Pedido) session.createQuery(hql).uniqueResult();
	        Hibernate.initialize(aux.getProducto());
	        Hibernate.initialize(aux.getNotasPedidos());
	   //como notasPedidos tiene a Cliente cliente dentro, tengo que inicializarlo para cada cliente con un for-each.    
	        for(NotaPedido n : aux.getNotasPedidos()) {
	        	Hibernate.initialize(n.getCliente());
	        }
	    } finally {
	        session.close();
	    }
	    return aux;
	}
	
	public int calcularCantidadAPedir(Producto producto) {
		int n = 0;
		Pedido p = traerPedido(producto);
		n = p.calcularCantidadAPedir();
		return n;
	}
}