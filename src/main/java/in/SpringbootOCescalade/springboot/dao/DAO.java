package in.SpringbootOCescalade.springboot.dao;

import java.sql.Connection;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import in.SpringbootOCescalade.springboot.dao.SdzConnection;
import in.SpringbootOCescalade.springboot.model.Employee;
import in.SpringbootOCescalade.springboot.model.Comment;
import in.SpringbootOCescalade.springboot.model.CommentDatabase;
import in.SpringbootOCescalade.springboot.model.Parcourss;

public abstract class DAO<T> {
  protected Connection connect = null;
   
  public DAO(Connection conn){
    this.connect = conn;
  }
   
  /**
  * Méthode de création
  * @param obj
  * @return boolean 
  */
  public abstract boolean create(T obj);

  /**
  * Méthode pour effacer
  * @param obj
  * @return boolean 
  */
  public abstract boolean delete(T obj);

  /**
  * Méthode de mise à jour
  * @param obj
  * @return boolean
  */
  public abstract boolean update(T obj);

  /**
  * Méthode de recherche des informations
  * @param id
  * @return T
  */
  public abstract T find(int id);
  
 
  /**
  * Méthode de recherche des informations
  * @param id
  * @return T
  */
  public abstract T findmultiple(int id,String nom,String localisation);


/**
* Méthode de recherche des informations
* @param id
* @return T
*/
public abstract List<Parcourss> findmultipleNoid(String nom,String localisation,int taille,int difficulte);

public abstract void save(String textarea,int user);
/**
* Méthode de recherche des informations
* @param id
* @return T
*/
public abstract List<Employee> findconnexion(String nom,String localisation);

public void insertcommentaire(String textarea, int user) {
	System.out.println("LOUIIIISSSSSSSS");
	Connection 	connection= in.SpringbootOCescalade.springboot.dao.SdzConnection.getInstance();
	java.sql.Statement stmt;
	
	
	//en cours
	
	  CommentDatabase commentaire = new CommentDatabase();   
	 
	  System.out.println("texarea vaut "+textarea+"    user vaut "+user);
	  try {
		  stmt = connection.createStatement();
		    stmt.executeUpdate("insert into commentaire(textarea,user) values ('"+textarea+"','"+user+"')");

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
}
