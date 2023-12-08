package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Empleado;
import datos.Fichada;

public class FichadaDao {
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
		
//CU: 2
	@SuppressWarnings("unchecked")
	public List<Fichada> traerFichadas(Empleado empleado, LocalDate fechaDesde, LocalDate fechaHasta, boolean entrada) {
		List<Fichada> aux = null;
		
		try {
			iniciaOperacion();
			aux = session.createQuery("from Fichada f inner join fetch f.empleado e where e.idEmpleado='"+empleado.getIdEmpleado()+"' and f.fecha>='"+fechaDesde+"' and f.fecha<='"+fechaHasta+"' and entrada='"+entrada+"'").list();
		} finally {
			session.close();
		}
		return aux;
	}
		
		
		
		
		
		
		
}
