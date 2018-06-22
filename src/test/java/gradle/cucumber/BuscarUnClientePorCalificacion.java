package gradle.cucumber;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import modelo.Cliente;
import repositorio.ClienteDao;
import repositorio.Runner;
import repositorio.SessionFactoryProvider;

public class BuscarUnClientePorCalificacion {
	
	Session session;
	Transaction tx;
	Cliente cliente;
	ClienteDao clienteDao;
	Cliente clienteBuscar;
	
	@Given("inicia el sistema")
	public void inicia_el_sistema() {
		SessionFactoryProvider.destroy();

		session = SessionFactoryProvider.getInstance().createSession();
		tx = session.beginTransaction();

		Runner.addSession(session);
		clienteDao = new ClienteDao();
	}

	@When("Guardo cliente")
	public void guardo_cliente() {
		cliente = new Cliente();
		cliente.setNombre("Carlos");
		cliente.setApellido("Perez");
		cliente.setCalle("Palta 344");
		cliente.setEntreCalle("chirimuyo");
		cliente.setTelefono(12312);
		cliente.setDNI(123);
		cliente.setCalificacion("APTO");
		clienteDao.guardar(cliente);
	    
	}

	@And("Busco el cliente por su calificacion")
	public void busco_el_cliente_por_su_calificacion() {
		clienteBuscar = clienteDao.buscarCalificacion("Apto");
		tx.commit();
	}

	@Then("devuelve sus datos")
	public void devuelve_sus_datos() {
	    Assert.assertEquals("Apto", clienteBuscar.getCalificacion());
	}


}
