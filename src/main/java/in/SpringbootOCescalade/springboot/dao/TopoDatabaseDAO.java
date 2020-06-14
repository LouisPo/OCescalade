package in.SpringbootOCescalade.springboot.dao;

import in.SpringbootOCescalade.springboot.model.Employee;
import in.SpringbootOCescalade.springboot.model.ParcoursDatabase;
import in.SpringbootOCescalade.springboot.model.CommentDatabase;
import in.SpringbootOCescalade.springboot.model.Parcourss;
import in.SpringbootOCescalade.springboot.model.Comment;
import in.SpringbootOCescalade.springboot.controller.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.sql.*;
//import com.mysql.jdbc.Statement;

import in.SpringbootOCescalade.springboot.dao.SdzConnection;

	public class TopoDatabaseDAO extends DAO<ParcoursDatabase> {
	public TopoDatabaseDAO(Connection conn) {
	  super(conn);
	}

	public boolean create(ParcoursDatabase obj) {
	  return false;
	}

	public boolean delete(ParcoursDatabase obj) {
	  return false;
	}
	 
	public boolean update(ParcoursDatabase obj) {
	  return false;
	}
	void insertcommentaire(String  textarea,Integer user,Integer parcoursidentifiant) {
		
	}
	public ParcoursDatabase find(int id) {
	  ParcoursDatabase parcours = new ParcoursDatabase();      
	  
	  try {
	    ResultSet result = this.connect.createStatement(
	      ResultSet.TYPE_SCROLL_INSENSITIVE,
	      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM parcours WHERE parcours_id = " + id);
		  
				  if(result.first())
				      parcours = new ParcoursDatabase(id,result.getString("nom"),result.getInt("taille"),result.getInt("difficulte"),result.getString("localisation"));         
				  } catch (SQLException e) {
				    e.printStackTrace();
				  }
	      return parcours;
	}
	
	public void insertcommentaire(int id,String textarea,int parcoursidentifiant) {
		Connection 	connection= in.SpringbootOCescalade.springboot.dao.SdzConnection.getInstance();
		java.sql.Statement stmt;
		
		System.out.println("Vous etes dans commentdatabasedao");
		  CommentDatabase commentaire = new CommentDatabase();   
         String user="45";
		  try {
			  stmt = connection.createStatement();
			   // stmt.executeUpdate("insert into commentaire values ('"+textarea+"','"+user+"')");
			  stmt.executeUpdate("insert into commentaire(textarea,user,parcoursidentifiant) values ('"+textarea+"','"+user+"','"+parcoursidentifiant+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	public ParcoursDatabase findmultiple(int id,String nom,String localisation) {
		  ParcoursDatabase parcours = new ParcoursDatabase();      

		  try {
		    ResultSet result = this.connect.createStatement(
		      ResultSet.TYPE_SCROLL_INSENSITIVE,
		      //ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM parcours WHERE nom = '"+nom+"' and localisation = '"+localisation+"'");
		      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM parcours WHERE nom = '"+nom+"' and localisation = '"+localisation+"' and parcours_id = '"+id+"'");
					  if(result.first())						
					         System.out.println("TROUVE "+result.getString("nom")+"   "+result.getString("localisation"));
					         parcours = new ParcoursDatabase(id,result.getString("nom"),result.getInt("taille"),result.getInt("difficulte"),result.getString("localisation"));    
					  
					  } catch (SQLException e) {
					    e.printStackTrace();
					  }
		              //System.out.println("TAILLE  "+parcours.gettaille());
		      return parcours;
		}
	public List<Parcourss> findmultipleNoid(String nom,String localisation,int taille,int difficulte) {
		ParcoursDatabase parcours = new ParcoursDatabase();      
		ResultSet result = null;  
		//creation tableau de parcourss et parcourscourant l enregistrement courant
		List<Parcourss> ret=new ArrayList();
		//Parcourss parcourscourant= new Parcourss();
		
		System.out.println("nom : "+nom+" taille : "+taille+" difficulte : "+difficulte+"localisation  "+ localisation);

		  try {
			  
				//recherche par taille uniquement (tous les autres champs vides)
				if( (!(taille==0)&& (localisation.equals("")) && (nom.equals("") ))) {
			              result = this.connect.createStatement(
					      ResultSet.TYPE_SCROLL_INSENSITIVE,
					      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM parcours WHERE taille = '"+taille+"' and difficulte = '"+difficulte+"'");
				}
				//recherche par difficulte uniquement (tous les autres champs vides)
				if( ((localisation.equals(""))&& (taille==0)  && (nom.equals("") ))) {
	              result = this.connect.createStatement(
			      ResultSet.TYPE_SCROLL_INSENSITIVE,
			      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM parcours WHERE difficulte = '"+difficulte+"'");
				}
				//recherche par localisation uniquement (tous les autres champs vides=
				if( (!(localisation.equals(""))&& (taille==0) && (nom.equals("") ))) {
	              result = this.connect.createStatement(
			      ResultSet.TYPE_SCROLL_INSENSITIVE,
			      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM parcours WHERE localisation = '"+localisation+"' and difficulte = '"+difficulte+"'");
				}
				//recherche par nom uniquement (tous les autres champs vides=
				if( (!(nom.equals(""))&& (taille==0) && (localisation.equals("") ))) {
	              result = this.connect.createStatement(
			      ResultSet.TYPE_SCROLL_INSENSITIVE,
			      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM parcours WHERE nom = '"+nom+"' and difficulte = '"+difficulte+"'");
				}
				//recherche par nom et localisation (tous les autres champs vides=
				if( (!(nom.equals(""))&& (taille==0) && (!(localisation.equals(""))))) {
	              result = this.connect.createStatement(
			      ResultSet.TYPE_SCROLL_INSENSITIVE,
			      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM parcours WHERE nom = '"+nom+"' and localisation = '"+localisation+"' and difficulte = '"+difficulte+"'");
				}
				//recherche par nom et difficulte (tous les autres champs vides=
				if( (!(nom.equals(""))&& (taille==0) && (localisation.equals("")))) {
	              result = this.connect.createStatement(
			      ResultSet.TYPE_SCROLL_INSENSITIVE,
			      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM parcours WHERE nom = '"+nom+"' and difficulte = '"+difficulte+"'");
				}
				//recherche par nom et taille (tous les autres champs vides=
				if( (!(nom.equals(""))&& (!(taille==0))&& (localisation.equals("")))) {
	              result = this.connect.createStatement(
			      ResultSet.TYPE_SCROLL_INSENSITIVE,
			      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM parcours WHERE nom = '"+nom+"' and taille = '"+taille+"' and difficulte = '"+difficulte+"'");
				}
				//recherche par difficulte et taille (tous les autres champs vides=
				if( (nom.equals("")&& (!(taille==0))&& (localisation.equals("")))) {
	              result = this.connect.createStatement(
			      ResultSet.TYPE_SCROLL_INSENSITIVE,
			      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM parcours WHERE difficulte = '"+difficulte+"' and taille = '"+taille+"'");
				}
				//recherche par localisation et taille (tous les autres champs vides=
				if( (nom.equals("")&& (!(taille==0))&& (!(localisation.equals(""))))) {
	              result = this.connect.createStatement(
			      ResultSet.TYPE_SCROLL_INSENSITIVE,
			      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM parcours WHERE localisation = '"+localisation+"' and taille = '"+taille+"' and difficulte = '"+difficulte+"'");
				}
				//recherche par localisation et difficulte (tous les autres champs vides=
				if( (nom.equals(""))&& (taille==0) && (!(localisation.equals("")))) {
	              result = this.connect.createStatement(
			      ResultSet.TYPE_SCROLL_INSENSITIVE,
			      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM parcours WHERE localisation = '"+localisation+"' and difficulte = '"+difficulte+"'");
				}
				//recherche par nom et taille et difficulte (tous les autres champs vides=
				if( (localisation.equals(""))&& (!(taille==0)) && (!(nom.equals("")))) {
	              result = this.connect.createStatement(
			      ResultSet.TYPE_SCROLL_INSENSITIVE,
			      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM parcours WHERE taille = '"+taille+"' and nom = '"+nom+"' and difficulte = '"+difficulte+"'");
				}
				//recherche par nom et taille et difficulte localisation 
				if(  (!(localisation.equals("")))&& (!(taille==0)) && (!(nom.equals("")))) {
	              result = this.connect.createStatement(
			      ResultSet.TYPE_SCROLL_INSENSITIVE,
			      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM parcours WHERE taille = '"+taille+"' and nom = '"+nom+"' and difficulte = '"+difficulte+"'");
				}
		    while(result.next()){
		    	Parcourss parcourscourant= new Parcourss();
		    	Integer id = result.getInt(1); 
		    	String nomm = result.getString(2); 
		    	Integer size = result.getInt(3); 
		    	Integer difficult = result.getInt(4);
		    	String local = result.getString(5); 
		    	int row = result.getRow(); 
		    	System.out.println("Données contenues dans la ligne "+row); 
		    	System.out.println("id : "+id+" nom : "+nomm+" size : "+size+" difficult : "+difficult+"localisation  "+ local);
		    	parcourscourant.setId(id);parcourscourant.setnom(nomm);parcourscourant.settaille(size);parcourscourant.setdifficulte(difficult);parcourscourant.setlocalisation(local);
		    	//ajout de parcourscourant au tableau liste de parcours
		    	ret.add(parcourscourant);
		    	}

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
				System.out.println("Données contenues dans la ligne "+row); 
				System.out.println("id : "+comment_id+" textarea : "+textarea+" user : "+user+" difficult : "+parcoursidentifiant);
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
	
	}	