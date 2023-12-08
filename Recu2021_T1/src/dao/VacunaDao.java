package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Vacuna;

public class VacunaDao {
	private static Session session;
	private Transaction tx;

	public void iniciaOperacion() throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	public void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("Error en la capa de acceso de datos --> "+he);
	}
	
	public Vacuna traerVacuna(int codigo) {
		Vacuna aux = null;
		
		try {
			iniciaOperacion();
			aux = (Vacuna)session.createQuery("from Vacuna v where v.codigo='"+codigo+"'").uniqueResult();
		} finally {
			session.close();
		}	
		return aux;
	}
	
	@SuppressWarnings("unchecked")
	public List<Vacuna> traerVacuna(Vacuna vacuna){
		List<Vacuna> aux = null;
		
		try {
			iniciaOperacion();
			aux = session.createQuery("from Vacuna v").list();
		} finally {
			session.close();
		}
		return aux;
	}
	
}
