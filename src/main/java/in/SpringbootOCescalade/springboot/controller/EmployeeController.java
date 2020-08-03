package in.SpringbootOCescalade.springboot.controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import in.SpringbootOCescalade.springboot.dao.DAO;
import in.SpringbootOCescalade.springboot.dao.DAOFactory;
import in.SpringbootOCescalade.springboot.model.CommentDatabase;
import in.SpringbootOCescalade.springboot.model.Employee;
import in.SpringbootOCescalade.springboot.model.ParcoursDatabase;
import in.SpringbootOCescalade.springboot.model.Parcourss;
import in.SpringbootOCescalade.springboot.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Controller
public class EmployeeController {
	
	@Autowired
	public EmployeeService employeeService;

	@RequestMapping(value = {"/", "/homeOcescalade", "/index"})
	public ModelAndView openLoginView() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	@RequestMapping("/DeconnexionView")
	public ModelAndView DeconnexionView() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	//new
	@RequestMapping("/openConnexionView")
	public ModelAndView openConnexionView() {
		ModelAndView mav = new ModelAndView("connexion");
		mav.addObject("employee", new Employee());
		return mav;
	}
	@RequestMapping("/openAccueilView")
	public ModelAndView openAccueilView() {
		ModelAndView mav = new ModelAndView("accueil");
		mav.addObject("employee", new Employee());
		return mav;
	}
	
	@RequestMapping(value="/openAccueilViewFrom", method=RequestMethod.POST)
	public ModelAndView openAccueilViewFrom(@RequestParam("user_id") String user_id) {
	
	String[] tabdemandeur = new String[4];
	DAO<CommentDatabase> demandeur = DAOFactory.getCommentDAO();
	tabdemandeur = demandeur.recupuser(Integer.parseInt(user_id));	
	String prenommFirst =tabdemandeur[2].substring(0,2); 	
		
	ModelAndView mav = new ModelAndView("accueil");
		mav.addObject("user_id", user_id);
		mav.addObject( "admin", prenommFirst );
		mav.addObject("employee", new Employee());
		return mav;
	}
	//new
	@RequestMapping(value="/resultatconnexion", method=RequestMethod.POST)
	public ModelAndView resultatconnexion(@ModelAttribute("employee") Parcourss parcoursObj,@RequestParam("nom") String nom,@RequestParam("mdp") String password) {
		
		  //On récupère un objet faisant le lien entre la base et nos objets 
		  DAO<ParcoursDatabase> employeeDao = DAOFactory.getEmployeeDAO();
		 
		  List<Employee> list = employeeService.get();  
		  List<Employee> ret=new ArrayList();
		  //REQUETE SQL on recupere le resultat de la requete 
		  ret  = employeeDao.findconnexion(nom, password);
		  //System.out.println("taille de ret RRREEETT"+ret.size());
          //vidage de list
		  for(int j=0;j<list.size();j++) {
				list.get(j).setnom("");
				list.get(j).setmdp("");	
				}
         //remplissage avec resultat de la requete SQL
		  for(int i=0;i<ret.size();i++) {
				list.get(i).setnom(ret.get(i).getnom());
				list.get(i).setmdp(ret.get(i).getmdp());

				System.out.println(" noms : "+ret.get(i).getnom()+" password : "+ret.get(i).getmdp()+" indice : "+i+" prenom : "+ret.get(i).getprenom());
				}
		  ModelAndView mav = new ModelAndView("connexion");
		  //il a rentre des mauvaises informations
		  if(ret.size()==0) {
			  mav = new ModelAndView("connexion");
			  mav.addObject("employee", new Employee());
			  mav.addObject( "message", "le user pass word est incorrect" );
		  }
		  //il a rentre un bon user et un bon password
		  else {
			  String prenomm =ret.get(0).getprenom() ;
			  String prenommFirst="";
			  if(!(prenomm.equals(""))) {
				     prenommFirst =prenomm.substring(0,2); 
			  }		  
			  mav = new ModelAndView("accueil");
			  mav.addObject( "admin", prenommFirst );
			  mav.addObject("user_id", ret.get(0).getuser_id());
		  }
		  
		  if(ret.get(0).getmail().equals("probleme_user") ) {
			  mav = new ModelAndView("connexion");
			  mav.addObject("employee", new Employee());
			  mav.addObject( "message", "le user  est incorrect" );
		  } 
		  if(ret.get(0).getmail().equals("probleme_mdp") ) {
			  mav = new ModelAndView("connexion");
			  mav.addObject("employee", new Employee());
			  mav.addObject( "message", "le mot de passe  est incorrect" );
		  } 
		 
		  for(int k=0;k<list.size();k++) {
			  //if(list.get(k).gettaille() ==0)
				list.remove(k);
				
		  }
  
		  
        mav.addObject("list", ret);
		return mav;
	}
	
