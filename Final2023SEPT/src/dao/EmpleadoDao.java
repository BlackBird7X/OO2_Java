package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Empleado;

public class EmpleadoDao {
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
		
//CU: 1
	public Empleado traerEmpleado(int idEmpleado) {
		Empleado aux = null;
		
		try {
			iniciaOperacion();
			aux = (Empleado) session.createQuery("from Empleado e where e.idEmpleado="+idEmpleado).uniqueResult();
		} finally {
			session.close();
		}
		return aux;
	}
	
//CU: 4
	
}
