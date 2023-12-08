package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

//import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

import datos.Aula;
import datos.Espacio;

public class EspacioDao {
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
	
// CU: 3
	public Espacio traer(LocalDate fecha, char turno, Aula aula) {
		Espacio aux = null;
		
		try {
			iniciaOperacion();
			aux = (Espacio) session.createQuery("from Espacio e inner join fetch e.aula a where a.idAula='"+aula.getIdAula()+"' and e.fecha='"+fecha+"' and e.turno='"+turno+"'").uniqueResult();
		} finally {
			session.close();
		}
		return aux;
	}
	
// CU: 4
	public int agregar(Espacio objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
		} catch (HibernateException he){
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

}
