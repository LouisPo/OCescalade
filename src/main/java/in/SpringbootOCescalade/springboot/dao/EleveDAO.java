package in.SpringbootOCescalade.springboot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import in.SpringbootOCescalade.springboot.dao.SdzConnection;
import in.SpringbootOCescalade.springboot.model.Comment;
import in.SpringbootOCescalade.springboot.model.Employee;
import in.SpringbootOCescalade.springboot.model.Parcourss;

public class EleveDAO extends DAO<Eleve> {
public EleveDAO(Connection conn) {
  super(conn);
}

public boolean create(Eleve obj) {
  return false;
}

public boolean delete(Eleve obj) {
  return false;
}
 
public boolean update(Eleve obj) {
  return false;
}
 
public Eleve find(int id) {
  Eleve eleve = new Eleve();      
    
  try {
    ResultSet result = this.connect.createStatement(
      ResultSet.TYPE_SCROLL_INSENSITIVE,
      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM eleve WHERE elv_id = " + id);
    if(result.first())
       eleve = new Eleve(id,result.getString("elv_nom"), result.getString("elv_prenom"));        
  } catch (SQLException e) {
    e.printStackTrace();
  }
  return eleve;
}
 

public Eleve findmultiple(int id,String nom,String localisation) {
	  Eleve eleve = new Eleve();      

	  return eleve;
	}
public List<Parcourss> findmultipleNoid(String nom,String localisation,int taille,int difficulte) {
	List<Parcourss> ret=new ArrayList();
	Parcourss parcourscourant= null;
	ResultSet result = null;  
	try {
		     result = this.connect.createStatement(
		      ResultSet.TYPE_SCROLL_INSENSITIVE,
		      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM parcours WHERE nom = '"+nom+"' and localisation = '"+localisation+"'");


			} catch (SQLException e) {
					    e.printStackTrace();
			}
		  return ret;
	}

@Override
public List<Employee> findconnexion(String nom, String localisation) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void save(String textarea, int user) {
	// TODO Auto-generated method stub
	
}

@Override
public List<Comment> findcomment(int user, int parcoursidentifiant) {
	// TODO Auto-generated method stub
	return null;
}
}