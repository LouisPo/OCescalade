package in.SpringbootOCescalade.springboot.dao;

import java.util.List;

import in.SpringbootOCescalade.springboot.model.*;

public interface CommentDAO {
	
	List<Comment> get();
	
	Comment get(int id);
	
	void save(Comment commentaire);
	
	void insertcommentaire(String  textarea,Integer user,Integer parcoursidentifiant,String identite,String date);

	void delete(int id);
}
