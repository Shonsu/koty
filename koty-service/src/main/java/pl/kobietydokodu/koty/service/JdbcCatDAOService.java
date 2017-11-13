package pl.kobietydokodu.koty.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pl.kobietydokodu.koty.dao.impl.JdbcCatDAO;
import pl.kobietydokodu.koty.domain.Cat;

@Service
@Qualifier("JdbcCatDAOService")
public class JdbcCatDAOService implements CatService{
	
	@Autowired
	JdbcCatDAO jdbcCatDAO;
	
	public Cat save(Cat entity) {
		if (entity.isNew()) {
			return jdbcCatDAO.add(entity);
		} else {
			return jdbcCatDAO.edit(entity);
		}
	}

	public Optional<Cat> findById(Long id) {

		 return  Optional.of(jdbcCatDAO.findById(id));
	}

	public List<Cat> findAll() {
		return jdbcCatDAO.findAll();
	}

	public long count() {
		return 0;
	}

	public void delete(Cat entity) {
		jdbcCatDAO.delete(entity);
	}

	public boolean existsById(Long id) {
		return jdbcCatDAO.existsById(id);
	}
	
}
