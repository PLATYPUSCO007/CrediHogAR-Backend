package gradle.cucumber;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modelo.Cliente;
import repositorio.ClienteDao;
import repositorio.Runner;
import repositorio.SessionFactoryProvider;

public class AsignarCalificacion_Cliente {
	
	Session session;
	Transaction tx;
	Cliente cliente;
	ClienteDao clienteDao;
	

	@Given("inicia sesion")
	public void inicia_sesion() {
		SessionFactoryProvider.destroy();

		session = SessionFactoryProvider.getInstance().createSession();
		tx = session.beginTransaction();

		Runner.addSession(session);
		clienteDao = new ClienteDao();
	}

	@When("Guardo un cliente")
	public void guardo_un_cliente() {
		cliente = new Cliente();
		cliente.setNombre("Lucia");
		cliente.setApellido("Jaramillo");
		cliente.setCalle("Av Mayo 576");
		cliente.setEntreCalle("Palermo");
		cliente.setDNI(86544);
		cliente.setTelefono(972340);

	}

	@And("le asigno una calificacion")
	public void le_asigno_una_calificacion() {
		cliente.setCalificacion("NO_APTO");
		clienteDao.guardar(cliente);
		tx.commit();
	}

	@Then("imprime la calificacion")
	public void imprime_la_calificacion() {
		Assert.assertTrue(clienteDao.contiene("calificacion", "No Apto"));	
		session.close();
	}

}
