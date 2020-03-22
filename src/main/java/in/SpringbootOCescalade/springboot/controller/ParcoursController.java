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
	public ModelAndView resultatparcours(@ModelAttribute("parcours") Parcours parcoursObj,@RequestParam("localisation") String localisation,@RequestParam("nom") String nom) {
	//public ModelAndView resultatparcours(@ModelAttribute("parcours") Parcours parcoursObj) {
			ModelAndView mav = new ModelAndView("resultatparcours");
			System.out.println("localisation rentree vaut  "+localisation);

			List<Parcours> list = parcoursService.getparcours();
            System.out.println("taille  "+list.size());
           
            List<Parcours> ret=new ArrayList();
            //recherche par localisation et nom
            //localisation et nom rempli
			if( !  (localisation.equals("") && (nom.equals("") ))) {
            for(int i=0;i<list.size();i++) {
				if( (list.get(i).getlocalisation().equals(localisation))  &&  (list.get(i).getnom().equals(nom))  ) {
					System.out.println("you are not in "+localisation+list.get(i).getlocalisation()+"  "+list.get(i).getparcours_id());
					ret.add(list.get(i));
				}
				else
				{
					System.out.println("you are  in   "+localisation+list.get(i).getlocalisation()+"  "+list.get(i).getparcours_id());
				}

			}
			}
			
			
			//recherche par localisation
			//nom vide et localisaton rempli
			if( (!(localisation.equals("")) && (nom.equals("") ))) {
	            for(int i=0;i<list.size();i++) {
					if( (list.get(i).getlocalisation().equals(localisation))  ) {
						System.out.println("you are not in "+localisation+list.get(i).getlocalisation()+"  "+list.get(i).getparcours_id());
						ret.add(list.get(i));
					}
					else
					{
						System.out.println("you are  in   "+localisation+list.get(i).getlocalisation()+"  "+list.get(i).getparcours_id());
					}

				}
				}
			//recherche par nom
			//localisation vide et nom rempli
			if( (!(nom.equals("")) && (localisation.equals("") ))) {
	            for(int i=0;i<list.size();i++) {
					if( (list.get(i).getnom().equals(nom))  ) {
						ret.add(list.get(i));
					}
					else
					{
	
					}

				}
				}
			
			
			mav.addObject("list", ret);
			
			return mav;
			
	}

}
