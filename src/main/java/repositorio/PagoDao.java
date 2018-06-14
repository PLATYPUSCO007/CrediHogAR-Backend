package repositorio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Pago;

public class PagoDao extends RepositorioHibernate<Pago> {

	public PagoDao() {
		super(Pago.class);
	}
	


	public long consultarRecaudoMensual(String fecha1, String fecha2) {
		long resultado = 0;
		try {
			
			resultado = this.recaudoMensual(fecha1, fecha2);

		} catch (Exception e) {
		}
		
		return resultado;
	}

}
