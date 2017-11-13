package pl.kobietydokodu.koty.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import pl.kobietydokodu.koty.domain.Cat;

@Repository
@Qualifier("jpaKotDAO")
public class JpaKotDAO	{

	@PersistenceContext
    private EntityManager entityManager;
	
	public Cat add(Cat kot) {
		 entityManager.persist(kot);
		return kot;
	}

	public List<Cat> findAll() {
		
		Query query = entityManager.createQuery("SELECT k FROM Cat k");
		@SuppressWarnings("unchecked")
		List<Cat> koty = (List<Cat>) query.getResultList();
		return koty;
	}

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

	public Cat edit(Cat kot) {
		Query query = entityManager.createQuery("UPDATE Cat SET  custId = :custId, birthDate = :birthDate, name = :name, owner = :owner, weight = :weight, sex = :sex, coloring = :coloring WHERE custId = :custId");

		query.setParameter("custId", kot.getCustId());
		query.setParameter("birthDate", kot.getBirthDate());
		query.setParameter("name", kot.getName());
		query.setParameter("owner", kot.getOwner());
		query.setParameter("weight", kot.getWeight());
		query.setParameter("sex", kot.getSex());
		query.setParameter("coloring", kot.getColoring());
		query.executeUpdate();
		return kot;
		

	}

	public void delete(Cat kot) {
		
		Query query = entityManager.createQuery("DELETE FROM Cat k WHERE k.custId=:id");
		query.setParameter("id", kot.getCustId()).executeUpdate();
	}
	
	public boolean existsById(Long id) {
		
		Query query = entityManager.createQuery("SELECT COUNT(b.id) FROM Cat b WHERE b.custId=:custId");
		query.setParameter("custId", id);
		Long count = (Long) query.getSingleResult();
		
		return count<1?false:true;
	}



}
