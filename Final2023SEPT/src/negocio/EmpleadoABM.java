package negocio;

import dao.EmpleadoDao;
import datos.Empleado;

public class EmpleadoABM {
	EmpleadoDao dao = new EmpleadoDao();
	
//CU: 1
	public Empleado traerEmpleado(int idEmpleado) {
		return dao.traerEmpleado(idEmpleado);
	}
		
		
		
		
		
		
		
		
		
		
}