	@RequestMapping(value="/openEmployeeView", method=RequestMethod.POST)
	public ModelAndView openEmployeeView(@RequestParam("user_id") String user_id) {

		ModelAndView mav = new ModelAndView("employeesAdd");
		mav.addObject("employee", new Employee());
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("employee") Employee employeeObj,@RequestParam("user_id") String user_id) {
	//@RequestMapping("/save")
	//spublic ModelAndView save(@ModelAttribute("employee") Employee employeeObj) {
		ModelAndView mav = new ModelAndView("employeesList");
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = employeeObj.getmdp();
		String encodedPassword = passwordEncoder.encode(password);
		
		employeeObj.setmdp(encodedPassword);
		employeeService.save(employeeObj);
		List<Employee> list = employeeService.get();
		mav.addObject("list", list);
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	@RequestMapping(value="/listinscrit", method=RequestMethod.POST)
	public ModelAndView listinscrit(@RequestParam("user_id") String user_id) {

		ModelAndView mav = new ModelAndView("employeesList");
		mav.addObject("user_id", user_id);
		List<Employee> list = employeeService.get();
		mav.addObject("list", list);
		return mav;
	}
	@RequestMapping("/employee/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("employeesAdd");
		Employee employeeObj = employeeService.get(id);
		if(employeeObj == null) {
			throw new RuntimeException("Employee not found"+id);
		}
		mav.addObject("employee", employeeObj);
		return mav;
	}
	
	
	
	@RequestMapping(value="/becomAdmin", method=RequestMethod.GET)
	public ModelAndView becomAdmin(HttpServletRequest request,@RequestParam("user_id") String user_id,@RequestParam("identifiant") String identifiant) throws ServletRequestBindingException {
        //recuperation des parametres http
        user_id = ServletRequestUtils.getStringParameter(request, "user_id");
        identifiant = ServletRequestUtils.getStringParameter(request, "identifiant");

        //
        String[] tabdemandeur = new String[4];
    	DAO<CommentDatabase> demandeur = DAOFactory.getCommentDAO();
    	//requete recupuser bdd pour recperer toutes les infos de la personne
    	tabdemandeur = demandeur.recupuser(Integer.parseInt(user_id));	
    	//on extrait les 2 premiers caractere du prenom
    	String prenommFirst =tabdemandeur[2].substring(0,2); 
        System.out.println("VAUTTTT"+tabdemandeur[2]);
        System.out.println("VAUXXXXX"+prenommFirst);

        
		//connexion a la BD
		DAO<CommentDatabase> commentaireDao = DAOFactory.getCommentDAO();
		commentaireDao.changetoadmin(Integer.parseInt(identifiant));
		//page affichee
		ModelAndView mav = new ModelAndView("employeesList");
		employeeService.changetoadmin(Integer.parseInt(identifiant));
		List<Employee> list = employeeService.get();
		mav.addObject("list", list);
		mav.addObject("user_id", user_id);
		mav.addObject("admin", prenommFirst);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("employeesList");
		employeeService.delete(id);
		List<Employee> list = employeeService.get();
		mav.addObject("list", list);
		return mav;
	}
}
