package gradle.cucumber;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import modelo.Articulo;
import repositorio.ArticuloDao;
import repositorio.Runner;
import repositorio.SessionFactoryProvider;

public class BuscarUnArticuloPorNombre {
	
	Session session;
	Transaction tx;
	Articulo articulo;
	ArticuloDao articuloDao;
	Articulo articuloNombre;
	
	@Given("iniciar un sesion")
	public void iniciar_un_sesion() {
		SessionFactoryProvider.destroy();

		session = SessionFactoryProvider.getInstance().createSession();
		tx = session.beginTransaction();

		Runner.addSession(session);
		articuloDao = new ArticuloDao();
	}

	@When("Guardo el articulo")
	public void guardo_el_articulo() {
	    articulo = new Articulo();
	    articulo.setNombre("Iphone");
	    articulo.setCodigoArticulo(9464);
	    articuloDao.guardar(articulo);
	    tx.commit();
	}

	@And("lo busco por su nombre")
	public void lo_busco_por_su_nombre() {
	    articuloNombre = articuloDao.recuperar("nombre", "Iphone");
	}

	@Then("imprime el campo buscado")
	public void imprime_el_campo_buscado() {
	    Assert.assertEquals("Iphone", articuloNombre.getNombre());
	    session.close();
	}



}
