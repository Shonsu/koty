package pl.kobietydokodu.koty.service;

import java.util.List;
import java.util.Optional;

import pl.kobietydokodu.koty.domain.Cat;


public interface CatService {
	
	public Cat save(Cat entity);
	public Optional<Cat> findById(Long id);
	public List<Cat> findAll();
	public long count();
	public void delete(Cat kot);
	public boolean existsById(Long id);
}
