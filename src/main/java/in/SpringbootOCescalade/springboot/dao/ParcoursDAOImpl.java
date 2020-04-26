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
	public List<Parcourss> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Parcourss> query = currentSession.createQuery("from Parcourss", Parcourss.class);
		List<Parcourss> list = query.getResultList();
		return list;
	}

	@Override
	public Parcourss get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Parcourss parcoursObj = currentSession.get(Parcourss.class, id);
		return parcoursObj;
	}

	@Override
	public void save(Parcourss parcours) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(parcours);
	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Parcourss parcoursObj = currentSession.get(Parcourss.class, id);
		currentSession.delete(parcoursObj);
	}


	
}
