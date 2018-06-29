package gradle.cucumber;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modelo.Cliente;
import modelo.Credito;
import modelo.FormaDePago;
import modelo.Pago;
import repositorio.CreditoDao;
import repositorio.Runner;
import repositorio.SessionFactoryProvider;

public class BuscarPagosDeUnCredito {
	
	CreditoDao creditoDao;
	Credito credito;
	Session session;
	Transaction tx;
	Pago pago;
	Pago pago1;
	List<Pago> pagosCredito;
	
	@Given("pantalla de inicio")
	public void pantalla_de_inicio() {
		creditoDao  = new CreditoDao(); 
	    credito = new Credito();
		pago = new Pago();
		pago1 = new Pago();
		
	    SessionFactoryProvider.destroy();

		session = SessionFactoryProvider.getInstance().createSession();
		tx = session.beginTransaction();

		Runner.addSession(session);
	}

	@When("cargo datos de un credito")
	public void cargo_datos_de_un_credito() {
		credito.setCodigo("A-3944");
		credito.setFechaDeInicio(new Date() );
		credito.setFechaDeVencimiento(new Date());
		credito.setFormaDePago(FormaDePago.SEMANAL );
		credito.setAnticipo(300);
		credito.setCuotas(4);
		Cliente unCliente = new Cliente();
		unCliente.setNombre("Ruben");
		unCliente.setApellido("Lozano");
		unCliente.setCalle("Calingasta N°2635");
		unCliente.setDNI(33867530);
		unCliente.setEntreCalle("Laprida y Beruti");
		unCliente.setTelefono(42370657);
		credito.setCliente(unCliente);
	}

	@And("asigno varios pagos")
	public void asigno_varios_pagos() throws ParseException {
		pago.setFecha("10/10/1995");
		pago.setMonto(12000);
		credito.addunpago(pago);
		
		pago1.setFecha("05/05/2018");
		pago1.setMonto(10000);
		credito.addunpago(pago1);
	}

	@And("los almaceno en la BD")
	public void los_almaceno_en_la_BD() {
		creditoDao.guardar(credito);
	    tx.commit();
	}
	
	@And("Busco los pagos asignados segun el codigo del credito")
	public void busco_los_pagos_asignados_segun_el_codigo_del_credito() {
	    pagosCredito = creditoDao.buscarPagos("A-3944");
	}

	@Then("traigo los pagos")
	public void traigo_los_Id_de_los_pagos() {
	    Assert.assertArrayEquals(credito.getunpago().toArray(), pagosCredito.toArray());
	    session.close();
	}

}
