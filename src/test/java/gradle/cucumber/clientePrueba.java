package gradle.cucumber;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modelo.Cliente;
import repositorio.ClienteDao;
import repositorio.Runner;
import repositorio.SessionFactoryProvider;

public class clientePrueba {

	ClienteDao clienteDao;
	Cliente cliente;
	Session session;
	Transaction tx;

	@Given("un sistema")
	public void un_sistema() {
		SessionFactoryProvider.destroy();

		session = SessionFactoryProvider.getInstance().createSession();
		tx = session.beginTransaction();

		Runner.addSession(session);
		clienteDao = new ClienteDao();
	}

	@When("cargo un cliente al sistema")
	public void cargo_un_cliente_al_sistema() {
		cliente = new Cliente();
		cliente.setNombre("Luciano Scaliogne");
		cliente.setCalle("El Zonda 1255");
		cliente.setEntreCalle("Zulia y Mimbre");
		cliente.setTelefono(1123435643);
		clienteDao.guardar(cliente);

		tx.commit();
		// session.close();
	}

	@Then("deberia traer su id")
	public void deberia_traer_su_id() {
		Cliente mismoCliente = clienteDao.recuperar("id", 1);
		Assert.assertEquals(mismoCliente.getId(), cliente.getId());
		session.close();
	}

}
