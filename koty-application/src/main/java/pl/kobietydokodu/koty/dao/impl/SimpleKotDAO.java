package pl.kobietydokodu.koty.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.kobietydokodu.koty.dao.CatDAO;
import pl.kobietydokodu.koty.domain.Cat;

@Repository
public class SimpleKotDAO implements CatDAO{

	List<Cat> koty = new ArrayList<Cat>();
	
	public void add(Cat kot) {
		koty.add(kot);
	}
	
	public List<Cat> findAll() {
		return koty;
	}
	
	public Cat findById(Integer id) {
		if (id<koty.size()) {
			return koty.get(id);
		} else {
			return null;
		}
	}

	@Override
	public void edit(Cat kot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long idKot) {
		// TODO Auto-generated method stub
		
	}
}
