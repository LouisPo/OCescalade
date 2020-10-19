package in.SpringbootOCescalade.springboot.dao;

import java.util.List;

import in.SpringbootOCescalade.springboot.model.*;

public interface TopoDAO {
	
	List<Topo> get();
	
	Topo get(int id);
	
	void save(Topo topo);
	
	void inserttopo(String  textarea,Integer user,Integer parcoursidentifiant,String lieu,String datedecreation);

	void delete(int id);

	void inserttopo(String textarea, Integer user, Integer parcoursidentifiant);
}
