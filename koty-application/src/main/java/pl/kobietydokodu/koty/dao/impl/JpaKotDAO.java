package pl.kobietydokodu.koty.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import pl.kobietydokodu.koty.dao.CatDAO;
import pl.kobietydokodu.koty.domain.Cat;

@Repository
@Qualifier("jpaKotDAOBean")
public class JpaKotDAO implements CatDAO {

	@PersistenceContext
    private EntityManager entityManager;
    

	
	@Override
	public void add(Cat kot) {
		System.out.println("add query");
		entityManager.persist(kot);
		entityManager.flush();
	}

	@Override
	public List<Cat> findAll() {
		
		Query query = entityManager.createQuery("SELECT k FROM Cat k");
		@SuppressWarnings("unchecked")
		List<Cat> koty = (List<Cat>) query.getResultList();
		
		return koty;
	}

	@Override
	public Cat findById(Long id) {
		
		Query query = entityManager.createQuery("SELECT k FROM Cat k WHERE k.custId = :id");
		query.setParameter("id", id);
		Cat kot = null;
		try {
			kot = (Cat) query.getSingleResult();
		} catch (Exception e) {
			return kot;
		}
		
		return kot;
	}

	@Override
	public void edit(Cat kot) {
		Query query = entityManager.createQuery("UPDATE Cat SET  custId = :custId, birthDate = :birthDate, name = :name, owner = :owner, weight = :weight WHERE custId = :custId");

		query.setParameter("custId", kot.getCustId());
		query.setParameter("birthDate", kot.getBirthDate());
		query.setParameter("name", kot.getName());
		query.setParameter("owner", kot.getOwner());
		query.setParameter("weight", kot.getWeight());
		query.executeUpdate();
		//entityManager.flush();

		

	}

	@Override
	public void delete(Long idKot) {
		Query query = entityManager.createQuery("DELETE FROM Cat k WHERE k.custId=:id");
		query.setParameter("id", idKot).executeUpdate();
		
	}

}
