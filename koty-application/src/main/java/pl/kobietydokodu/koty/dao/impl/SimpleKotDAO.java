package pl.kobietydokodu.koty.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import pl.kobietydokodu.koty.domain.Cat;
import static java.lang.Math.toIntExact;

@Repository
@Qualifier("simpleKotDAOBean")
public class SimpleKotDAO{

	List<Cat> koty = new ArrayList<Cat>();
	
	public Cat add(Cat kot) {
		koty.add(kot);
		return kot;
	}
	
	public List<Cat> findAll() {
		return koty;
	}
	
	public Cat findById(Long id) {
		if (id<koty.size()) {
			return koty.get(toIntExact(id));
		} else {
			return null;
		}
	}

	public Cat edit(Cat kot) {
		return kot;
		// TODO Auto-generated method stub
		
	}

	public void delete(Cat kot) {
		// TODO Auto-generated method stub
		
	}
}
