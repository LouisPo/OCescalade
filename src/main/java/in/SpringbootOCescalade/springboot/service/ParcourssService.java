package in.SpringbootOCescalade.springboot.service;

import java.util.List;

import in.SpringbootOCescalade.springboot.model.Parcourss;

public interface ParcourssService {
	
	List<Parcourss> getparcours();
	
	Parcourss getparcours(int id);
	
	void saveparcours(Parcourss parcours);
	
	void deleteparcours(int id);


}

