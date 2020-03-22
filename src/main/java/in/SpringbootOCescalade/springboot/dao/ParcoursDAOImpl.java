package in.SpringbootOCescalade.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.SpringbootOCescalade.springboot.model.*;

@Repository
public class ParcoursDAOImpl implements ParcoursDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Parcours> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Parcours> query = currentSession.createQuery("from Parcours", Parcours.class);
		List<Parcours> list = query.getResultList();
		return list;
	}

	@Override
	public Parcours get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Parcours parcoursObj = currentSession.get(Parcours.class, id);
		return parcoursObj;
	}

	@Override
	public void save(Parcours parcours) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(parcours);
	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Parcours parcoursObj = currentSession.get(Parcours.class, id);
		currentSession.delete(parcoursObj);
	}


	
}
