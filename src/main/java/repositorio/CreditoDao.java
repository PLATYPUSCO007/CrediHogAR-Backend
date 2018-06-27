package repositorio;

import modelo.Credito;

public class CreditoDao extends RepositorioHibernate<Credito>{
	
	public CreditoDao() {
		super(Credito.class);
	}

	public Credito traerPorId(String codigo) {
		return super.recuperar("codigo", codigo);
	}
	
	

}
