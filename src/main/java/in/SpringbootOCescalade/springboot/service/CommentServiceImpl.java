package in.SpringbootOCescalade.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.SpringbootOCescalade.springboot.dao.*;
import in.SpringbootOCescalade.springboot.model.*;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO CommentDAO;
	
	@Transactional
	@Override
	public List<Comment> get() {
		return CommentDAO.get();
	}

	@Transactional
	@Override
	public Comment get(int id) {
		return CommentDAO.get(id);
	}

	@Transactional
	@Override
	public void save(Comment commentaire) {
		CommentDAO.save(commentaire);
	}

	@Transactional
	@Override
	public void delete(int id) {
		CommentDAO.delete(id);
	}

	@Override
	public void insertcommentaire(String textarea, Integer user,String identite,String date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comment> findcomment(int user, int parcoursidentifiant) {
		// TODO Auto-generated method stub
		return null;
	}

}
