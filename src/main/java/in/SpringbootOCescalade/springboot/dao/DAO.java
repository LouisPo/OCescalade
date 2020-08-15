package in.SpringbootOCescalade.springboot.dao;

import java.sql.Connection;
import java.util.Date;

//nouveau format de daate sous java 8
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import in.SpringbootOCescalade.springboot.dao.SdzConnection;
import in.SpringbootOCescalade.springboot.model.Employee;
import in.SpringbootOCescalade.springboot.model.Comment;
import in.SpringbootOCescalade.springboot.model.CommentDatabase;
import in.SpringbootOCescalade.springboot.model.Topo;
import in.SpringbootOCescalade.springboot.model.TopoDatabase;

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
public abstract List<Parcourss> findmultipleNoid(String nom,String localisation,int taille,String difficulte);

public  List<Comment> findcomment(int user,int parcoursidentifiant)
{
	
	CommentDatabase parcours = new CommentDatabase();      
	ResultSet result = null;  
	//creation tableau de parcourss et parcourscourant l enregistrement courant
	List<Comment> ret=new ArrayList();
    try {
		result = this.connect.createStatement(
		ResultSet.TYPE_SCROLL_INSENSITIVE,
		ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM commentaire WHERE user = '"+user+"' and parcoursidentifiant = '"+parcoursidentifiant+"'");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    try {
		while(result.next()){
			Comment commentcourant= new Comment();
			Integer comment_id = result.getInt(1); 
			String textarea = result.getString(2); 
			user = result.getInt(3); 
		    parcoursidentifiant = result.getInt(4);
			int row = result.getRow(); 
			commentcourant.setComment_id(comment_id);commentcourant.setUser(user);commentcourant.setTextarea(textarea);commentcourant.setParcoursidentifiant(parcoursidentifiant);
			//ajout de commentcourant au tableau liste de commentaire
			ret.add(commentcourant);
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}








public abstract void save(String textarea,int user);
/**
* Méthode de recherche des informations
* @param id
* @return T
*/
public abstract List<Employee> findconnexion(String nom,String localisation);

public void modiftopoDispo(int identifiant, int user) {
	//on recupere le nom et le prenom de la personne qui cree les commentairs
	ResultSet result = null;

	Connection 	connection= in.SpringbootOCescalade.springboot.dao.SdzConnection.getInstance();
	java.sql.Statement stmt;
System.out.println("user_id vaut"+user);
	  CommentDatabase commentaire = new CommentDatabase();   
      String disp = "NON";
	  try {
		  stmt = connection.createStatement();
		  stmt.executeUpdate("UPDATE  topo SET dispo = '"+disp+"'"+"WHERE user_id = '"+user+"'");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  try {
		  stmt = connection.createStatement();
		  stmt.executeUpdate("UPDATE  topo SET identifiantpret = '"+identifiant+"'"+"WHERE user_id = '"+user+"'");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void topoDispoRefuse(int identifiant, int user) {
	//on recupere le nom et le prenom de la personne qui cree les commentairs
	ResultSet result = null;

	Connection 	connection= in.SpringbootOCescalade.springboot.dao.SdzConnection.getInstance();
	java.sql.Statement stmt;
System.out.println("user_id vaut"+user);
	  CommentDatabase commentaire = new CommentDatabase();   
      String disp = "OUI";
	  try {
		  stmt = connection.createStatement();
		  stmt.executeUpdate("UPDATE  topo SET dispo = '"+disp+"'"+"WHERE user_id = '"+user+"'");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  identifiant=0;
	  try {
		  stmt = connection.createStatement();
		  stmt.executeUpdate("UPDATE  topo SET identifiantpret = '"+identifiant+"'"+"WHERE user_id = '"+user+"'");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void pretertopo(int identifiant, int user) {
	//on passe la colonne dispo a la valeur PRETE
	ResultSet result = null;

	Connection 	connection= in.SpringbootOCescalade.springboot.dao.SdzConnection.getInstance();
	java.sql.Statement stmt;
    System.out.println("user_id vaut"+user);
	  CommentDatabase commentaire = new CommentDatabase();   
      String disp = "PRETE";
	  try {
		  stmt = connection.createStatement();
		  stmt.executeUpdate("UPDATE  topo SET dispo = '"+disp+"'"+"WHERE user_id = '"+user+"'");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}




public void insertopo(String textarea, int user) {
	//on recupere le nom et le prenom de la personne qui cree les commentairs
	ResultSet result = null;
	String name="";
	String prenom="";
    try {
		result = this.connect.createStatement(
		ResultSet.TYPE_SCROLL_INSENSITIVE,
		ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user WHERE user_id = '"+user+"'");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    try {
		while(result.next()){ 
			name = result.getString(2); 
			prenom = result.getString(3);
			int row = result.getRow();
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
  //textarea=  "**"+name+ "   " +prenom+"**"+"\n" +textarea;

	Connection 	connection= in.SpringbootOCescalade.springboot.dao.SdzConnection.getInstance();
	java.sql.Statement stmt;

	  CommentDatabase commentaire = new CommentDatabase();   

	  try {
		  stmt = connection.createStatement();
		  stmt.executeUpdate("UPDATE  topo SET textarea = '"+textarea+"'"+"WHERE user_id = '"+user+"'");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//recupere la liste des topos d un utilisateur le cien et ceux kon lui a prete
public List<Topo> listTopPrete(int user) {
	TopoDatabase parcours = new TopoDatabase();      
	ResultSet result = null;  
	//creation tableau de parcourss et parcourscourant l enregistrement courant
	List<Topo> ret=new ArrayList();
    try {
		result = this.connect.createStatement(
		ResultSet.TYPE_SCROLL_INSENSITIVE,
		ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM topo WHERE identifiantpret = '"+user+"'");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    try {
		while(result.next()){
			Topo topocourant= new Topo();
			Integer topo_id = result.getInt(1); 
			String nomtopo = result.getString(2);
			Integer user_id = result.getInt(3);
			String nom = result.getString(4);
			String prenom = result.getString(5);
			String dispo = result.getString(6);
			String textarea = result.getString(7); 
			String identifiantpret = result.getString(8);
            int row = result.getRow();
			topocourant.setTopo_id(topo_id);topocourant.setNomtopo(nomtopo);topocourant.setUser_id(user_id);topocourant.setIdentifiantpret(identifiantpret);topocourant.setNom(nom);topocourant.setPrenom(prenom);topocourant.setDispo(dispo);topocourant.setTextarea(textarea);
			//ajout de commentcourant au tableau liste de commentaire
			
			ret.add(topocourant);
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ret;
}
public List<Topo> listTopo(int user) {
	TopoDatabase parcours = new TopoDatabase();      
	ResultSet result = null;  
	//creation tableau de parcourss et parcourscourant l enregistrement courant
	List<Topo> ret=new ArrayList();
    try {
		result = this.connect.createStatement(
		ResultSet.TYPE_SCROLL_INSENSITIVE,
		ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM topo");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    try {
		while(result.next()){
			Topo topocourant= new Topo();
			Integer topo_id = result.getInt(1); 
			String nomtopo = result.getString(2);
			Integer user_id = result.getInt(3);
			String nom = result.getString(4);
			String prenom = result.getString(5);
			String dispo = result.getString(6);
			String textarea = result.getString(7); 
			String identifiantpret = result.getString(8);
            int row = result.getRow();
			topocourant.setTopo_id(topo_id);topocourant.setNomtopo(nomtopo);topocourant.setUser_id(user_id);topocourant.setIdentifiantpret(identifiantpret);topocourant.setNom(nom);topocourant.setPrenom(prenom);topocourant.setDispo(dispo);topocourant.setTextarea(textarea);
			//ajout de commentcourant au tableau liste de commentaire
			
			ret.add(topocourant);
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ret;
}
public String[] recuptopo(int user) {
	String[] tab = new String[8];
	ResultSet result = null;
    try {
		result = this.connect.createStatement(
		ResultSet.TYPE_SCROLL_INSENSITIVE,
		ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM topo WHERE user_id = '"+user+"'");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    try {
		while(result.next()){ 
			tab[0] = result.getString(1); 
			tab[1] = result.getString(2);
			tab[2] = result.getString(3); 
			tab[3] = result.getString(4);	
			tab[4] = result.getString(5);
			tab[5] = result.getString(6);	
			tab[6] = result.getString(7);
			tab[7] = result.getString(8);
			int row = result.getRow();
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return tab;

}


public String[] recupuser(int user) {
	String[] tab = new String[5];
	//on recupere le nom et le prenom de la personne qui cree les commentairs
	ResultSet result = null;
	String name="";
	String prenom="";
    try {
		result = this.connect.createStatement(
		ResultSet.TYPE_SCROLL_INSENSITIVE,
		ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user WHERE user_id = '"+user+"'");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    try {
		while(result.next()){ 
			tab[0] = result.getString(1); 
			tab[1] = result.getString(2);
			tab[2] = result.getString(3); 
			tab[3] = result.getString(4);	
			tab[4] = result.getString(5);
			int row = result.getRow();
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return tab;

}



public void insertcommentaire(String textarea, int user,int parcoursidentifiant,String identite,String date) {
	//on recupere le nom et le prenom de la personne qui cree les commentairs
	ResultSet result = null;
	String name="";
	String prenom="";
    try {
		result = this.connect.createStatement(
		ResultSet.TYPE_SCROLL_INSENSITIVE,
		ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user WHERE user_id = '"+user+"'");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    try {
		while(result.next()){ 
			name = result.getString(2); 
			prenom = result.getString(3);
			int row = result.getRow();
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    //Date dateactuelle = new Date();
    //DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
    //String dat = dateFormat.format(dateactuelle);	
    LocalDateTime currentTime = LocalDateTime.now();
    LocalDate dateactuelle = currentTime.toLocalDate();
    //textarea=  "**"+name+ "   " +prenom+"   "+dateactuelle+"**"+"\n" +textarea;

	Connection 	connection= in.SpringbootOCescalade.springboot.dao.SdzConnection.getInstance();
	java.sql.Statement stmt;

	  CommentDatabase commentaire = new CommentDatabase();   

	  try {
		  stmt = connection.createStatement();
		 // stmt.executeUpdate("insert into commentaire(textarea,user,parcoursidentifiant,identite,date) values ('"+textarea+"','"+user+"','"+parcoursidentifiant+"')");
		  stmt.executeUpdate("insert into commentaire(textarea,user,parcoursidentifiant,identite,date) values ('"+textarea+"','"+user+"','"+parcoursidentifiant+"','"+name+"','"+dateactuelle+"')");
	  } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public List<Comment> findcommentnotmodif(int user, int parcoursidentifiant) {
	// TODO Auto-generated method stub
	return null;
}



public void changetoadmin(int identifiant) {
	
	//on recupere le nom et le prenom de la personne qui cree les commentairs
		ResultSet result = null;
		String name="";
		String prenom="";
	    try {
			result = this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user WHERE user_id = '"+identifiant+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			while(result.next()){ 
				name = result.getString(2); 
				prenom = result.getString(3);
				int row = result.getRow();
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	


	Connection 	connection= in.SpringbootOCescalade.springboot.dao.SdzConnection.getInstance();
	java.sql.Statement stmt;
	 CommentDatabase commentaire = new CommentDatabase();   
     String disp = "AD"+prenom;
   
	 try {
		  stmt = connection.createStatement();
		  stmt.executeUpdate("UPDATE  user SET prenom = '"+disp+"'"+"WHERE user_id = '"+identifiant+"'");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}



public void deletecomment(int user, int parcoursidentifiant) {
	
	Connection 	connection= in.SpringbootOCescalade.springboot.dao.SdzConnection.getInstance();
	java.sql.Statement stmt;
	
	
	//en cours
	
	  CommentDatabase commentaire = new CommentDatabase();   

	  try {
		  stmt = connection.createStatement();
		    //stmt.executeUpdate("insert into commentaire(textarea,user) values ('"+textarea+"','"+user+"')");
		  stmt.executeUpdate("DELETE FROM commentaire WHERE user = '"+user+"' and parcoursidentifiant = '"+parcoursidentifiant+"'");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void validerparcours(int parcoursidentifiant) {
	// TODO Auto-generated method stub
	
}
	
}
