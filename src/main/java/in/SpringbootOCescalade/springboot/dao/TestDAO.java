package in.SpringbootOCescalade.springboot.dao;
import in.SpringbootOCescalade.springboot.model.ParcoursDatabase;


public class TestDAO {
public static void main(String[] args) { 

  
  DAO<Eleve> eleveDao = DAOFactory.getEleveDAO();
  for(int i = 1; i < 10; i++){
    //On fait notre recherche
    Eleve eleve = eleveDao.find(i);
  
  }
 
  //On récupère un objet faisant le lien entre la base et nos objets 
  DAO<ParcoursDatabase> parcoursDao = DAOFactory.getParcoursDAO();
    
  //recherche d une ligne avec multiple criteres 
  for(int k = 1; k < 25; k++){
      ParcoursDatabase parcours = parcoursDao.findmultiple(k,"parc", "etampes");
  }  

    
}
}