package gradle.cucumber;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modelo.Articulo;
import repositorio.ArticuloDao;
import repositorio.Runner;
import repositorio.SessionFactoryProvider;


public class EditarUnArticulo {
	
	Session session;
	Transaction tx;
	Articulo articulo;
	ArticuloDao articuloDao;

	@Given("iniciar a sesion")
	public void iniciar_a_sesion() {
		SessionFactoryProvider.destroy();

		session = SessionFactoryProvider.getInstance().createSession();
		tx = session.beginTransaction();

		Runner.addSession(session);
		articuloDao = new ArticuloDao();
	}

	@When("Guardo un articulo")
	public void guardo_un_articulo() {
		articulo = new Articulo();
		articulo.setCodigoArticulo(5677);
		articulo.setCosto(46747);
		articulo.setDescripcion("32 Pulgadas");
		articulo.setNombre("TV");
		articulo.setPrecio(23424);
		articuloDao.guardar(articulo);
	}

	@And("lo edito")
	public void lo_edito() {
		articulo.setNombre("Heladera");
		articulo.setCosto(98989);
		articulo.setCodigoArticulo(5677);
		articuloDao.actualizar(articulo);
		tx.commit();
	}

	@Then("imprime el nuevo campo editado")
	public void imprime_el_nuevo_campo_editado() {
		Assert.assertTrue(articuloDao.contiene("nombre", "Heladera"));
		session.close();
	}

}
