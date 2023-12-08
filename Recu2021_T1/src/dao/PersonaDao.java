package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Persona;

public class PersonaDao {
	private static Session session;
	private Transaction tx;
	
	public void iniciaOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	public void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso de datos -->" +he);	
	}	
	
	@SuppressWarnings("unchecked")
	public List<Persona> traerPersona(int edadDesde, int edadHasta){
		List<Persona> aux = null;
		
		try {
			iniciaOperacion();
			aux = session.createQuery("from Persona").list();
		} finally {
			session.close();
		}
		return aux;
	}
}
