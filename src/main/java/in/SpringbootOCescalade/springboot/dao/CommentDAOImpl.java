package in.SpringbootOCescalade.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.SpringbootOCescalade.springboot.model.*;

@Repository
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Comment> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Comment> query = currentSession.createQuery("from commentaire", Comment.class);
		List<Comment> list = query.getResultList();
		return list;
	}

	@Override
	public Comment get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Comment commentaireObj = currentSession.get(Comment.class, id);
		return commentaireObj;
	}

	@Override
	public void save(Comment commentaire) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(commentaire);
	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Comment commentaireObj = currentSession.get(Comment.class, id);
		currentSession.delete(commentaireObj);
	}

	@Override
	public void insertcommentaire(String textarea, Integer user,Integer parcoursidentifiant,String identite,String date) {
		// TODO Auto-generated method stub
		
	}

}
