package gradle.cucumber;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Credito;
import modelo.FormaDePago;
import repositorio.ArticuloDao;
import repositorio.CreditoDao;
import repositorio.Runner;
import repositorio.SessionFactoryProvider;

public class AsignoUnArticuloAUnCredito {
	
	CreditoDao creditoDao;
	Credito credito;
	Session session;
	Transaction tx;
	Articulo unArticulo;
	ArticuloDao articuloDao;
	
	@Given("una pantalla de crear credito")
	public void una_pantalla_de_crear_credito() {
		creditoDao = new CreditoDao(); 
	    credito = new Credito();
	    SessionFactoryProvider.destroy();

		session = SessionFactoryProvider.getInstance().createSession();
		tx = session.beginTransaction();

		Runner.addSession(session);
		articuloDao = new ArticuloDao();
	}

	@Given("un articulo")
	public void un_articulo() {
	    unArticulo = new Articulo();
	    unArticulo.setCodigoArticulo(2348);
	    unArticulo.setNombre("Estufa");
	    unArticulo.setDescripcion("Marca gacyf 120w");
	    unArticulo.setPrecio(2200);
	    unArticulo.setCosto(800);
	    unArticulo.setComision(200);
	    articuloDao.guardar(unArticulo);
	    
	    
	    
	}

	@When("asigno el articulo al credito")
	public void asigno_el_articulo_al_credito() {
		credito.setCodigo("A-3947");
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
		credito.AgregarUnArticulo(unArticulo);
		
	}

	@When("guardo el credito")
	public void guardo_el_credito() {
		creditoDao.guardar(credito);
		tx.commit();
	}

	@Then("el credito se guarda en la bd con todos sus datos correspondientes")
	public void el_credito_se_guarda_en_la_bd_con_todos_sus_datos_correspondientes() {
		Credito creditoRecuperado = creditoDao.traerPorId("A-3947");
		Articulo articuloRecuperado = creditoRecuperado.getArticulos().get(0);
		assertEquals((int) articuloRecuperado.getCodigoArticulo() , 2348);
		session.close();
	}

}
