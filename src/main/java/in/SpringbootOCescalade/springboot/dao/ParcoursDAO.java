package in.SpringbootOCescalade.springboot.dao;

import java.util.List;

import in.SpringbootOCescalade.springboot.model.*;

public interface ParcoursDAO {
	
	List<Parcours> get();
	
	Parcours get(int id);
	
	void save(Parcours parcours);
	
	void delete(int id);
	
	
	
	
	
	
}
