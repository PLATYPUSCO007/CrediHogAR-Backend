package repositorio;

import modelo.Articulo;
import modelo.Cliente;

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

}
