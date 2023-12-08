package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Hibernate;

import datos.Aula;

public class AulaDao {
	private static Session session;
	private Transaction tx;
	 
	public void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	 
	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
// CU: 2	
	public Aula traer(int idAula) {
		Aula aux = null;
		
		try {
			iniciaOperacion();
			aux = (Aula) session.createQuery("from Aula a where a.idAula="+idAula).uniqueResult();
			//la inicializo porque está dentro de Aula
			Hibernate.initialize(aux.getEdificio());
		} finally {
			session.close();
		}
		return aux;
	}
	
}
