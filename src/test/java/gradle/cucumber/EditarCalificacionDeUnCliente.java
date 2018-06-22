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

public class EditarCalificacionDeUnCliente {
	
	Session session;
	Transaction tx;
	Cliente cliente;
	ClienteDao clienteDao;
	
	@Given("inicia una sesion")
	public void inicia_una_sesion() {
		SessionFactoryProvider.destroy();

		session = SessionFactoryProvider.getInstance().createSession();
		tx = session.beginTransaction();

		Runner.addSession(session);
		clienteDao = new ClienteDao();
	}

	@When("Guardo el cliente")
	public void guardo_el_cliente() {
	    cliente = new Cliente();
	    cliente.setNombre("Alejandro");
	    cliente.setApellido("Peñuela");
	    cliente.setCalle("Mayo 467");
	    cliente.setEntreCalle("Valdivia");
	    cliente.setDNI(45667);
	    cliente.setTelefono(878636);
	    cliente.setCalificacion("NO_APTO");
	    clienteDao.guardar(cliente);
	}

	@And("edito la calificacion")
	public void edito_la_calificacion() {
	    cliente.setDNI(45667);
	    cliente.setCalificacion("APTO");
	    clienteDao.actualizar(cliente);
	    tx.commit();
	}

	@Then("imprime la nueva calificacion")
	public void imprime_la_nueva_calificacion() {
	    Assert.assertTrue(clienteDao.contiene("calificacion","Apto"));
	    session.close();
	}


}
