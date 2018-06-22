package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Credito implements Serializable  {
	@Id
	String codigo;
	@Column
	Date fechaDeInicio;
	@Column
	Date fechaDeVencimiento;
	@Column
	int anticipo;
	@Column
	FormaDePago formaDePago;
	@Column
	int cuotas;
	@ManyToOne
	Cliente cliente;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Date getFechaDeInicio() {
		return fechaDeInicio;
	}
	public void setFechaDeInicio(Date fechaDeIngreso) {
		this.fechaDeInicio = fechaDeIngreso;
	}
	public Date getFechaDeVencimiento() {
		return fechaDeVencimiento;
	}
	public void setFechaDeVencimiento(Date fechaDeVencimiento) {
		this.fechaDeVencimiento = fechaDeVencimiento;
	}
	public int getAnticipo() {
		return anticipo;
	}
	public void setAnticipo(int anticipo) {
		this.anticipo = anticipo;
	}
	public FormaDePago getFormaDePago() {
		return formaDePago;
	}
	public void setFormaDePago(FormaDePago formaDePago) {
		this.formaDePago = formaDePago;
	}
	public int getCuotas() {
		return cuotas;
	}
	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

}
