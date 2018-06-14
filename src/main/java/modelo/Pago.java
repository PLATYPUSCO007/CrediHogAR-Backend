package modelo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pago implements Serializable {

	@Id
	@GeneratedValue
	public int id;
	@Temporal(TemporalType.DATE)
	public Date fecha;
	@Column
	public int monto;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		this.fecha = sdf.parse(fecha);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

}
