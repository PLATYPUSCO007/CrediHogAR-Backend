package gradle.cucumber;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modelo.Pago;

import org.junit.Assert;
import repositorio.PagoDao;
import repositorio.Runner;
import repositorio.SessionFactoryProvider;

public class CantidadDeDineroRecaudado {

	Session session;
	Transaction tx;
	Pago pago;
	Pago pago1;
	Pago pago2;
	PagoDao pagoDao;
	long recaudo;

	@Given("inicio del sistema")
	public void inicio_del_sistema() {
		SessionFactoryProvider.destroy();

		session = SessionFactoryProvider.getInstance().createSession();
		tx = session.beginTransaction();

		Runner.addSession(session);
		pagoDao = new PagoDao();
	}

	@When("consulto el dinero recaudado en un mes")
	public void consulto_el_dinero_recaudado_en_un_mes() throws ParseException {
		pago = new Pago();
		pago.setFecha("01/02/2018");
		pago.setMonto(120);
		pagoDao.guardar(pago);

		pago1 = new Pago();
		pago1.setFecha("31/10/2017");
		pago1.setMonto(200);
		pagoDao.guardar(pago1);
		
		pago2 = new Pago();
		pago2.setFecha("31/10/2019");
		pago2.setMonto(200);
		pagoDao.guardar(pago2);
		tx.commit();
		
		recaudo = pagoDao.consultarRecaudoMensual("2017-10-01", "2018-12-12");
	}

	@Then("obtengo la cantidad de dinero recaudado")
	public void obtengo_la_cantidad_de_dinero_recaudado() throws ParseException {
		Assert.assertEquals(320, recaudo);
		session.close();
	}

}
