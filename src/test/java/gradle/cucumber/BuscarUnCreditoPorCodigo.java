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
import modelo.FormaDePago;
import repositorio.CreditoDao;
import repositorio.Runner;
import repositorio.SessionFactoryProvider;

public class BuscarUnCreditoPorCodigo {
	
	CreditoDao creditoDao;
	Credito credito;
	Session session;
	Transaction tx;
	Credito creditoRecuperado;
	
	@Given("una Ventana inicial y un credito guardo en la bd")
	public void una_Ventana_inicial_y_un_credito_guardo_en_la_bd() {
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
		tx.commit();
	}

	@When("busco el credito por codigo")
	public void busco_el_credito_por_codigo() {
		creditoRecuperado = creditoDao.traerPorId("A-3947");
	}

	@Then("me devuelve todos losdatos del credito")
	public void me_devuelve_todos_losdatos_del_credito() {
		assertEquals(creditoRecuperado.getCodigo(),"A-3947");
		session.close();
	}


}
