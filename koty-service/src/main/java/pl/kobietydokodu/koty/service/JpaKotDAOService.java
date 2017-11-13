package pl.kobietydokodu.koty.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.kobietydokodu.koty.dao.impl.JpaKotDAO;
import pl.kobietydokodu.koty.domain.Cat;

@Service
public class JpaKotDAOService {
	
	@Autowired
	//@Qualifier("jpaKotDAO")
	protected JpaKotDAO jpaKotDAO;

	public Cat save(Cat entity) {
		if (entity.isNew()) {
			return jpaKotDAO.add(entity);
		} else {
			return jpaKotDAO.edit(entity);
		}

	}

	public Optional<Cat> findById(Long id) {

		 return  Optional.of(jpaKotDAO.findById(id));
	}

	public List<Cat> findAll() {
		return jpaKotDAO.findAll();
	}

	public long count() {
		return 0;
	}

	public void delete(Cat entity) {
		jpaKotDAO.delete(entity);
	}

	public boolean existsById(Long id) {
		return jpaKotDAO.existsById(id);
	}
}
