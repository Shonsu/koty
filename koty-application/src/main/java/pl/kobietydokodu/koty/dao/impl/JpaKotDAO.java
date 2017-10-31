package pl.kobietydokodu.koty.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pl.kobietydokodu.koty.dao.KotDAO;
import pl.kobietydokodu.koty.domain.Kot;

@Repository
@Qualifier("jpaKotDAOBean")
public class JpaKotDAO implements KotDAO {

	@PersistenceContext
    private EntityManager entityManager;
    

	
	@Override
	public void dodajKota(Kot kot) {
		entityManager.persist(kot);
	}

	@Override
	public List<Kot> getKoty() {
		
		Query query = entityManager.createQuery("SELECT k FROM Kot k");
		@SuppressWarnings("unchecked")
		List<Kot> koty = (List<Kot>) query.getResultList();
		
		return koty;
	}

	@Override
	public Kot getKotById(Integer id) {
		
		Query query = entityManager.createQuery("SELECT k FROM Kot k WHERE k.custId = :id");
		query.setParameter("id", Long.valueOf(id));
		Kot kot = (Kot) query.getSingleResult();
		
		return kot;
	}

	@Override
	public void edytujKota(Long idKot) {
		// TODO Auto-generated method stub

	}

}
