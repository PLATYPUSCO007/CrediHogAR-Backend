package repositorio;

import java.io.Serializable;
import java.util.List;

public interface Repositorio<T> {

		/**
		 * Periste en la base de datos al objeto obj, si existiese un registro en la base de datos con la misma primary key
		 * es decir, que sean iguales, no se guardara o lanzara excepcion
		 * @param obj
		 */
		void guardar(T obj);

		/**
		 * Recupera un nuevo objeto, pero con los atributos de la base de datos que le pertenecian al
		 * objeto que fue persistido
		 * @param nombre
		 * @return un objeto de la clase que implemente la interfaz
		 */
		T recuperar(Serializable key);
		

		/**
		 * Persiste en la base de datos al objeto obj, si existiese un registro en la base de datos con la misma primary key
		 * es decir, que sean iguales, se reemplazara con el nuevo obj
		 * @param obj
		 */
		void actualizar(T obj);

		
		/**
		 * devuelve un boolean si esxiste el objeto con el valor
		 * y celda pasada como parametro
		 * @param String , String
		 */
		
		boolean contiene(Serializable key);
		
		/**
		 * borra de la base de datos el objeto pasado como parmetro
		 * de la base de datos
		 * @param T
		 */
		void borrar(Serializable key);
		
		/**
		 * trae de la base de datos todos los objetos 
		 * persistidos de la tabla correspondiente 
		 * 
		 * 
		 */
		List<T> traerTodo();

		/**
		 * borra de la base de datos todos los objetos 
		 * persistidos de la tabla correspondiente
		 * 
		 */
		void borrarTodo();

		
}

