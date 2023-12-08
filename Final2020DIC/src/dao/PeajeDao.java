package dao;

//import java.time.LocalDate;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

//import datos.Peaje;
import datos.Rodado;
import datos.Abonado;
//import datos.Abonado;
import datos.Manual;
import datos.Telepeaje;

public class PeajeDao {
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

// CU: 1
	@SuppressWarnings("unchecked")
	public List<Manual> traerManual() {
		List<Manual> aux = null;
		
		try {
			iniciaOperacion();
			aux = session.createQuery("from Manual").list();
		} finally {
			session.close();
		}
		return aux;
	}

// CU: 2
	@SuppressWarnings("unchecked")
	public List<Telepeaje> traerTelepeaje(){
		List<Telepeaje> aux = null;
		
		try {
			iniciaOperacion();
			aux = session.createQuery("from Telepeaje").list();
			for(Telepeaje t : aux) {
				Hibernate.initialize(t.getRodado());
				Hibernate.initialize(t.getRodado().getAbonado());
			}
		} finally {
			session.close();
		}
		return aux;
	}
	
// CU: 6	
	@SuppressWarnings("unchecked")
	public List<Telepeaje> traerTelepeaje(Rodado rodado) {
		List<Telepeaje> aux = null;
		
		try {
			iniciaOperacion();
			aux = session.createQuery("from Telepeaje t inner join fetch t.rodado r where r.rodado'"+rodado.getDominio()+"'").list();
			for (Telepeaje t : aux) {
				Hibernate.initialize(t.getRodado());
			}
		} finally {
			session.close();
		}
		return aux;
	}
	
// CU: 9	
	@SuppressWarnings("unchecked")
	public List<Telepeaje> traerTelepeaje(Abonado abonado) {
		List<Telepeaje> aux = null;
		
		try {
			iniciaOperacion();
			aux = session.createQuery("from Telepeaje t inner join fetch t.rodado r inner join fetch r.abonado a where a.dni='"+abonado.getDni()+"'").list();
			for (Telepeaje t : aux) {
				Hibernate.initialize(t.getRodado());
				Hibernate.initialize(t.getRodado().getAbonado());
			}
		} finally {
			session.close();
		}
		return aux;
	}
	
	
	
	
	
	
	
	
	
	
}