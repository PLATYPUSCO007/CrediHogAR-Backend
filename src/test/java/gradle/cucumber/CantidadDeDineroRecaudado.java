package gradle.cucumber;


import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modelo.Credito;
import modelo.Pago;

import org.junit.Assert;

import repositorio.CreditoDao;
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
	CreditoDao creditoDao;

	@Given("inicio del sistema")
	public void inicio_del_sistema() {
		creditoDao = new CreditoDao();
		SessionFactoryProvider.destroy();

		session = SessionFactoryProvider.getInstance().createSession();
		tx = session.beginTransaction();

		Runner.addSession(session);
		pagoDao = new PagoDao();
	}

	@When("consulto el dinero recaudado en un mes")
	public void consulto_el_dinero_recaudado_en_un_mes() throws ParseException {
		Credito credito = new Credito();
		credito.setCodigo("C-1234");
		creditoDao.guardar(credito);
		pago = new Pago();
		pago.setFecha(new Date());
		pago.setMonto(120);
		pago.setcredito(credito);
		pagoDao.guardar(pago);

		pago1 = new Pago();
		pago1.setFecha(new Date());
		pago1.setMonto(200);
		pago1.setcredito(credito);
		pagoDao.guardar(pago1);
		
		pago2 = new Pago();
		pago2.setFecha(new Date());
		pago2.setMonto(200);
		pago2.setcredito(credito);
		pagoDao.guardar(pago2);
		tx.commit();
		
		recaudo = pagoDao.consultarRecaudoMensual("2017-10-01", "2018-12-12");
	}

	@Then("obtengo la cantidad de dinero recaudado")
	public void obtengo_la_cantidad_de_dinero_recaudado() throws ParseException {
		Assert.assertEquals(520, recaudo);
		session.close();
	}

}
