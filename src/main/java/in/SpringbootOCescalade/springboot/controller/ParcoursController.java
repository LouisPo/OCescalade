package in.SpringbootOCescalade.springboot.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import in.SpringbootOCescalade.springboot.model.Parcours;
import in.SpringbootOCescalade.springboot.service.ParcoursService;

@Controller
public class ParcoursController {
	
	@Autowired
	private ParcoursService parcoursService;
		
	@RequestMapping(value = {"////", "/home2", "/index2"})
	public ModelAndView getparcours() {
		ModelAndView mav2 = new ModelAndView("parcoursList");
		List<Parcours> list = parcoursService.getparcours();
		mav2.addObject("list", list);
		return mav2;
	}
	
	@RequestMapping("/openParcoursView")
	public ModelAndView openParcoursAddView() {
		ModelAndView mav = new ModelAndView("parcoursAdd");
		mav.addObject("parcours", new Parcours());
		return mav;
	}
	
	@RequestMapping("/saveparcours")
	public ModelAndView saveparcours(@ModelAttribute("parcours") Parcours parcoursObj) {
		ModelAndView mav = new ModelAndView("parcoursList");
		parcoursService.saveparcours(parcoursObj);
		List<Parcours> list = parcoursService.getparcours();
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/parcours/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("parcoursAdd");
		Parcours parcoursObj = parcoursService.getparcours(id);
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
		List<Parcours> list = parcoursService.getparcours();
		mav.addObject("list", list);
		return mav;
		
		
	}
	
	@RequestMapping("/openParcoursRechercheView")
	public ModelAndView openrechercheParcoursView() {
		ModelAndView mav = new ModelAndView("rechercheParcours");
		mav.addObject("parcours", new Parcours());
		return mav;
	}

	
	//@RequestMapping(value="/forgotpassword", method=RequestMethod.POST)
	//public String recoverPass(@RequestParam("j_username") String username) {
	    //do smthin
	//}
	
	

	//@RequestMapping("/resultatparcours")
	@RequestMapping(value="/resultatparcours", method=RequestMethod.POST)
	public ModelAndView resultatparcours(@ModelAttribute("parcours") Parcours parcoursObj,@RequestParam("localisation") String localisation,@RequestParam("difficulte") String difficulte,@RequestParam("taille") String taille,@RequestParam("nom") String nom) {
	//public ModelAndView resultatparcours(@ModelAttribute("parcours") Parcours parcoursObj) {
			ModelAndView mav = new ModelAndView("resultatparcours");

			List<Parcours> list = parcoursService.getparcours();
            //System.out.println("taille  "+list.size());
           
            List<Parcours> ret=new ArrayList();
            
			//recherche par nom uniquement les autres champs vides
			if( (!(nom.equals("")) && (localisation.equals("") ))) { System.out.println("AAAAAAA");
	            for(int i=0;i<list.size();i++) {
					if( (list.get(i).getnom().equals(nom))  ) {
						ret.add(list.get(i));
					}
				}
			}
			//recherche par taille uniquement (tous les autres champs vides)
			if( (!(taille.equals(""))&& (difficulte.equals(""))&& (localisation.equals("")) && (nom.equals("") ))) {System.out.println("BBBBBBBB");
	            for(int i=0;i<list.size();i++) {
					if( (list.get(i).gettaille().equals(Integer.parseInt(taille)))  ) {
						ret.add(list.get(i));
					}
				}
			}
			//recherche par difficulte uniquement (tous les autres champs vides)
			if( (!(difficulte.equals("")) && (localisation.equals(""))&& (taille.equals(""))  && (nom.equals("") ))) {System.out.println("CCCCCC");
	            for(int i=0;i<list.size();i++) {
					if( (list.get(i).getdifficulte().equals(Integer.parseInt(difficulte)))  ) {
						ret.add(list.get(i));
					}
				}
			}
			//recherche par localisation uniquement (tous les autres champs vides=
			if( (!(localisation.equals(""))&& (difficulte.equals(""))&& (taille.equals("")) && (nom.equals("") ))) {System.out.println("DDDDDD");
	            for(int i=0;i<list.size();i++) {
					if( (list.get(i).getlocalisation().equals(localisation))  ) {
						ret.add(list.get(i));
					}
				}
			}
			
			
         
            //recherche par nom et  taille 
			if( (!(nom.equals("")) && (!(taille.equals("")))&& (difficulte.equals(""))  && (localisation.equals("") ))) {System.out.println("EEEEEE");
				System.out.println("toto taille "+taille+" nom   "+nom);
            for(int i=0;i<list.size();i++) {
            	
            	
				if( (list.get(i).gettaille().equals(Integer.parseInt(taille)))  &&  (list.get(i).getnom().equals(nom))  ) {
					System.out.println("test de la taille "+list.get(i).gettaille().equals(Integer.parseInt(taille))+" test du nom "+list.get(i).getnom().equals(nom));
					ret.add(list.get(i));
				}
			

			}
			}

			
            //recherche par difficulte et localisation OKKKKKKKKKKK
			if(   (!(localisation.equals("")) && (!(difficulte.equals("") )))&& (taille.equals("")) && (nom.equals(""))) {System.out.println("FFFFFFF");
				
            for(int i=0;i<list.size();i++) {
				if( list.get(i).getlocalisation().equals(localisation) ) {
					
					if( list.get(i).getdifficulte().equals(Integer.parseInt(difficulte)) ) {
					
					ret.add(list.get(i));
				}
			}
			}
			}
			
            //recherche par nom et localisation 
            //localisation et nom rempli
			if( !  (localisation.equals("") && (nom.equals("") ))) {
            for(int i=0;i<list.size();i++) {
				if( (list.get(i).getlocalisation().equals(localisation))  &&  (list.get(i).getnom().equals(nom))  ) {
					ret.add(list.get(i));
				}
			}
			}
			

			

			
			
			mav.addObject("list", ret);
			
			return mav;
			
	}

}
