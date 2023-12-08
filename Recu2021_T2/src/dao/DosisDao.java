package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Dosis;
import datos.Persona;
import datos.Vacuna;

public class DosisDao {
	private static Session session;
	private Transaction tx;
	
	public void iniciaOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx =  session.beginTransaction();
	}
	
	public void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso de datos --> "+he);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dosis> traerDosis(Vacuna vacuna) {
		List<Dosis> aux = null;
		
		try {
			iniciaOperacion();
			aux = session.createQuery("from Dosis d inner join fetch d.vacuna v where v.idVacuna="+ vacuna.getIdVacuna()).list();
			for (Dosis d : aux) {
				Hibernate.initialize(d.getVacuna());
				Hibernate.initialize(d.getPersona());
			}
		} finally {
			session.close();
		}
		return aux;
	}
	
	@SuppressWarnings("unchecked")
	public List<Dosis> traerDosis(LocalDate fechaDesde, LocalDate fechaHasta) {
		List<Dosis> aux = null;
	
		try {
			iniciaOperacion();
			aux = session.createQuery("from Dosis d where d.fecha>='"+fechaDesde+"' and d.fecha<='"+fechaHasta+"'").list();
			for(Dosis d : aux) {
				Hibernate.initialize(d.getVacuna());
				Hibernate.initialize(d.getPersona());
			}
		} finally {
			session.close();
		}
		return aux;
	}
	
	@SuppressWarnings("unchecked")
	public List<Dosis> traerDosis(Persona persona) {
		List<Dosis> aux = null;
		
		try {
			iniciaOperacion();
			aux = session.createQuery("from Dosis d inner join fetch d.persona p where p.documento="+ persona.getDocumento()).list();
			for (Dosis d : aux) {
				Hibernate.initialize(d.getVacuna());
				Hibernate.initialize(d.getPersona());
			}
		} finally {
			session.close();
		}
		return aux;
	}
	
	@SuppressWarnings("unchecked")
	public List<Dosis> traerDosis(LocalDate fechaDesde, LocalDate fechaHasta, boolean tieneComorbilidades) {
		List<Dosis> aux = null;
	
		try {
			iniciaOperacion();
			aux = session.createQuery("from Dosis d where d.fecha>='"+fechaDesde+"' and d.fecha<='"+fechaHasta+"' and d.tieneComorbilidades='"+tieneComorbilidades+"'").list();
			for(Dosis d : aux) {
				Hibernate.initialize(d.getVacuna());
				Hibernate.initialize(d.getPersona());
			}
		} finally {
			session.close();
		}
		return aux;
	}
	
}
