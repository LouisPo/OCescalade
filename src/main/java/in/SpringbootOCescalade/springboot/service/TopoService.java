package in.SpringbootOCescalade.springboot.service;

import java.util.List;

import in.SpringbootOCescalade.springboot.model.*;

public interface TopoService {
	List<Topo> get();
	
	Topo get(int id);
	
	void save(Topo commentaire);
	void inserttopo(String  textarea,Integer user);
	void delete(int id);
	List<Topo> findtopo(int user);
}
