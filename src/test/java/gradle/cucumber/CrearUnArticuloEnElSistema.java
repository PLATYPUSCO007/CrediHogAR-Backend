package gradle.cucumber;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modelo.Articulo;
import repositorio.ArticuloDao;
import repositorio.Runner;
import repositorio.SessionFactoryProvider;
import org.junit.Assert;

public class CrearUnArticuloEnElSistema {

	Session session;
	Transaction tx;
	Articulo unArticulo;
	ArticuloDao articuloDao;

	@Given("un sistema iniciado")
	public void un_sistema_iniciado() {
		SessionFactoryProvider.destroy();

		session = SessionFactoryProvider.getInstance().createSession();
		tx = session.beginTransaction();

		Runner.addSession(session);
		articuloDao = new ArticuloDao();
	}

	@When("Creo un articulo con nombre y detalle y lo guardo")
	public void creo_un_articulo_con_nombre_y_detalle() {
		unArticulo = new Articulo();
		unArticulo.setNombre("Heladera");
		unArticulo.setDescripcion("Nofrost Marca Acmne");
		unArticulo.setPrecio(17000);
		unArticulo.setCosto(10000);
		unArticulo.setCodigoArticulo(3457);
		articuloDao.guardar(unArticulo);
	}

	@Then("queda registrado en el sistema")
	public void quedaRegistradoEnElSistema() {
		Assert.assertTrue(articuloDao.contiene("codigoArticulo", 3457));
		session.close();
	}

}
