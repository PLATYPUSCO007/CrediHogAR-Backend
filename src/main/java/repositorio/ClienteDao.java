package repositorio;

import modelo.Cliente;

public class ClienteDao extends RepositorioHibernate<Cliente> {

	public ClienteDao() {
		super(Cliente.class);
	}

	Cliente cliente = new Cliente();

	public Cliente buscarNombre(String nombre) {
		try {
			cliente = this.recuperar("nombre", nombre);
		} catch (Exception e) {
		}
		return cliente;
	}

	public Cliente buscarDni(int dni) {
		try {
			cliente = this.recuperar("DNI", dni);
		} catch (Exception e) {
		}
		return cliente;
	}

}
