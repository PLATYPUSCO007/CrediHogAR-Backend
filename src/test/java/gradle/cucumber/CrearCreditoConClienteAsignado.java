package gradle.cucumber;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import modelo.Cliente;
import modelo.Credito;
import modelo.FormaDePago;
import repositorio.ClienteDao;
import repositorio.CreditoDao;
import repositorio.Runner;
import repositorio.SessionFactoryProvider;

public class CrearCreditoConClienteAsignado {
	
	CreditoDao creditoDao;
	Credito credito;
	Session session;
	Transaction tx;

	@Given("pantalla inicial de un sistema")
	public void pantalla_inicial_de_un_sistema() {
	    creditoDao  = new CreditoDao(); 
	    credito = new Credito();
	    SessionFactoryProvider.destroy();

		session = SessionFactoryProvider.getInstance().createSession();
		tx = session.beginTransaction();

		Runner.addSession(session);
	}

	@When("cargo los datos de un credito")
	public void cargo_los_datos_de_un_credito() {
		credito.setCodigo("A-3947");
		credito.setFechaDeInicio(new Date() );
		credito.setFechaDeVencimiento(new Date());
		credito.setFormaDePago(FormaDePago.SEMANAL );
		credito.setAnticipo(300);
		credito.setCuotas(4);
		credito.setCliente(new Cliente());
		
	}

	@When("asigno un cliente")
	public void asigno_un_cliente() {
		Cliente unCliente = new Cliente();
		unCliente.setNombre("Ruben");
		unCliente.setApellido("Lozano");
		unCliente.setCalle("Calingasta N°2635");
		unCliente.setDNI(33867530);
		unCliente.setEntreCalle("Laprida y Beruti");
		unCliente.setTelefono(42370657);
		credito.setCliente(unCliente);
		
	}

	@When("doy guardar")
	public void doy_guardar() {
		creditoDao.guardar(credito);
		tx.commit();
		
	}

	@Then("el credito se guarda en la base de datos del sistema")
	public void el_credito_se_guarda_en_la_base_de_datos_del_sistema() {
		assertEquals(creditoDao.traerPorId("A-3947").getCodigo(),"A-3947");
	}
	
}
