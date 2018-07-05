package repositorio;

import java.util.List;

import modelo.Credito;
import modelo.Pago;

public class CreditoDao extends RepositorioHibernate<Credito>{
	
	public CreditoDao() {
		super(Credito.class);
	}

	public Credito traerPorId(String codigo) {
		return super.recuperar("codigo", codigo);
	}

}
