package gradle.cucumber;


import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tabla.prueba;
import tabla.pruebaDAO;

public class jj {
	
	pruebaDAO db = new pruebaDAO();
	
	@Given("un inicio del sistema")
	public void un_inicio_del_sistema() {
	    pruebaDAO db = new pruebaDAO();
	}

	@When("cargo un usuario al sistema")
	public void cargo_un_usuario_al_sistema() {
	    prueba user = new prueba(1234, "Lapru basidio", 5678);
	    db.AgregarDatos(user);
	}

	@Then("deberia traer su ID")
	public void deberia_traer_su_ID() {
	    Assert.assertEquals(1234,db.busqueda());
	}

}
 	