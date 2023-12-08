package dao;

import org.hibernate.Hibernate;

//import java.util.List;

//import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

//import datos.Peaje;
import datos.Rodado;
//import datos.Abonado;
//import datos.Manual;
//import datos.Telepeaje;

public class RodadoDao {

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
	
// CU: 5	
	public Rodado traerRodado(String dominio) {
		Rodado aux = null;
			
		try {
			iniciaOperacion();
			aux = (Rodado) session.createQuery("from Rodado r where r.dominio='"+dominio+"'").uniqueResult();
			Hibernate.initialize(aux.getAbonado());
		} finally {
			session.close();
		}
		return aux;
	}
	
}
