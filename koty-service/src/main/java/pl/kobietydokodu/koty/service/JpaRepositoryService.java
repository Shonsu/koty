package pl.kobietydokodu.koty.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.kobietydokodu.koty.dao.CatRepository;
import pl.kobietydokodu.koty.domain.Cat;

@Service
public class JpaRepositoryService {

	@Autowired
	protected CatRepository catRpository;
	
	@Transactional
	public Cat save(Cat entity) {
		//Cat c = catRpository.save(entity);
		//System.out.printf("Cat ID is %d and for returned account ID is %d\n", entity.getCustId(), c.getCustId());
		return catRpository.save(entity);
	}
	
	@Transactional
	public Optional<Cat> findById(Long id) {
		return catRpository.findById(id);
	}
	
	@Transactional
	public List<Cat> findAll() {
		return catRpository.findAll();
	}
	
	@Transactional
	public long count() {
		return catRpository.count();
	}
	
	@Transactional
	public void delete(Cat entity) {
		catRpository.delete(entity);
	}
	
	@Transactional
	public boolean existsById(Long id) {
		return catRpository.existsById(id);
	}

}
