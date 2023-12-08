package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Localidad;
import datos.Lugar;
import datos.Ubicacion;

public class LugarDao {
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
	
//CU 4)
	public Lugar traerLugar(int id) {
		Lugar aux = null;
		
		try {
			iniciaOperacion();
			aux = session.get(Lugar.class, id);
		} finally {
			session.close();
		}	
		return aux;
	}
	
//CU 2)
	public Ubicacion traerUbicacion(int id) {
		Ubicacion aux = null;
		
		try {
			iniciaOperacion();
			aux = session.get(Ubicacion.class, id);
		} finally {
			session.close();
		}
		return aux;
	}
	
//CU 3)
	public Localidad traerLocalidad(int id) {
		Localidad aux = null;
		
		try {
			iniciaOperacion();
			aux = session.get(Localidad.class, id);
		} finally {
			session.close();
		}
		return aux;
	}
	
}
