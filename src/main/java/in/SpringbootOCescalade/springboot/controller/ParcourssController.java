package in.SpringbootOCescalade.springboot.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.SpringbootOCescalade.springboot.service.ParcourssService;
import in.SpringbootOCescalade.springboot.service.TopoService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Optional;
import in.SpringbootOCescalade.springboot.dao.DAO;
import in.SpringbootOCescalade.springboot.dao.DAOFactory;
import in.SpringbootOCescalade.springboot.model.*;
import in.SpringbootOCescalade.springboot.dao.Eleve;
import in.SpringbootOCescalade.springboot.service.*;
import in.SpringbootOCescalade.springboot.model.*;

@Controller
public class ParcourssController {
	

	
	@Autowired
	private ParcourssService parcoursService;
	private CommentService commentService;
	private TopoService topoService;
		
	@RequestMapping(value = {"////", "/home2", "/index2"})
	public ModelAndView getparcours() {
		ModelAndView mav2 = new ModelAndView("parcoursList");
		List<Parcourss> list = parcoursService.getparcours();
		mav2.addObject("list", list);
		return mav2;
	}
	@RequestMapping(value="/openParcoursView", method=RequestMethod.POST)
	public ModelAndView openParcoursView(@RequestParam("user_id") String user_id) {
		ModelAndView mav = new ModelAndView("parcoursAdd");
		mav.addObject("parcours", new Parcourss());
		mav.addObject("user_id", user_id);  

		return mav;
	}   

	@RequestMapping("/parcoursdetail/{id}")
	public ModelAndView getdetail(@PathVariable("id") int id) {
     ModelAndView mav = new ModelAndView("parcoursdetail");
		Parcourss parcoursObj = parcoursService.getparcours(id);
		if(parcoursObj == null) {
			throw new RuntimeException("Parcours not found"+id);
		}
		mav.addObject("parcours", parcoursObj);
		mav.addObject("parcoursidentifiant", id);
		mav.addObject("user_id", id);  
		mav.addObject("user", "100");
		
		return mav;
	}
	@RequestMapping(value="/ValiderView", method=RequestMethod.POST)
	public ModelAndView ValiderView(HttpServletRequest request,@RequestParam("parcoursidentifiant") String parcoursidentifiant,@RequestParam("user_id") String user_id,@RequestParam("nom") String nom,@RequestParam("taille") String taille,@RequestParam("difficulte") String difficulte,@RequestParam("localisation") String localisation) throws ServletRequestBindingException {
        //recuperation des parametres http
        user_id = ServletRequestUtils.getStringParameter(request, "user_id");
        parcoursidentifiant = ServletRequestUtils.getStringParameter(request, "parcoursidentifiant");
        nom = ServletRequestUtils.getStringParameter(request, "nom");
        taille = ServletRequestUtils.getStringParameter(request, "taille");
        difficulte = ServletRequestUtils.getStringParameter(request, "difficulte");
        localisation = ServletRequestUtils.getStringParameter(request, "localisation");
      
        //recuperation des infos du user connecter
        String[] tab = new String[4];
		DAO<CommentDatabase> commentaireDao3 = DAOFactory.getCommentDAO();
		tab = commentaireDao3.recupuser(Integer.parseInt(user_id));
        
        
		List<Comment> ret=new ArrayList();
		//ret  = commentaireDao.findcomment(Integer.parseInt(user_id),Integer.parseInt(parcoursidentifiant));
		DAO<CommentDatabase> commentaireDao = DAOFactory.getCommentDAO();
		ret  = commentaireDao.findcomment(Integer.parseInt(user_id),Integer.parseInt(parcoursidentifiant));
		//commentaire user connecter modifiable
		String textarea="";
		  for(int i=0;i<ret.size();i++) {	
			  textarea = textarea +ret.get(i).getTextarea();
				}
		
		
		  //textarea non modifiable comentaire autres user
		  List<Comment> ret2=new ArrayList();
		  DAO<CommentDatabase> commentaireDao2 = DAOFactory.getCommentDAO();
			ret2  = commentaireDao2.findcommentnotmodif(Integer.parseInt(user_id),Integer.parseInt(parcoursidentifiant));
			String textareaNomodif="";
			  for(int j=0;j<ret2.size();j++) {
				  textareaNomodif = textareaNomodif +ret2.get(j).getTextarea();
					}
			  textareaNomodif = "\n"+textareaNomodif+"\n";
		//page affichée
		ModelAndView mav = new ModelAndView("parcoursdetail");

		mav.addObject("parcoursidentifiant", parcoursidentifiant);
		mav.addObject("textarea", textarea);
		mav.addObject("textareaNomodif", textareaNomodif);
		mav.addObject("user_id", user_id);
		mav.addObject("nom", nom);
		mav.addObject("prenom",tab[2]);
		mav.addObject("taille", taille);
		mav.addObject("difficulte", difficulte);
		mav.addObject("localisation", localisation);
		mav.addObject("passage", "NO");
		return mav;
	}

