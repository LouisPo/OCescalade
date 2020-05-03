package in.SpringbootOCescalade.springboot.dao;

import java.sql.Connection;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import in.SpringbootOCescalade.springboot.dao.SdzConnection;
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
}
