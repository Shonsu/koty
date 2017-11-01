package pl.kobietydokodu.koty.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.kobietydokodu.koty.dao.CatService;
import pl.kobietydokodu.koty.domain.Cat;

@Repository
public class SimpleKotDAO implements CatService{

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
	public void edit(Long idKot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long idKot) {
		// TODO Auto-generated method stub
		
	}
}
