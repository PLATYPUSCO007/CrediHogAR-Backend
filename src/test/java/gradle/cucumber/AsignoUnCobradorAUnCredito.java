package gradle.cucumber;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modelo.Articulo;
import modelo.Cargo;
import modelo.Cliente;
import modelo.Credito;
import modelo.Empleado;
import modelo.FormaDePago;
import repositorio.ArticuloDao;
import repositorio.CreditoDao;
import repositorio.EmpleadoDao;
import repositorio.Runner;
import repositorio.SessionFactoryProvider;

public class AsignoUnCobradorAUnCredito {
	CreditoDao creditoDao;
	Credito credito;
	Session session;
	Transaction tx;
	Articulo unArticulo;
	ArticuloDao articuloDao;
	EmpleadoDao empleadoDao;
	
	@Given("un pantalla de crear credito")
	public void una_pantalla_de_crear_credito() {
		empleadoDao = new EmpleadoDao();
		creditoDao = new CreditoDao(); 
	    credito = new Credito();
	    SessionFactoryProvider.destroy();

		session = SessionFactoryProvider.getInstance().createSession();
		tx = session.beginTransaction();

		Runner.addSession(session);
		articuloDao = new ArticuloDao();

	    unArticulo = new Articulo();
	    unArticulo.setCodigoArticulo(2348);
	    unArticulo.setNombre("Estufa");
	    unArticulo.setDescripcion("Marca gacyf 120w");
	    unArticulo.setPrecio(2200);
	    unArticulo.setCosto(800);
	    unArticulo.setComision(200);
	    articuloDao.guardar(unArticulo);
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

	@When("le asigno un Cobrador")
	public void asigno_el_articulo_al_credito() {
		Empleado unCobrador = new Empleado();
		unCobrador.setNombre("Adrian");
		unCobrador.setApellido("Romero");
		unCobrador.setCalle("posadas N°2634");
		unCobrador.setDNI(30495873);
		unCobrador.setEntreCalle("Calle 44");
		unCobrador.setTelefono(1135246457);
		unCobrador.setCargo(Cargo.COBRADOR);
		empleadoDao.guardar(unCobrador);
		Empleado empleadoRecuperado = empleadoDao.recuperar("DNI",30495873 );
		credito.setCobrador(empleadoRecuperado);
	}

	@Then("y se guarda en la bd con los datos del credito")
	public void el_credito_se_guarda_en_la_bd_con_todos_sus_datos_correspondientes() {
		creditoDao.guardar(credito);
		tx.commit();
	    
		
		
		Credito creditoRecuperado = creditoDao.traerPorId("A-3947");
		
		assertEquals(creditoRecuperado.getCobrador().getCargo() ,Cargo.COBRADOR);
		assertEquals(creditoRecuperado.getCobrador().getDNI() ,30495873);
		session.close();
	}
}



