package repositorio;

import modelo.Cliente;
import modelo.Empleado;

public class EmpleadoDao extends RepositorioHibernate<Empleado>  {

	public EmpleadoDao() {
		super(Empleado.class);
		
	}

}
