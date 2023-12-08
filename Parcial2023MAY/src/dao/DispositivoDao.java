package dao;

import java.util.List;

//import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Dispositivo;

public class DispositivoDao {
	private static Session session;
	private Transaction tx;
	
	public void iniciaOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	public void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso de datos--> " + he);
	}
	
//CASO DE USO: 1
	@SuppressWarnings("unchecked")
	public List<Dispositivo> traer(){
		List<Dispositivo> aux = null;
		try {
			iniciaOperacion();
			aux = session.createQuery("from Dispositivo d").list();
		} finally {
			session.close();
		}
		return aux;
	}
	
//CASO DE USO: 2
	public Dispositivo traer(String nombre) {
		Dispositivo aux = null;
		try {
			iniciaOperacion();
			aux = (Dispositivo) session.createQuery("from Dispositivo d where d.nombre='" + nombre + "'").uniqueResult();
		}
		finally {
			session.close();
		}
		return aux;
	}
	
//CASO DE USO: 8
	@SuppressWarnings("unchecked")
	public List<Dispositivo> traerTodosLosDispositivosSensorTemperatura(){
		List<Dispositivo> aux = null;
		
		try {
			iniciaOperacion();
			aux = session.createQuery("from SensorTemperatura").list();
		} finally {
			session.close();
		}
		return aux;
	}
	
}
