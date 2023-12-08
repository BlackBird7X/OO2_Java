package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Permiso;

public class PermisoDao {
	private static Session session;
	private Transaction tx;
	private static PermisoDao instancia = null; //Patron singleton
	
	public void iniciaOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	public void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso de datos");
	}
	
	public static PermisoDao getInstance() {
		if (instancia == null)
			instancia = new PermisoDao();
		return instancia;
	}
	
//CU 1)
	public Permiso traerPermiso(int idPermiso) {
		Permiso aux = null;
		
		try {
			iniciaOperacion();
			aux = (Permiso) session.createQuery("from Permiso p where p.idPermiso="+idPermiso).uniqueResult();
			Hibernate.initialize(aux.getPersona());
			Hibernate.initialize(aux.getRodado());
			
		} finally {
			session.close();
		}
		return aux;
	}
}
