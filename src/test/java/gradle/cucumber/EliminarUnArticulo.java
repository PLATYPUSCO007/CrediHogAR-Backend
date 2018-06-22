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

public class EliminarUnArticulo {
	
	Session session;
	Transaction tx;
	Articulo articulo;
	Articulo articulo2;
	ArticuloDao articuloDao;
	
	@Given("iniciar unn sesion")
	public void iniciar_unn_sesion() {
		SessionFactoryProvider.destroy();

		session = SessionFactoryProvider.getInstance().createSession();
		tx = session.beginTransaction();

		Runner.addSession(session);
		articuloDao = new ArticuloDao();
	}

	@When("Guardo ell articulo")
	public void guardo_ell_articulo() {
		articulo = new Articulo();
		articulo.setNombre("Estufa");
		articulo.setCodigoArticulo(5678);
		articulo.setDescripcion("De 4 puestos");
		articuloDao.guardar(articulo);
		
		articulo2 = new Articulo();
		articulo2.setNombre("Equipo");
		articulo2.setCodigoArticulo(6757);
		articulo2.setDescripcion("40Mhz");
		articuloDao.guardar(articulo2);
	}

	@And("lo elimino del registro")
	public void lo_elimino_del_registro() {
	    articuloDao.borrar("codigoArticulo", 5678);
	    tx.commit();
	}

	@Then("verifico su eliminacion")
	public void verifico_su_eliminacion() {
	    Assert.assertFalse(articuloDao.contiene("codigoArticulo", 5678));
	    session.close();
	}


}
