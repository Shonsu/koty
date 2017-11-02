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
		entityManager.persist(kot);

		System.out.println("before flush: " + kot.getBirthDate());
		entityManager.flush();
		System.out.println("after flush: " + kot.getBirthDate());
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
		Query query = entityManager.createQuery("UPDATE koty.cat SET  birthDate = :birthDate, name = :name, owner = :owner, weight = :weight WHERE custId = :where_expression");
		//custId = :custId,	
		query.setParameter("birthDate", kot.getBirthDate());
		query.setParameter("name", kot.getName());
		query.setParameter("owner", kot.getOwner());
		query.setParameter("weight", kot.getWeight());
		query.executeUpdate();
		//entityManager.flush();

		

	}

	@Override
	public void delete(Long idKot) {
		Query query = entityManager.createQuery("DELETE FROM koty.cat WHERE custId=:id");
		query.setParameter("id", idKot).executeUpdate();
		
	}

}
