package pl.kobietydokodu.koty.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pl.kobietydokodu.koty.dao.KotDAO;
import pl.kobietydokodu.koty.domain.Kot;

@Repository
@Qualifier("jpaKorDAOBean")
public class JpaKotDAO implements KotDAO {

	@PersistenceContext
    private EntityManager entityManager;
    

	
	@Override
	public void dodajKota(Kot kot) {
		entityManager.persist(kot);
	}

	@Override
	public List<Kot> getKoty() {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public Kot getKotById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void edytujKota(Long idKot) {
		// TODO Auto-generated method stub

	}

}
