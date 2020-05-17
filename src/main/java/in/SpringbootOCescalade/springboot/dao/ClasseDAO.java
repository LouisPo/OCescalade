package in.SpringbootOCescalade.springboot.dao;

import java.sql.ResultSet;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import in.SpringbootOCescalade.springboot.dao.SdzConnection;
import in.SpringbootOCescalade.springboot.model.Employee;
import in.SpringbootOCescalade.springboot.model.Parcourss;

//CTRL + SHIFT + O pour générer les imports
public class ClasseDAO extends DAO<Classe> {
public ClasseDAO(Connection conn) {
  super(conn);
}

public boolean create(Classe obj) {
  return false;
}

public boolean delete(Classe obj) {
  return false;
}
 
public boolean update(Classe obj) {
  return false;
}


public Classe findmultiple(int id,String nom,String localisation) {
    Classe classe = new Classe();            
    return classe;
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
  

void insertcommentaire(String  textarea,Integer user) {
	
}

public Classe find(int id) {
    Classe classe = new Classe();            
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM classe WHERE cls_id = " + id); 

      if(result.first()){
        classe = new Classe(id, result.getString("cls_nom"));

        result = this.connect.createStatement().executeQuery(
          "SELECT prof_id, prof_nom, prof_prenom from professeur " +
          "INNER JOIN j_mat_prof ON prof_id = jmp_prof_k " +
          "INNER JOIN j_cls_jmp ON jmp_id = jcm_jmp_k AND jcm_cls_k = " + id
        );

        ParcoursDatabaseDAO parcoursDao = new ParcoursDatabaseDAO(this.connect);
        result = this.connect.createStatement().executeQuery(
          "SELECT parcours_id, nom, taille,difficulte,localisation FROM parcours " + id );

        while(result.next())
          classe.addParcoursDatabase(parcoursDao.find(result.getInt("parcours_id")));
      
        

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return classe;
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
}