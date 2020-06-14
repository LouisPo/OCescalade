package in.SpringbootOCescalade.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.SpringbootOCescalade.springboot.model.*;

@Repository
public class TopoDAOImpl implements TopoDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Topo> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Topo> query = currentSession.createQuery("from topo", Topo.class);
		List<Topo> list = query.getResultList();
		return list;
	}

	@Override
	public Topo get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Topo topoObj = currentSession.get(Topo.class, id);
		return topoObj;
	}

	@Override
	public void save(Topo topo) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(topo);
	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Topo topoObj = currentSession.get(Topo.class, id);
		currentSession.delete(topoObj);
	}

	@Override
	public void inserttopo(String textarea, Integer user, Integer parcoursidentifiant) {
		// TODO Auto-generated method stub
		
	}



}
