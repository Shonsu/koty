package pl.kobietydokodu.koty.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pl.kobietydokodu.koty.dao.CatService;
import pl.kobietydokodu.koty.domain.Cat;

@Repository
@Qualifier("jpaKotDAOBean")
public class JpaKotDAO implements CatService {

	@PersistenceContext
    private EntityManager entityManager;
    

	
	@Override
	public void add(Cat kot) {
		entityManager.persist(kot);
	}

	@Override
	public List<Cat> findAll() {
		
		Query query = entityManager.createQuery("SELECT k FROM Cat k");
		@SuppressWarnings("unchecked")
		List<Cat> koty = (List<Cat>) query.getResultList();
		
		return koty;
	}

	@Override
	public Cat findById(Integer id) {
		
		Query query = entityManager.createQuery("SELECT k FROM Cat k WHERE k.custId = :id");
		query.setParameter("id", Long.valueOf(id));
		Cat kot = (Cat) query.getSingleResult();
		
		return kot;
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
