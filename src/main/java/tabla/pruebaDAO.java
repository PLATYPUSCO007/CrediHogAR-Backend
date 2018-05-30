package tabla;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import utils.HibernateUtil;

public class pruebaDAO {

	public pruebaDAO() {
	}

	// Session session = HibernateUtil.getSessionFactory().openSession();


	public void AgregarDatos(prueba prue) {
		Session session = null;
		try {
			session= HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(prue);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
				session.close();
	}

	public int busqueda() {
		Session session1 = null;
		int id_user = 0;
		try {

			session1 = HibernateUtil.getSessionFactory().openSession();
			session1.getTransaction().begin();
			Query query = session1.createQuery("SELECT p.id FROM prueba p");
			List<Integer> dame_id = query.list();
			for (Integer e : dame_id) {
				id_user = e;
			}
		} catch (Exception e) {
		} finally {
			if (session1.isOpen()) {
				session1.getTransaction().commit();
				session1.close();
			}
		}
		return id_user;
	}

	/**
	 * public void save(prueba prue) { session.beginTransaction();
	 * session.save(prue); session.getTransaction().commit(); session.close(); }
	 * 
	 * public void close() { session.close(); }
	 **/

}
