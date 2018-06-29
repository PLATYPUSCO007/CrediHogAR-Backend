package gradle.cucumber;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modelo.Cliente;
import modelo.Credito;
import modelo.EstadoDeCredito;
import modelo.FormaDePago;
import repositorio.CreditoDao;
import repositorio.Runner;
import repositorio.SessionFactoryProvider;

public class AsignarEstadoAUnCredito {
	
	CreditoDao creditoDao;
	Credito credito;
	Session session;
	Transaction tx;
	Credito creditoRecuperado;
	
	@Given("un credito Existente")
	public void un_credito_Existente() {
		creditoDao  = new CreditoDao(); 
	    credito = new Credito();
	    SessionFactoryProvider.destroy();

		session = SessionFactoryProvider.getInstance().createSession();
		tx = session.beginTransaction();

		Runner.addSession(session);
		
		credito.setCodigo("A-3947");
		credito.setFechaDeInicio(new Date() );
		credito.setFechaDeVencimiento(new Date());
		credito.setFormaDePago(FormaDePago.SEMANAL );
		credito.setAnticipo(300);
		credito.setCuotas(4);
		credito.setCliente(new Cliente());
		
		Cliente unCliente = new Cliente();
		unCliente.setNombre("Ruben");
		unCliente.setApellido("Lozano");
		unCliente.setCalle("Calingasta N°2635");
		unCliente.setDNI(33867530);
		unCliente.setEntreCalle("Laprida y Beruti");
		unCliente.setTelefono(42370657);
		credito.setCliente(unCliente);
		creditoDao.guardar(credito);
		
		//tx.commit();
		creditoRecuperado = creditoDao.traerPorId("A-3947");
	}

	@When("le asigno un estado")
	public void le_asigno_un_estado() {
		
		creditoRecuperado.setEstado(EstadoDeCredito.PAGO);
		creditoDao.actualizar(creditoRecuperado);
	//	tx.commit();
	}

	@Then("el estado se guarda en la bd con el credito")
	public void el_estado_se_guarda_en_la_bd_con_el_credito() {
		assertEquals(creditoDao.traerPorId("A-3947").getEstado().name(), EstadoDeCredito.PAGO.name());
		tx.commit();
		session.close();
	}

}
