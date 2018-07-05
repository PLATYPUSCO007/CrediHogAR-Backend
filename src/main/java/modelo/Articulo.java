package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Articulo implements Serializable {

	@Id
	@GeneratedValue
	public int id;
	@Column(unique = true)
	public Integer codigoArticulo;
	@Column
	public String nombre;
	@Column
	public String descripcion;
	@Column
	public Integer costo;
	@Column
	public Integer precio;
	@Column
	public Integer Comision;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="credito_articulo")
//	Credito credito;
//	
//	
//	public Credito getCredito() {
//		return credito;
//	}
//
//	public void setCredito(Credito credito) {
//		this.credito = credito;
//	}

	public Integer getComision() {
		return Comision;
	}

	public void setComision(Integer comision) {
		Comision = comision;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(Integer codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

}
