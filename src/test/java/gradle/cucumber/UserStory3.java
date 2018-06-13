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

public class UserStory3 {

	Cliente cliente;
	ClienteDao clienteDao;
	Transaction tx;
	Session session;
	Cliente buscarDni;

	@Given("iniciar sesion")
	public void iniciar_sesion() {
		SessionFactoryProvider.destroy();

		session = SessionFactoryProvider.getInstance().createSession();
		tx = session.beginTransaction();

		Runner.addSession(session);
		clienteDao = new ClienteDao();
	}

	@When("busco un cliente por su DNI")
	public void busco_un_cliente_por_su_DNI() {
		cliente = new Cliente();
		cliente.setDNI(12334);
		clienteDao.guardar(cliente);
		buscarDni = clienteDao.buscarDni(12334);

		tx.commit();
	}

	@Then("imprime el DNI en pantalla")
	public void imprime_el_DNI_en_pantalla() {
		Assert.assertEquals(cliente.getDNI(), buscarDni.getDNI());
		session.close();
	}

}
