package repositorio;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class RepositorioHibernate<T> implements Repositorio<T> {

	private Class<T> tipo;

	public RepositorioHibernate(Class<T> tipo) {
		this.tipo = tipo;
	}

	@Override
	public void guardar(T obj) {
		Runner.runInSession(() -> {
			Session session = Runner.getCurrentSession();
			session.save(obj);
			return null;
		});
	}

	@Override
	public T recuperar(Serializable key) {
		Session session = Runner.getCurrentSession();
		T resultado = (T) session.get(tipo, key);
		return (T) resultado;
	}

	@Override
	public void actualizar(T obj) {
		Session session = Runner.getCurrentSession();
		session.update(obj);
	}

	@Override
	public boolean contiene(Serializable key) {
		boolean res = false;
		//String[] campos = new String[5];
		//campos[0] = "nombre";
		//campos[1] = "DNI";
		//campos[2] = "telefono";
		//campos[3] = "direccion";
		//campos[4] = "id";
		try {
			//for (int i = 0; i < campos.length; i++) {
				//if (res == false) {
					res = (null != this.recuperar("nombre", key));
				//}
			//}
		} catch (Exception e) {

			System.out.println("el entrenador no existe");

		}
		return res;
	}

	@Override
	public void borrar(Serializable key) {
		Session session = Runner.getCurrentSession();
		session.delete(this.recuperar(key));
	}

	@Override
	public List<T> traerTodo() {
		Session session = Runner.getCurrentSession();
		Query<T> query = session.createQuery("from " + tipo.getSimpleName() + " t ", tipo);
		return query.getResultList();
	}

	@Override
	public void borrarTodo() {
		Session session = Runner.getCurrentSession();
		session.createQuery("delete from " + tipo.getSimpleName()).executeUpdate();

	}

	public T recuperar(String campo, Serializable valor) {
		Session session = Runner.getCurrentSession();
		String hql = "from " + tipo.getSimpleName() + " t " + "where t." + campo + " = :valor ";
		Query<T> query = session.createQuery(hql, tipo);
		query.setParameter("valor", valor);
		query.setMaxResults(1);
		return (T) query.getSingleResult();

	}

}
