package in.SpringbootOCescalade.springboot.dao;

import java.util.List;

import in.SpringbootOCescalade.springboot.model.*;
import in.SpringbootOCescalade.springboot.model.ParcoursRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParcoursDAO  {
	
	List<Parcourss> get();
	
	Parcourss get(int id);
	
	void save(Parcourss parcours);
	
	void delete(int id);
	
	
	
	
	
	
}
