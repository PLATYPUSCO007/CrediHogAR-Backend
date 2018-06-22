package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente implements Serializable {
	@Id
	@GeneratedValue
	public int id;
	@Column
	public String nombre;
	@Column
	public String apellido;
	@Column
	public String calle;
	@Column
	public String entrecalle;
	@Column
	public int telefono;
	@Column(unique = true)
	public int DNI;
	@Column
	public String calificacion;
	
	
	public enum CalificacionUsuario {
		APTO("Apto"),
		NO_APTO("No Apto");
		
		private CalificacionUsuario(String calificacion) {
			this.calificacion= calificacion;
		}
		
		private String getCalificacion() {
			return calificacion;
		}
		
		private String calificacion;
	};
	
	public void setCalificacion(String calificacion) {
		CalificacionUsuario calificacionuser = Enum.valueOf(CalificacionUsuario.class, calificacion);
		this.calificacion=calificacionuser.getCalificacion();
	}
	
	public String getCalificacion() {
		return calificacion;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int DNI) {
		this.DNI = DNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido=apellido;
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
