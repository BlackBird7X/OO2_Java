package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Abonado;


public class AbonadoDao {
	private static Session session;
	private Transaction tx;
	
	public void iniciaOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	public void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso de datos --> "+he);
	}
	
// CU: 8	
	public Abonado traerAbonado(long dni) {
		Abonado aux = null;
		
		try {
			iniciaOperacion();
			aux = (Abonado) session.createQuery("from Abonado a where a.dni="+dni).uniqueResult();
		} finally {
			session.close();
		}
		return aux;
	}
}
