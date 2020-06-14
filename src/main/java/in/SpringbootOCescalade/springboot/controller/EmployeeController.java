package in.SpringbootOCescalade.springboot.controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.SpringbootOCescalade.springboot.dao.DAO;
import in.SpringbootOCescalade.springboot.dao.DAOFactory;
import in.SpringbootOCescalade.springboot.model.Employee;
import in.SpringbootOCescalade.springboot.model.ParcoursDatabase;
import in.SpringbootOCescalade.springboot.model.Parcourss;
import in.SpringbootOCescalade.springboot.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	public EmployeeService employeeService;
	
	//modification page accueil du site

	
	//new
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView openAccueilView() {
		ModelAndView mav = new ModelAndView("accueil");
		return mav;
	}
	//new
	@RequestMapping("/openConnexionView")
	public ModelAndView openConnexionView() {
		ModelAndView mav = new ModelAndView("connexion");
		mav.addObject("employee", new Employee());
		return mav;
	}
	@RequestMapping("/openConnexionOKView")
	public ModelAndView openConnexionOKView() {
		ModelAndView mav = new ModelAndView("connexionok");
		mav.addObject("employee", new Employee());
		return mav;
	}
	//new
	@RequestMapping(value="/resultatconnexion", method=RequestMethod.POST)
	public ModelAndView resultatconnexion(@ModelAttribute("employee") Parcourss parcoursObj,@RequestParam("nom") String nom,@RequestParam("mdp") String password) {
		
		  //On récupère un objet faisant le lien entre la base et nos objets 
		  DAO<ParcoursDatabase> employeeDao = DAOFactory.getEmployeeDAO();
		  //ModelAndView mav = new ModelAndView("connexionok");
		  //ModelAndView mav = new ModelAndView("employeesList");
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
				System.out.println(" noms : "+ret.get(i).getnom()+" password : "+ret.get(i).getmdp());
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
			  mav = new ModelAndView("connexionok");
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
	
	
	
	
	
	@RequestMapping("/openEmployeeView")
	public ModelAndView openEmployeeAddView() {
		ModelAndView mav = new ModelAndView("employeesAdd");
		mav.addObject("employee", new Employee());
		return mav;
	}
	
	@RequestMapping("/save")
	public ModelAndView save(@ModelAttribute("employee") Employee employeeObj) {
		ModelAndView mav = new ModelAndView("employeesList");
		employeeService.save(employeeObj);
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
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("employeesList");
		employeeService.delete(id);
		List<Employee> list = employeeService.get();
		mav.addObject("list", list);
		return mav;
	}
}
