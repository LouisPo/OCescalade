package in.SpringbootOCescalade.springboot.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import in.SpringbootOCescalade.springboot.model.Parcourss;
import in.SpringbootOCescalade.springboot.service.ParcourssService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;
import in.SpringbootOCescalade.springboot.dao.DAO;
import in.SpringbootOCescalade.springboot.dao.DAOFactory;
import in.SpringbootOCescalade.springboot.dao.Eleve;
import in.SpringbootOCescalade.springboot.model.ParcoursDatabase;
import in.SpringbootOCescalade.springboot.model.ParcoursRepository;

@Controller
public class ParcourssController {
	

	
	@Autowired
	private ParcourssService parcoursService;
		
	@RequestMapping(value = {"////", "/home2", "/index2"})
	public ModelAndView getparcours() {
		ModelAndView mav2 = new ModelAndView("parcoursList");
		List<Parcourss> list = parcoursService.getparcours();
		mav2.addObject("list", list);
		return mav2;
	}
	
	@RequestMapping("/openParcoursView")
	public ModelAndView openParcoursAddView() {
		ModelAndView mav = new ModelAndView("parcoursAdd");
		mav.addObject("parcours", new Parcourss());
		return mav;
	}
	
	@RequestMapping("/saveparcours")
	public ModelAndView saveparcours(@ModelAttribute("parcours") Parcourss parcoursObj) {
		ModelAndView mav = new ModelAndView("parcoursList");
		parcoursService.saveparcours(parcoursObj);
		List<Parcourss> list = parcoursService.getparcours();
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/parcours/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("parcoursAdd");
		Parcourss parcoursObj = parcoursService.getparcours(id);
		if(parcoursObj == null) {
			throw new RuntimeException("Parcours not found"+id);
		}
		mav.addObject("parcours", parcoursObj);
		return mav;
	}
	
	@RequestMapping("/deleteparcours/{id}")
	public ModelAndView deleteparcours(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("parcoursList");
		parcoursService.deleteparcours(id);
		List<Parcourss> list = parcoursService.getparcours();
		mav.addObject("list", list);
		return mav;
		
		
	}
	
	@RequestMapping("/openParcoursRechercheView")
	public ModelAndView openrechercheParcoursView() {
		ModelAndView mav = new ModelAndView("rechercheParcours");
		mav.addObject("parcours", new Parcourss());
		return mav;
	}


