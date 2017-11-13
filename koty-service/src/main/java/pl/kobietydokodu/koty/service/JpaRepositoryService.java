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
	protected CatRepository catRepository;
	
	@Transactional
	public Cat save(Cat entity) {
		return catRepository.save(entity);
	}
	
	@Transactional
	public Optional<Cat> findById(Long id) {
		return catRepository.findById(id);
	}
	
	@Transactional
	public List<Cat> findAll() {
		return catRepository.findAll();
	}
	
	@Transactional
	public long count() {
		return catRepository.count();
	}
	
	@Transactional
	public void delete(Cat entity) {
		catRepository.delete(entity);
	}
	
	@Transactional
	public boolean existsById(Long id) {
		return catRepository.existsById(id);
	}

}
