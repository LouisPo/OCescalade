package in.SpringbootOCescalade.springboot.dao;

import in.SpringbootOCescalade.springboot.model.Employee;
import in.SpringbootOCescalade.springboot.model.EmployeeDatabase;
import in.SpringbootOCescalade.springboot.model.Parcourss;
import in.SpringbootOCescalade.springboot.controller.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import in.SpringbootOCescalade.springboot.dao.SdzConnection;

	public class original_EmployeeDatabaseDAO extends DAO<EmployeeDatabase> {
	public original_EmployeeDatabaseDAO(Connection conn) {
	  super(conn);
	}

	public boolean create(EmployeeDatabase obj) {
	  return false;
	}

	public boolean delete(EmployeeDatabase obj) {
	  return false;
	}
	 
	public boolean update(EmployeeDatabase obj) {
	  return false;
	}
	@Override
	public List<Parcourss> findmultipleNoid(String nom, String localisation, int taille, int difficulte) {
		// TODO Auto-generated method stub
		return null;
	}	
	 
	public EmployeeDatabase find(int id) {
	  EmployeeDatabase employee = new EmployeeDatabase();      
	   return employee;
	}

	public EmployeeDatabase findmultiple(int id,String nom,String localisation) {
		  EmployeeDatabase employee = new EmployeeDatabase();      
		   return employee;
		}
	public List<Employee> findconnexion(String nom,String mdp) {
		EmployeeDatabase employee = new EmployeeDatabase();      
		ResultSet result = null;  
		//creation tableau de employees et parcourscourant l enregistrement courant
		List<Employee> ret=new ArrayList();
		//Parcourss parcourscourant= new Parcourss();
		
		System.out.println("nom : "+nom+" mdp : "+mdp);

		  try {

			     result = this.connect.createStatement(
				 ResultSet.TYPE_SCROLL_INSENSITIVE,
			     ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM user WHERE nom = '"+nom+"' and mdp = '"+mdp+"'");
			     
		    while(result.next()){
		    	Employee employecourant= new Employee();
		    	Integer user_id = result.getInt(1); 
		    	String nomm = result.getString(2); 
		    	String prenom = result.getString(3); 
		    	String mail = result.getString(4);
		    	Integer tel = result.getInt(5); 
		    	String password = result.getString(6);
		    	int row = result.getRow(); 
		    	System.out.println("Données contenues dans la ligne "+row); 
		    	System.out.println("id : "+user_id+" nom : "+nomm+" prenom : "+prenom+" mdp : "+password);
		    	employecourant.setId(user_id);employecourant.setnom(nomm);employecourant.setprenom(prenom);employecourant.setmail(mail);;employecourant.settel(tel);;employecourant.setmdp(password);
		    	//ajout de parcourscourant au tableau liste de parcours
		    	ret.add(employecourant);
		    	}

			} catch (SQLException e) {
					    e.printStackTrace();

			
		 ;
		}
		return ret;
	
	}


	}