package repositorio;

import modelo.Cliente;

public class ClienteDao extends RepositorioHibernate<Cliente>{
	
	public ClienteDao() {
		super(Cliente.class);
	}
}