	//@RequestMapping("/resultatparcours")
	@RequestMapping(value="/resultatparcours", method=RequestMethod.POST)
	public ModelAndView resultatparcours(@ModelAttribute("parcours") Parcourss parcoursObj,@RequestParam("localisation") String localisation,@RequestParam("difficulte") String difficulte,@RequestParam("taille") String taille,@RequestParam("nom") String nom) {
	
	
        
		try {
            Class.forName("org.hibernate.jpa.HibernatePersistenceProvider");
            System.out.println("called class");
        } catch (Exception e){
            e.printStackTrace();
        }
		Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
		
		  //On récupère un objet faisant le lien entre la base et nos objets 
		  DAO<ParcoursDatabase> parcoursDao = DAOFactory.getParcoursDAO();
		  
		  //recherche d une ligne avec un id donne 
		  //Parcours parcours = parcoursDao.find(7);
		  //System.out.println("\tPARCOURS N°" + parcours.getparcours_id() + " - NOM : " + parcours.getnom() + " - taille : " + parcours.gettaille());

			  
		  ModelAndView mav = new ModelAndView("resultatparcours");
		  List<Parcourss> list = parcoursService.getparcours();  
		 // List<Parcourss> list = new ArrayList(6);
          //System.out.println("taille  "+list.size()); 
          List<Parcourss> ret=new ArrayList();

		  //REQUETE SQL on recupere le resultat de la requete 
	      if(taille.equals("")) {taille="0";}
		  ret  = parcoursDao.findmultipleNoid(nom, localisation,Integer.parseInt(taille),Integer.parseInt(difficulte));
		  //System.out.println("taille de ret RRREEETT"+ret.size());
          //vidage de list
		  for(int j=0;j<list.size();j++) {
				list.get(j).setnom("");
				list.get(j).settaille(0);
				list.get(j).setdifficulte(0);
				list.get(j).setlocalisation("");	
				}
         //remplissage avec resultat de la requete SQL
		  for(int i=0;i<ret.size();i++) {
				list.get(i).setnom(ret.get(i).getnom());
				list.get(i).settaille(ret.get(i).gettaille());
				list.get(i).setdifficulte(ret.get(i).getdifficulte());
				list.get(i).setlocalisation(ret.get(i).getlocalisation());	
				System.out.println(" nom : "+ret.get(i).getnom()+" size : "+ret.get(i).gettaille()+" difficult : "+ret.get(i).getdifficulte()+"localisation  "+ ret.get(i).getlocalisation());
				}
		  //System.out.println("taille de ret LISSSST avant"+list.size());
		  for(int k=0;k<list.size();k++) {
			  if(list.get(k).gettaille() ==0)
				list.remove(k);
				
		  }

         // System.out.println("taille de ret LISSSST"+list.size());
	/**********************************************************/	  
		  DAO<Eleve> eleveDao = DAOFactory.getEleveDAO();
		  for(int i = 1; i < 10; i++){
		    //On fait notre recherche
		    Eleve eleve = eleveDao.find(i);
		    //System.out.println("\tELEVE N°" + eleve.getId() + " - NOM : " + eleve.getNom() + " - PRENOM : " + eleve.getPrenom());
		  
		  }
		

		// Create our entity manager
		
        //EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Parcourss");
        //EntityManager entityManager = entityManagerFactory.createEntityManager();
	    //EntityManagerFactory emf = Persistence.createEntityManagerFactory("Parcourss", System.getProperties());
	    //EntityManager c = emf.createEntityManager();
		
		
		//ok
	    org.hibernate.jpa.HibernatePersistenceProvider entityManagerFactory =new  org.hibernate.jpa.HibernatePersistenceProvider();
	    entityManagerFactory.createEntityManagerFactory("Parcourss", System.getProperties());
	    //EntityManager entityManager = entityManagerFactory.createEntityManager();
	    
		/*try {
          Class.forName("javax.persistence.EntityManagerFactory");
          System.out.println("called class oto");
      } catch (Exception e){
          e.printStackTrace();
      } */ 
		
	   /* javax.persistence.EntityManagerFactory factory = Persistence.createEntityManagerFactory("Parcourss");
	    EntityManager entityManager = factory.createEntityManager();
	    entityManager.getTransaction().begin();
	    */
        // Create our repositories
       // ParcoursRepository parcoursRepository = new ParcoursRepository(entityManager);
        //AuthorRepository authorRepository = new AuthorRepository(entityManager);
        // Create an author and add 3 books to his list of books
        //Author author = new Author("Author 1");
        
        /*parcours1 = new Parcours()
        
        author.addBook(new Book("Book 1"));
        author.addBook(new Book("Book 2"));
        author.addBook(new Book("Book 3"));*/
        
     // Search for a book by ID
       //Optional<Parcourss> foundBook = parcoursRepository.findById(2);
      //  foundBook.ifPresent(System.out::println);
        // Search for a book with an invalid ID
     //   Optional<Parcourss> notFoundParcours = parcoursRepository.findById(99);
    //    notFoundParcours.ifPresent(System.out::println);
        // List all books
    //   List<Parcourss> listparcours = parcoursRepository.findAll();
     //  System.out.println("parcours in database:");
     //  listparcours.forEach(System.out::println);
       //sSystem.out.println("PAPA");
        // Find a parcours by name
       // Optional<Parcourss> queryBook1 = parcoursRepository.findByName("mereville");
      //  System.out.println("Query for book 2:");
      //  queryBook1.ifPresent(System.out::println);
        // Find a book by name using a named query
      //  Optional<Parcourss> queryBook2 = parcoursRepository.findByNameNamedQuery("etampes");
      //  System.out.println("Query for book 3:");
      //  queryBook2.ifPresent(System.out::println);


			
         
 

	
			//mav.addObject("list", ret);
             mav.addObject("list", ret);
			return mav;
			
	}

}
