package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente  implements Serializable {
	@Id
	@GeneratedValue
	public int id; 
	@Column
	public String nombre;
	@Column
	public String direccion;
	@Column
	public int telefono;
	@Column 
	public int DNI;
	
	
	public int getDNI() {
		return DNI;
	}
	
	public void setDNI(int DNI) {
		this.DNI=DNI;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getId() {
		return id;
	}
		
}
