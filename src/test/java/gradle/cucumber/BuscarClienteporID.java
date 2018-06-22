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

public class BuscarClienteporID {
	
	Cliente cliente;
	Cliente cliente2;
	ClienteDao clienteDao;
	Transaction tx;
	Session session;
	Cliente buscarID;
	
	@Given("iniciar una sesion")
	public void iniciar_una_sesion() {
		SessionFactoryProvider.destroy();

		session = SessionFactoryProvider.getInstance().createSession();
		tx = session.beginTransaction();

		Runner.addSession(session);
		clienteDao = new ClienteDao();
	}

	@When("busco un cliente por su ID")
	public void busco_un_cliente_por_su_ID() {
		cliente = new Cliente();
		cliente.setNombre("Carlos");
		cliente.setApellido("Perez");
		cliente.setCalle("Palta 344");
		cliente.setEntreCalle("chirimuyo");
		cliente.setTelefono(12312);
		cliente.setDNI(123);
		clienteDao.guardar(cliente);
		
		cliente2 = new Cliente();
		cliente2.setNombre("Sofia");
		cliente2.setApellido("Lopez");
		cliente2.setCalle("Semedo 987");
		cliente2.setEntreCalle("Ponsio");
		cliente2.setTelefono(9543);
		cliente2.setDNI(46457);
		clienteDao.guardar(cliente2);
	    tx.commit();
	    
	    buscarID = clienteDao.buscarID(1);
	}

	@Then("imprime el ID en pantalla")
	public void imprime_el_ID_en_pantalla() {
	    Assert.assertEquals(cliente.getId(), buscarID.getId());
	}


}
