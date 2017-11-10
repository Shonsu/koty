package pl.kobietydokodu.koty.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import pl.kobietydokodu.koty.dao.impl.JpaKotDAO;
import pl.kobietydokodu.koty.domain.Cat;

public class JpaKotDAOService {
	@Autowired
	protected JpaKotDAO jpaKotDAO;

	public Cat save(Cat entity) {
		if (entity.isNew()) {
			return jpaKotDAO.add(entity);
		} else {
			return jpaKotDAO.edit(entity);
		}

	}

	public Optional<Cat> findById(Long id) {

		 Cat c = jpaKotDAO.findById(id);
		
		 Optional.of(c); //testowanie
		 return null;
	}

	public List<Cat> findAll() {
		return jpaKotDAO.findAll();
	}

	public long count() {
		return 0;
	}

	public void delete(Cat entity) {
		//jpaKotDAO.delete(entity);
	}

	public boolean existsById(Long id) {
		//return jpaKotDAO.existsById(id);
		return false;
	}
}
