package modelo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pago implements Serializable {

	@Id
	@GeneratedValue
	public int id;
	@Column
	public Date fecha;
	@Column
	public int monto;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="credito_codigo")
	Credito credito;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha=fecha;
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
	
	public void setcredito(Credito credito) {
		this.credito=credito;
	}
	
	public Credito getcredito() {
		return credito;
	}
	
	
	

}
