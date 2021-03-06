package in.SpringbootOCescalade.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.SpringbootOCescalade.springboot.dao.*;
import in.SpringbootOCescalade.springboot.model.*;

@Service
public class ParcoursServiceImpl implements ParcoursService {

	@Autowired
	private ParcoursDAO parcoursDAO;
	
	@Transactional
	@Override
	public List<Parcours> getparcours() {
		return parcoursDAO.get();
	}

	@Transactional
	@Override
	public Parcours getparcours(int id) { 
		return parcoursDAO.get(id);
	}

	@Transactional
	@Override
	public void saveparcours(Parcours parcours) {
		parcoursDAO.save(parcours);
	}

	@Transactional
	@Override
	public void deleteparcours(int id) {
		parcoursDAO.delete(id);
	}


}
