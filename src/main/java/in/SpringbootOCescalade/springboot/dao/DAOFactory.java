package in.SpringbootOCescalade.springboot.dao;
import java.sql.Connection;
import in.SpringbootOCescalade.springboot.dao.SdzConnection;

public class DAOFactory {
protected static final Connection conn = SdzConnection.getInstance();   
 
/**
* Retourne un objet Classe interagissant avec la BDD
* @return DAO
*/
public static DAO getClasseDAO(){
  return new ClasseDAO(conn);
}

/**
* Retourne un objet parcours interagissant avec la BDD
* @return DAO
*/
public static DAO getParcoursDAO(){
  return new ParcoursDatabaseDAO(conn);
}
public static DAO getCommentDAO(){
	  return new ParcoursDatabaseDAO(conn);
	}

public static DAO getEmployeeDAO(){
	  return new EmployeeDatabaseDAO(conn);
	}

/**
* Retourne un objet Eleve interagissant avec la BDD
* @return DAO
*/
public static DAO getEleveDAO(){
  return new EleveDAO(conn);
}
}