	//on affiche la page de profil en venant de la page de list des topos en clickant sur un lien
	@RequestMapping(value="/openProfilHrefView", method=RequestMethod.GET)
	public ModelAndView openProfilHrefView(HttpServletRequest request,@RequestParam("user_id") String user_id,@RequestParam("identifiant") String identifiant) throws ServletRequestBindingException {
        //recuperation des parametres http
        user_id = ServletRequestUtils.getStringParameter(request, "user_id");
        identifiant = ServletRequestUtils.getStringParameter(request, "identifiant");
		//connexion a la BD
		String[] tab = new String[4];
		DAO<CommentDatabase> commentaireDao = DAOFactory.getCommentDAO();
		tab = commentaireDao.recupuser(Integer.parseInt(user_id));
		
		ModelAndView mav = new ModelAndView("profil");
		mav.addObject("user_id", user_id);
		mav.addObject("identifiant", identifiant);
		mav.addObject("nom", tab[1]);
		mav.addObject("prenom", tab[2]);
		mav.addObject("mail", tab[3]);
		mav.addObject("telephone", tab[4]);
		
		return mav;
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public ModelAndView parcoursdetail(HttpServletRequest request,@RequestParam("parcoursidentifiant") String parcoursidentifiant,@RequestParam("user_id") String user_id,@RequestParam("nom") String nom,@RequestParam("taille") String taille,@RequestParam("difficulte") String difficulte,@RequestParam("localisation") String localisation) throws ServletRequestBindingException {
        //recuperation des parametres http
        user_id = ServletRequestUtils.getStringParameter(request, "user_id");
        parcoursidentifiant = ServletRequestUtils.getStringParameter(request, "parcoursidentifiant");
        nom = ServletRequestUtils.getStringParameter(request, "nom");
        taille = ServletRequestUtils.getStringParameter(request, "taille");
        difficulte = ServletRequestUtils.getStringParameter(request, "difficulte");
        localisation = ServletRequestUtils.getStringParameter(request, "localisation");
      
        //recuperation des infos du user connecter
        String[] tab = new String[4];
		DAO<CommentDatabase> commentaireDao3 = DAOFactory.getCommentDAO();
		tab = commentaireDao3.recupuser(Integer.parseInt(user_id));
        
        
		List<Comment> ret=new ArrayList();
		//ret  = commentaireDao.findcomment(Integer.parseInt(user_id),Integer.parseInt(parcoursidentifiant));
		DAO<CommentDatabase> commentaireDao = DAOFactory.getCommentDAO();
		ret  = commentaireDao.findcomment(Integer.parseInt(user_id),Integer.parseInt(parcoursidentifiant));
		//commentaire user connecter modifiable
		String textarea="";
		  for(int i=0;i<ret.size();i++) {	
			  textarea = textarea +ret.get(i).getTextarea();
				}
		
		
		  //textarea non modifiable comentaire autres user
		  List<Comment> ret2=new ArrayList();
		  DAO<CommentDatabase> commentaireDao2 = DAOFactory.getCommentDAO();
			ret2  = commentaireDao2.findcommentnotmodif(Integer.parseInt(user_id),Integer.parseInt(parcoursidentifiant));
			String textareaNomodif="";
			  for(int j=0;j<ret2.size();j++) {
				  textareaNomodif = textareaNomodif +"----------"+ret2.get(j).getTextarea();
					}
			  textareaNomodif = "\n"+textareaNomodif+"\n";
		//page affichée
		ModelAndView mav = new ModelAndView("parcoursdetail");

		mav.addObject("parcoursidentifiant", parcoursidentifiant);
		mav.addObject("textarea", textarea);
		mav.addObject("textareaNomodif", textareaNomodif);
		mav.addObject("user_id", user_id);
		mav.addObject("nom", nom);
		mav.addObject("prenom",tab[2]);
		mav.addObject("taille", taille);
		mav.addObject("difficulte", difficulte);
		mav.addObject("localisation", localisation);
		mav.addObject("passage", "YES");
		mav.addObject("list", ret2);
		return mav;
	}
	
	@RequestMapping(value="/ajoutCommentView", method=RequestMethod.POST)
	public ModelAndView savecomment(@ModelAttribute("parcours") Parcourss parcoursObj,@RequestParam("textarea") String textarea,@RequestParam("textareaNomodif") String textareaNomodif,@RequestParam("user_id") String user_id,@RequestParam("nom") String nom,@RequestParam("taille") String taille,@RequestParam("difficulte") String difficulte,@RequestParam("localisation") String localisation,@RequestParam("parcoursidentifiant") String parcoursidentifiant) {

		//page affichée
		ModelAndView mav = new ModelAndView("parcoursdetail");

		//connexion a la BD
		DAO<CommentDatabase> commentaireDao = DAOFactory.getCommentDAO();
		//appel de la requete d insertion d un commentaire

		commentaireDao.deletecomment(Integer.parseInt(user_id),Integer.parseInt(parcoursidentifiant));
		commentaireDao.insertcommentaire( textarea,Integer.parseInt(user_id),Integer.parseInt(parcoursidentifiant));
		List<Comment> ret=new ArrayList();
		ret  = commentaireDao.findcomment(Integer.parseInt(user_id),Integer.parseInt(parcoursidentifiant));

		List<Parcourss> list = parcoursService.getparcours();
		
		mav.addObject("employee", new Employee());
		mav.addObject("nom", nom);
		mav.addObject("taille", taille);
		mav.addObject("difficulte", difficulte);
		mav.addObject("localisation", localisation);
		mav.addObject("parcoursidentifiant", parcoursidentifiant);
		mav.addObject("user_id", user_id);
		mav.addObject("textarea", textarea);
		mav.addObject("textareaNomodif", textareaNomodif);
		return mav;
	}
	@RequestMapping(value="/saveparcours", method=RequestMethod.POST)
	public ModelAndView saveparcours(@ModelAttribute("parcours") Parcourss parcoursObj,@RequestParam("user_id") String user_id) {
		ModelAndView mav = new ModelAndView("parcoursList");
		parcoursService.saveparcours(parcoursObj);
		List<Parcourss> list = parcoursService.getparcours();
		mav.addObject("user_id", user_id);
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

	@RequestMapping(value="/openParcoursRechercheView", method=RequestMethod.POST)
	public ModelAndView openrechercheParcoursView(@ModelAttribute("parcours") Parcourss parcoursObj,@RequestParam("user_id") String user_id) {

		ModelAndView mav = new ModelAndView("rechercheParcours");
		mav.addObject("parcours", new Parcourss());
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	//on a refuser la demande de pret de topo
	@RequestMapping(value="/topoDispoRefuse", method=RequestMethod.POST)
	public ModelAndView topoDispoRefuse(@RequestParam("user_id") String user_id,@RequestParam("identifiant") String identifiant) {

		//requete sql pour modifier la dispo car il a demande le pret du topo qui devient donc indispo
		DAO<CommentDatabase> commentaireDao = DAOFactory.getCommentDAO();
		commentaireDao.topoDispoRefuse(Integer.parseInt(identifiant),Integer.parseInt(user_id));
	
		//requete sql pour afficher la liste de tous les topos
		try {
            Class.forName("org.hibernate.jpa.HibernatePersistenceProvider");
        } catch (Exception e){
            e.printStackTrace();
        }
		Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
		  //On récupère un objet faisant le lien entre la base et nos objets 
		  DAO<TopoDatabase> topoDao = DAOFactory.getParcoursDAO();
		  ModelAndView mav = new ModelAndView("listopofromaccept");
		  mav.addObject("user_id",identifiant );
		  mav.addObject("identifiant", user_id);
		  List<Topo> list = new ArrayList(30);
          List<Topo> ret=new ArrayList();
		  //REQUETE SQL on recupere le resultat de la requete 
		  ret  = topoDao.listTopo(Integer.parseInt(user_id));

	    org.hibernate.jpa.HibernatePersistenceProvider entityManagerFactory =new  org.hibernate.jpa.HibernatePersistenceProvider();
	    entityManagerFactory.createEntityManagerFactory("Parcourss", System.getProperties());
	    mav.addObject("ret", ret);
			return mav;			
	}
	
     	//on a accepte de preter notre topo (bouton accepter)
		@RequestMapping(value="/acceptPretTopo", method=RequestMethod.POST)
		public ModelAndView acceptPretTopo(@RequestParam("user_id") String user_id,@RequestParam("identifiant") String identifiant) {

			//requete sql pour modifier la dispo on passe le champ dispo a PRETE
			DAO<CommentDatabase> pretDao = DAOFactory.getCommentDAO();
			pretDao.pretertopo(Integer.parseInt(identifiant),Integer.parseInt(user_id));
		
			//requete sql pour afficher la liste de tous les topos
			try {
	            Class.forName("org.hibernate.jpa.HibernatePersistenceProvider");
	        } catch (Exception e){
	            e.printStackTrace();
	        }
			Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
			  //On récupère un objet faisant le lien entre la base et nos objets 
			  DAO<TopoDatabase> topoDao = DAOFactory.getParcoursDAO();
			  ModelAndView mav = new ModelAndView("listopofromaccept");
			  mav.addObject("user_id",identifiant );
			  mav.addObject("identifiant", user_id);
			  List<Topo> list = new ArrayList(30);
	          List<Topo> ret=new ArrayList();
			  //REQUETE SQL on recupere le resultat de la requete 
			  ret  = topoDao.listTopo(Integer.parseInt(user_id));

		    org.hibernate.jpa.HibernatePersistenceProvider entityManagerFactory =new  org.hibernate.jpa.HibernatePersistenceProvider();
		    entityManagerFactory.createEntityManagerFactory("Parcourss", System.getProperties());
		    mav.addObject("ret", ret);
				return mav;			
		}
	
	
	
	
	//demande de pret de topo
	@RequestMapping(value="/openlistTopofromtopo", method=RequestMethod.POST)
	public ModelAndView openlistTopofromtopo(@RequestParam("user_id") String user_id,@RequestParam("identifiant") String identifiant) {
	       
		
		//requete sql pour modifier la dispo car il a demande le pret du topo qui devient donc indispo
		DAO<CommentDatabase> commentaireDao = DAOFactory.getCommentDAO();
		commentaireDao.modiftopoDispo(Integer.parseInt(identifiant),Integer.parseInt(user_id));

		
		//requete sql pour afficher la liste de tous les topos
		try {
            Class.forName("org.hibernate.jpa.HibernatePersistenceProvider");
        } catch (Exception e){
            e.printStackTrace();
        }
		Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
		  //On récupère un objet faisant le lien entre la base et nos objets 
		  DAO<TopoDatabase> topoDao = DAOFactory.getParcoursDAO();
		  ModelAndView mav = new ModelAndView("listopofromaccept");
		  mav.addObject("user_id",identifiant );
		  mav.addObject("identifiant", user_id);
		  List<Topo> list = new ArrayList(30);
          List<Topo> ret=new ArrayList();
		  //REQUETE SQL on recupere le resultat de la requete 
		  ret  = topoDao.listTopo(Integer.parseInt(user_id));


	    org.hibernate.jpa.HibernatePersistenceProvider entityManagerFactory =new  org.hibernate.jpa.HibernatePersistenceProvider();
	    entityManagerFactory.createEntityManagerFactory("Parcourss", System.getProperties());
	    mav.addObject("ret", ret);
			return mav;
			
	}
	@RequestMapping(value="/openlistTopo", method=RequestMethod.POST)
	public ModelAndView openlistTopo(@RequestParam("user_id") String user_id) {
	       
		try {
            Class.forName("org.hibernate.jpa.HibernatePersistenceProvider");
        } catch (Exception e){
            e.printStackTrace();
        }
		Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
		
		  //On récupère un objet faisant le lien entre la base et nos objets 
		  DAO<TopoDatabase> topoDao = DAOFactory.getParcoursDAO();
	  
		  ModelAndView mav = new ModelAndView("listopo");
		  mav.addObject("user_id", user_id);

		  List<Topo> list = new ArrayList(30);
          List<Topo> ret=new ArrayList();

		  //REQUETE SQL on recupere le resultat de la requete 
		  ret  = topoDao.listTopo(Integer.parseInt(user_id));


	    org.hibernate.jpa.HibernatePersistenceProvider entityManagerFactory =new  org.hibernate.jpa.HibernatePersistenceProvider();
	    entityManagerFactory.createEntityManagerFactory("Parcourss", System.getProperties());
	    mav.addObject("ret", ret);
            //mav.addObject("list", ret);
			return mav;
			
	}
	
	//09/06
	@RequestMapping(value="/insertTopoView", method=RequestMethod.POST)
	public ModelAndView insertTopoView(@RequestParam("textarea") String textarea,@RequestParam("user_id") String user_id,@RequestParam("identifiant") String identifiant) {
		//on insere le topo modifie dans la BD
		DAO<CommentDatabase> commentaireDao = DAOFactory.getCommentDAO();
		commentaireDao.insertopo(textarea,Integer.parseInt(user_id));
		
		//recuperation du topo perso de la personne connecte
		String[] tab = new String[7];
		DAO<CommentDatabase> commentaireDaoBis = DAOFactory.getCommentDAO();
		tab = commentaireDaoBis.recuptopo(Integer.parseInt(user_id));
		
		//recuperation des topos qui ont ete prete a la personne
		//On récupère un objet faisant le lien entre la base et nos objets 
		DAO<TopoDatabase> topoDao = DAOFactory.getParcoursDAO();
		List<Topo> list = new ArrayList(30);
        List<Topo> ret=new ArrayList();
		//REQUETE SQL on recupere le resultat de la requete 
		ret  = topoDao.listTopPrete(Integer.parseInt(user_id));
		
		ModelAndView mav = new ModelAndView("topo");
		mav.addObject("identifiant", identifiant);
		mav.addObject("textarea", tab[6]);
		mav.addObject("identifiantpret", tab[7]);
		mav.addObject("user_id", user_id);
		mav.addObject("ret", ret);
		return mav;
		
	}
	@RequestMapping(value="/openTopoView", method=RequestMethod.POST)
	public ModelAndView openTopoView(@ModelAttribute("parcours") Parcourss parcoursObj,@RequestParam("user_id") String user_id,@RequestParam("identifiant") String identifiant) {
		//recuperation du topo perso de la personne connecte
		String[] tab = new String[7];
		DAO<CommentDatabase> commentaireDao = DAOFactory.getCommentDAO();
		tab = commentaireDao.recuptopo(Integer.parseInt(user_id));
		
		//recuperation des topos qui ont ete prete a la personne
		//On récupère un objet faisant le lien entre la base et nos objets 
		DAO<TopoDatabase> topoDao = DAOFactory.getParcoursDAO();
		List<Topo> list = new ArrayList(30);
        List<Topo> ret=new ArrayList();
		//REQUETE SQL on recupere le resultat de la requete 
		ret  = topoDao.listTopPrete(Integer.parseInt(user_id));
		
		//affichage de la page jsp
		ModelAndView mav = new ModelAndView("topo");
		
		mav.addObject("identifiant", identifiant);
		mav.addObject("textarea", tab[6]);
		mav.addObject("dispoperso", tab[5]);
		mav.addObject("identifiantpret", tab[7]);
		mav.addObject("user_id", user_id);
		mav.addObject("ret", ret);
		return mav;
	}
	@RequestMapping(value="/openProfilView", method=RequestMethod.POST)
	public ModelAndView openProfilView(@ModelAttribute("parcours") Parcourss parcoursObj,@RequestParam("user_id") String user_id) {
		//on recupere le nom et le prenom de la personne pour les passer a la page
		//connexion a la BD
		String[] tab = new String[4];
		DAO<CommentDatabase> commentaireDao = DAOFactory.getCommentDAO();
		tab = commentaireDao.recupuser(Integer.parseInt(user_id));
	
		//requete pour recuperer le topo de l personne
		String[] tabtopo = new String[7];
		tabtopo = commentaireDao.recuptopo(Integer.parseInt(user_id));
		
		String identifiant;
		//on recupere les infos du demandeur
		if(tabtopo[5].equals("PRETE")) {
		    identifiant="0";
		}
		else {
			identifiant=tabtopo[7];
		}
		String[] tabdemandeur = new String[4];
		DAO<CommentDatabase> demandeur = DAOFactory.getCommentDAO();
		tabdemandeur = demandeur.recupuser(Integer.parseInt(identifiant));
		
		//affichage de la jsp
		ModelAndView mav = new ModelAndView("profil");
		
		//permet d afficher des variables a l interieur de la page
		mav.addObject("user_id", user_id);
		mav.addObject("nom", tab[1]);
		mav.addObject("prenom", tab[2]);
		mav.addObject("mail", tab[3]);
		mav.addObject("telephone", tab[4]);
		mav.addObject("identifiant", tabtopo[7]);
		mav.addObject("nomdemandeur", tabdemandeur[1]);
		mav.addObject("prenomdemandeur", tabdemandeur[2]);
		mav.addObject("maildemandeur", tabdemandeur[3]);
		
		return mav;
	}
	@RequestMapping(value="/resultatparcours", method=RequestMethod.POST)
	public ModelAndView resultatparcours(@ModelAttribute("parcours") Parcourss parcoursObj,@RequestParam("localisation") String localisation,@RequestParam("difficulte") String difficulte,@RequestParam("taille") String taille,@RequestParam("nom") String nom,@RequestParam("user_id") String user_id) {
	       
		try {
            Class.forName("org.hibernate.jpa.HibernatePersistenceProvider");
        } catch (Exception e){
            e.printStackTrace();
        }
		Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
		
		  //On récupère un objet faisant le lien entre la base et nos objets 
		  DAO<ParcoursDatabase> parcoursDao = DAOFactory.getParcoursDAO();
	  
		  ModelAndView mav = new ModelAndView("resultatparcours");
		  mav.addObject("user_id", user_id);
		  List<Parcourss> list = parcoursService.getparcours();  
          List<Parcourss> ret=new ArrayList();

		  //REQUETE SQL on recupere le resultat de la requete 
	      if(taille.equals("")) {taille="0";}
		  ret  = parcoursDao.findmultipleNoid(nom, localisation,Integer.parseInt(taille),Integer.parseInt(difficulte));
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
				}
		  for(int k=0;k<list.size();k++) {
			  if(list.get(k).gettaille() ==0)
				list.remove(k);
				
		  }

	/**********************************************************/	  
		  DAO<Eleve> eleveDao = DAOFactory.getEleveDAO();
		  for(int i = 1; i < 10; i++){
		    //On fait notre recherche
		    Eleve eleve = eleveDao.find(i);		  
		  }

	    org.hibernate.jpa.HibernatePersistenceProvider entityManagerFactory =new  org.hibernate.jpa.HibernatePersistenceProvider();
	    entityManagerFactory.createEntityManagerFactory("Parcourss", System.getProperties());

             mav.addObject("list", ret);
			return mav;
			
	}

}
