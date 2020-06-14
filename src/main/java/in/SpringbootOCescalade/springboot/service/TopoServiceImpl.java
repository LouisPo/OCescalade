package in.SpringbootOCescalade.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.SpringbootOCescalade.springboot.dao.*;
import in.SpringbootOCescalade.springboot.model.*;

@Service
public class TopoServiceImpl implements TopoService {

	@Autowired
	private TopoDAO TopoDAO;
	
	@Transactional
	@Override
	public List<Topo> get() {
		return TopoDAO.get();
	}

	@Transactional
	@Override
	public Topo get(int id) {
		return TopoDAO.get(id);
	}

	@Transactional
	@Override
	public void save(Topo topo) {
		TopoDAO.save(topo);
	}

	@Transactional
	@Override
	public void delete(int id) {
		TopoDAO.delete(id);
	}

	@Override
	public void inserttopo(String textarea, Integer user) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<Topo> findtopo(int user) {
		// TODO Auto-generated method stub
		return null;
	}

}
