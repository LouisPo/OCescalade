package in.SpringbootOCescalade.springboot.dao;

import java.util.List;

import in.SpringbootOCescalade.springboot.model.*;

public interface TopoDAO {
	
	List<Topo> get();
	
	Topo get(int id);
	
	void save(Topo topo);
	
	void inserttopo(String  textarea,Integer user,Integer parcoursidentifiant);

	void delete(int id);
}
