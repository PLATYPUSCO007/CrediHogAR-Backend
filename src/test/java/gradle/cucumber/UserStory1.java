package gradle.cucumber;

import java.util.List;

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

public class UserStory1 {
	
	ClienteDao clienteDao; 
	Cliente cliente; 
	Session session;
	Transaction tx;
	
	@Given("un inicio de sesion")
	public void un_inicio_de_sesion() {
		SessionFactoryProvider.destroy();
		
		session = SessionFactoryProvider.getInstance().createSession();
		tx = session.beginTransaction();
		
		Runner.addSession(session);
		clienteDao = new ClienteDao();
	}

	@When("creo un cliente con sus datos personales")
	public void creo_un_cliente_con_sus_datos_personales() {
		cliente = new Cliente();
		cliente.setNombre("Zoila Perez");
		cliente.setDireccion("Hyrigoyen 345");
		cliente.setTelefono(2323);
		cliente.setDNI(98723489);
		clienteDao.guardar(cliente);
		
		tx.commit();
	}

	@Then("valido su creacion")
	public void valido_su_creacion() {
		List<Cliente> cli = clienteDao.traerTodo(); 
		Assert.assertNotEquals(null, cli);
	}

}
