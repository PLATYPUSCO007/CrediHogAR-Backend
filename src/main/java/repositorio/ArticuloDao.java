package repositorio;

import modelo.Articulo;

public class ArticuloDao extends RepositorioHibernate<Articulo> {

	public ArticuloDao() {
		super(Articulo.class);

	}

}
