package gradle.cucumber;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import modelo.Cliente;
import repositorio.ClienteDao;
import repositorio.Runner;
import repositorio.SessionFactoryProvider;

public class UserStory2 {
	
	ClienteDao clienteDao;
	Cliente cliente;
	Session session;
	Transaction tx;
	Cliente name;
	
	@Given("inicio de sesion")
	public void inicio_de_sesion() {
		SessionFactoryProvider.destroy();
		
		session = SessionFactoryProvider.getInstance().createSession();
		tx = session.beginTransaction();
		
		Runner.addSession(session);
		clienteDao = new ClienteDao();
	}
	
	
	@When("busco un cliente por su nombre")
	public void busco_un_cliente_por_su_nombre() {
		cliente = new Cliente();
		cliente.setNombre("Prueba");
		clienteDao.guardar(cliente);
		name = clienteDao.recuperar("nombre", "Prueba");
		
		tx.commit();
	}

	@SuppressWarnings("deprecation")
	@Then("imprime su nombre en pantalla")
	public void imprime_su_nombre_en_pantalla() {
		Assert.assertTrue(clienteDao.contiene(name.getNombre()));
		session.close();
	}

}
