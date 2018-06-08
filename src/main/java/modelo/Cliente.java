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
	public String calle;
	@Column
	public String entrecalle;
	@Column
	public int telefono;
	@Column (unique=true)
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
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getEntreCalle() {
		return entrecalle;
	}
	public void setEntreCalle(String entrecalle) {
		this.entrecalle = entrecalle;
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
