package pl.kobietydokodu.koty.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.kobietydokodu.koty.dao.impl.JpaKotDAO;
import pl.kobietydokodu.koty.domain.Cat;

@Service
@Qualifier("JpaKotDAOService")
public class JpaKotDAOService implements CatService{
	
	@Autowired
	//@Qualifier("jpaKotDAO")
	protected JpaKotDAO jpaKotDAO;

	@Transactional 
	public Cat save(Cat entity) {
		if (entity.isNew()) {
			return jpaKotDAO.add(entity);
		} else {
			return jpaKotDAO.edit(entity);
		}

	}
	
	@Transactional
	public Optional<Cat> findById(Long id) {

		 return  Optional.of(jpaKotDAO.findById(id));
	}

	@Transactional
	public List<Cat> findAll() {
		return jpaKotDAO.findAll();
	}

	@Transactional
	public long count() {
		return 0;
	}

	@Transactional
	public void delete(Cat entity) {
		jpaKotDAO.delete(entity);
	}

	@Transactional
	public boolean existsById(Long id) {
		return jpaKotDAO.existsById(id);
	}
}
