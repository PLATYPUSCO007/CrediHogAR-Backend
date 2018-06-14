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

public class EliminarUnCliente {
	
	Session session;
	Transaction tx;
	ClienteDao clienteDao;
	Cliente cliente;
	Cliente cliente2;

	@Given("en inicio del sistema")
	public void en_inicio_del_sistema() {
	    SessionFactoryProvider.destroy();
	    
	    session = SessionFactoryProvider.getInstance().createSession();
	    tx = session.beginTransaction();
	    
	    Runner.addSession(session);
	    clienteDao = new ClienteDao();
	}

	@When("guardo un usuario")
	public void guardo_un_usuario() {
		cliente = new Cliente();
	    cliente.setNombre("Rodrigo");
	    cliente.setCalle("Av Caseros 343");
	    cliente.setEntreCalle("Hipolito");
	    cliente.setTelefono(998322);
	    cliente.setDNI(113388);
	    clienteDao.guardar(cliente);
	    
	    cliente2 = new Cliente();
	    cliente2.setNombre("Rodrigos");
	    cliente2.setCalle("Av Caseros 355");
	    cliente2.setEntreCalle("Bernal");
	    cliente2.setTelefono(94464);
	    cliente2.setDNI(234234);
	    clienteDao.guardar(cliente2);
	}

	@And("lo elimino")
	public void lo_elimino() {
	    clienteDao.borrar("calle", "Av Caseros 343");
	    tx.commit();
	}

	@Then("se borra su registro")
	public void se_borra_su_registro() {
		Cliente clienteBorrado = clienteDao.buscarDni(113388);
	    Assert.assertNotEquals(113388, clienteBorrado.getDNI());
	    session.close();
	}
}
