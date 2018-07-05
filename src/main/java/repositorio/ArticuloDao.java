package repositorio;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import modelo.Articulo;
import modelo.Cliente;
import modelo.Pago;

public class ArticuloDao extends RepositorioHibernate<Articulo> {

	public ArticuloDao() {
		super(Articulo.class);

	}
	
	Articulo articulo = new Articulo();
	
	public Articulo buscarNombre(String nombre) {
		try {
			articulo = this.recuperar("nombre", nombre);
		} catch (Exception e) {
		}
		return articulo;
	}
	
	public Articulo buscarCodigo(int codigo) {
		try {
			articulo = this.recuperar("codigoArticulo", codigo);
		} catch (Exception e) {
		}
		return articulo;
	}
	public List<Articulo> buscarNombreSimilares(String nombre) {
		String nombreBuscado = "%" + nombre + "%";
		Session session = Runner.getCurrentSession();
		String hql = "FROM Articulo a WHERE a.nombre LIKE '" + nombreBuscado + "' ";
		Query query = session.createQuery(hql);
		List<Articulo> articulos = (List<Articulo>) query.getResultList();
		return articulos;
	}
}
