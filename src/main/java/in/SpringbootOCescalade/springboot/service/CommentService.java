package in.SpringbootOCescalade.springboot.service;

import java.util.List;

import in.SpringbootOCescalade.springboot.model.*;

public interface CommentService {
	List<Comment> get();
	
	Comment get(int id);
	
	void save(Comment commentaire);
	void insertcommentaire(String  textarea,Integer user);
	void delete(int id);
	List<Comment> findcomment(int user,int parcoursidentifiant);
}
