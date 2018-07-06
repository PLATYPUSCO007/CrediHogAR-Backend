package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;

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
	@ManyToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
	Cliente cliente;
	@Column
	EstadoDeCredito estado;
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL,  mappedBy="credito", orphanRemoval = true)

	List<Pago> pagos = new ArrayList<Pago>();
	
	//@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	  @ManyToMany
      @JoinTable(name = "credito_articulo",
      joinColumns = {@JoinColumn(name = "credito_codigo")},
      inverseJoinColumns = {@JoinColumn(name = "articulos_id")})
	List<Articulo> articulos = new ArrayList<Articulo>();	
	

	public Credito(){
		estado = EstadoDeCredito.VIGENTE;
	}
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
	public EstadoDeCredito getEstado() {
		return estado;
	}
	public void setEstado(EstadoDeCredito estado) {
		this.estado = estado;
	}
	
	public List<Pago> getunpago() {
		return pagos;
	}
	
	public void setunpago(List<Pago> unPago) {
		this.pagos = unPago;
	}
	
	public void addunpago(Pago pago) {
		this.pagos.add(pago);
		pago.setcredito(this);
	}
	
	public void removepago(Pago pago) {
		this.pagos.remove(pago);
		pago.setcredito(null);
	}
	public void AgregarUnArticulo(Articulo unArticulo) {
		this.articulos.add(unArticulo);	
	}
	public List<Articulo> getArticulos() {
		return articulos;
	}
	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}
	
	
}
