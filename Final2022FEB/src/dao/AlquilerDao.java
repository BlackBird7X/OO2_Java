package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Alquiler;

public class AlquilerDao {
	private static Session session;
	private Transaction tx;
	
	public void iniciaOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	public void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso de datos");
	}
	
	public Alquiler traerAlquiler(int id) {
		Alquiler a = null;
		try {
			iniciaOperacion();
			a = (Alquiler) session.get(Alquiler.class, id);
			//la inicializo porque está dentro de alquiler
			Hibernate.initialize(a.getPropiedad());
		} finally {
			session.close();
		}
		return a;
	}
	
	@SuppressWarnings("unchecked")
	public List<Alquiler> traerAlquiler(){
		List<Alquiler> aux = null;
		try {
			iniciaOperacion();
			aux = session.createQuery("from Alquiler").list();
			/* este for es porque tiene a la clase propiedad (-propiedad: Propiedad) dentro entonces
			la inicializo para cada alquiler en la lista */
			for(Alquiler a : aux) {
				Hibernate.initialize(a.getPropiedad());
			}
		} finally {
			session.close();
		}
		return aux;
	}
}
