package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Hibernate;
//import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

import datos.Edificio;

public class EdificioDao {
	private static Session session;
	private Transaction tx;
	 public void iniciaOperacion() throws HibernateException {
	session =
	HibernateUtil.getSessionFactory().openSession();
	tx = session.beginTransaction();
	}
	protected void manejaExcepcion(HibernateException he) throws
	HibernateException { tx.rollback();
	throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	
	
	
	
// CU: 1
	public Edificio traerEdificioConAulas(int idEdificio) {
		Edificio aux = null;
		
		try {
			iniciaOperacion();
			aux = (Edificio) session.createQuery("from Edificio e where e.idEdificio="+idEdificio).uniqueResult();
			Hibernate.initialize(aux.getAulas());
		} finally {
			session.close();
		}
		return aux;
	}
	
	
	
}















