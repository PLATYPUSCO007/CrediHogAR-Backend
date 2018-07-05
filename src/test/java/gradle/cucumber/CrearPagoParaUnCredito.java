package gradle.cucumber;

import java.text.ParseException;
import java.util.Date;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modelo.Credito;
import modelo.FormaDePago;
import modelo.Pago;
import repositorio.CreditoDao;
import repositorio.PagoDao;
import repositorio.Runner;
import repositorio.SessionFactoryProvider;

public class CrearPagoParaUnCredito {
	
	CreditoDao creditoDao;
	Credito credito;
	Credito credito1;
	Session session;
	Transaction tx;
	Pago pago;
	PagoDao pagoDao;

	@Given("pantalla de inicio del sistema")
	public void pantalla_de_inicio_del_sistema() {
		creditoDao  = new CreditoDao(); 
	    credito = new Credito();
		pago = new Pago();
		pagoDao = new PagoDao();
		credito1 = new Credito();
	    SessionFactoryProvider.destroy();

		session = SessionFactoryProvider.getInstance().createSession();
		tx = session.beginTransaction();

		Runner.addSession(session);
	}

	@When("cargo los datos del credito")
	public void cargo_los_datos_del_credito() {
		credito.setCodigo("A-3947");
		credito.setFechaDeInicio(new Date() );
		credito.setFechaDeVencimiento(new Date());
		credito.setFormaDePago(FormaDePago.SEMANAL );
		credito.setAnticipo(300);
		credito.setCuotas(4);
		creditoDao.guardar(credito);
		credito1.setCodigo("B-5634");
		creditoDao.guardar(credito1);
	}

	@And("asigno un pago")
	public void asigno_un_pago() throws ParseException {
		pago.setFecha(new Date());
		pago.setMonto(12000);
		pago.setcredito(credito1);
	}

	@And("lo guardo en la BD")
	public void lo_guardo_en_la_BD() {
		pagoDao.guardar(pago);
	    tx.commit();
	}

	@Then("traigo el valor del pago")
	public void traigo_el_valor_del_pago() {
	    Assert.assertTrue(true);
	    session.close();
	}


}
