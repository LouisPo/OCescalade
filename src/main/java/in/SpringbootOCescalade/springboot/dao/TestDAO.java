package in.SpringbootOCescalade.springboot.dao;
import in.SpringbootOCescalade.springboot.model.ParcoursDatabase;


public class TestDAO {
public static void main(String[] args) { 
  System.out.println("");
  
  
  DAO<Eleve> eleveDao = DAOFactory.getEleveDAO();
  for(int i = 1; i < 10; i++){
    //On fait notre recherche
    Eleve eleve = eleveDao.find(i);
    System.out.println("\tELEVE N°" + eleve.getId() + " - NOM : " + eleve.getNom() + " - PRENOM : " + eleve.getPrenom());
  
  }
 
  //On récupère un objet faisant le lien entre la base et nos objets 
  DAO<ParcoursDatabase> parcoursDao = DAOFactory.getParcoursDAO();
  
  //recherche d une ligne avec un id donne 
  //Parcours parcours = parcoursDao.find(7);
  //System.out.println("\tPARCOURS N°" + parcours.getparcours_id() + " - NOM : " + parcours.getnom() + " - taille : " + parcours.gettaille());
  
  //recherche d une ligne avec multiple criteres 
  for(int k = 1; k < 25; k++){
      ParcoursDatabase parcours = parcoursDao.findmultiple(k,"parc", "etampes");
      System.out.println("\tPARCOURS N°" + parcours.getparcours_id() + " - NOM : " + parcours.getnom() + " - taille : " + parcours.gettaille()+ " - localisation : " + parcours.getlocalisation());
  }  

  
  //affichage de tous les enregistrement parcours liste complete  
 /* for(int j = 1; j < 15; j++){
    //On fait notre recherche
    ParcoursDatabase parcours = parcoursDao.find(j);
    System.out.println("\tPARCOURS N°" + parcours.getparcours_id() + " - NOM : " + parcours.getnom() + " - taille : " + parcours.gettaille());
  } */
    
}
}