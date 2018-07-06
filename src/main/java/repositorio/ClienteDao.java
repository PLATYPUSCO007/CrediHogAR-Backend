package repositorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import modelo.Articulo;
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
	
	public List<Cliente> buscarClientesSimilares(String campo, String valor) {
		String valorBuscado = "%" + valor + "%";
		Session session = Runner.getCurrentSession();
		String hql = "FROM Cliente a WHERE a. " + campo + " LIKE '" + valorBuscado + "' ";
		Query query = session.createQuery(hql);
		List<Cliente> clientes = (List<Cliente>) query.getResultList();
		return clientes;
	}
	


}
