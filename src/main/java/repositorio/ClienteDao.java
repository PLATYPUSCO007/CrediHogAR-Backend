package repositorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

public class ClienteDao extends RepositorioHibernate<Cliente> {

	public ClienteDao() {
		super(Cliente.class);
	}

	Cliente cliente = new Cliente();
	List<Cliente> clientes = new ArrayList<Cliente>();

	public Cliente buscarNombre(String nombre) {
		try {
			cliente = this.recuperar("nombre", nombre);
		} catch (Exception e) {
		}
		return cliente;
	}
	
	public Cliente buscarApellido(String apellido) {
		try {
			cliente = this.recuperar("apellido", apellido);
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

	public Cliente buscarID(int id) {
		try {
			cliente = this.recuperar("id", id);
		}catch(Exception e){
		}
		return cliente;
	}
	
	public Cliente buscarCalificacion(String calificacion) {
		try {
			cliente = this.recuperar("calificacion", calificacion);
		}catch(Exception e){
		}
		return cliente;
	}
	


}
