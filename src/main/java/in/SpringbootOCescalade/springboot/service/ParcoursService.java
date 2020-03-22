package in.SpringbootOCescalade.springboot.service;

import java.util.List;

import in.SpringbootOCescalade.springboot.model.*;

public interface ParcoursService {
	List<Parcours> getparcours();
	
	Parcours getparcours(int id);
	
	void saveparcours(Parcours parcours);
	
	void deleteparcours(int id);
	
	//List<Parcours> rechercheparcours(String localisation);
	//List<Parcours> getparcourslocalisation(String localisation);

}
