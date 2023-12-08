package dao;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Dispositivo;
import datos.Evento;

public class EventoDao {
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
	
//CASO DE USO: 3
	public Evento traer(Dispositivo dispositivo, LocalDateTime fechaHora) {
		Evento aux = null;
		
		try {
			iniciaOperacion();
			aux = (Evento) session.createQuery("from Evento e inner join fetch e.dispositivo d where d.nombre='"+dispositivo.getNombre()+"'and e.fechaHora='"+fechaHora+"'").uniqueResult();
		} finally {
			session.close();
		}
		return aux;
	}
	
//CASO DE USO: 5	
	@SuppressWarnings("unchecked")
	public List<Evento> traer(){
		List<Evento> aux = null;
		
		try {
			iniciaOperacion();
			aux = session.createQuery("from Evento e").list();
		} finally {
			session.close();
		}
		return aux;
	}
	
//CASO DE USO: 6	
	@SuppressWarnings("unchecked")
	public List<Evento> traer(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta){
		List<Evento> aux = null;
		
		try {
			iniciaOperacion();
			aux = session.createQuery("from Evento e where e.fechaHora>='"+fechaHoraDesde+"'and e.fechaHora<='"+fechaHoraHasta+"'").list();
		for(Evento e : aux) {
			Hibernate.initialize(e.getDispositivo());
		}
		} finally {
			session.close();
		}
		return aux;
	}
	
//CASO DE USO: 7	
	@SuppressWarnings("unchecked")
	public List<Evento> traer(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta, Dispositivo dispositivo) {
		List<Evento> aux = null;
		
		try {
			iniciaOperacion();
			aux = session.createQuery("from Evento e inner join fetch e.dispositivo d where e.fechaHora>='"+ fechaHoraDesde +"'and e.fechaHora<='"+ fechaHoraHasta +"'and d.idDispositivo="+dispositivo.getIdDispositivo()).list();
		for(Evento e : aux) {
			Hibernate.initialize(e.getDispositivo());
		}
		} finally {
			session.close();
		}
		return aux;
	}
	
//CASO DE USO: ?
	public int agregar(Evento objeto) {
		int id = 0;
		
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
}
