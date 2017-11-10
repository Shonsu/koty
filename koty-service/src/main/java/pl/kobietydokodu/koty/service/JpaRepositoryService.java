package pl.kobietydokodu.koty.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import pl.kobietydokodu.koty.dao.CatRepository;
import pl.kobietydokodu.koty.domain.Cat;

public class JpaRepositoryService {

	@Autowired
	protected CatRepository catRpository;

	public Cat save(Cat entity) {

		return catRpository.save(entity);

	}

	public Optional<Cat> findById(Long id) {

		return catRpository.findById(id);

	}

	public List<Cat> findAll() {
		return catRpository.findAll();
	}

	public long count() {
		return catRpository.count();
	}

	public void delete(Cat entity) {
		catRpository.delete(entity);
	}

	public boolean existsById(Long id) {
		return catRpository.existsById(id);
	}

}
