package pl.kobietydokodu.koty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.kobietydokodu.koty.dao.KotDAO;
import pl.kobietydokodu.koty.domain.Kot;
@Service
public class KotServiceImp implements KotService {
	
	@Autowired
	@Qualifier("jpaKorDAOBean")
	private KotDAO kotDao;
	
	@Transactional
	@Override
	public List<Kot> getKoty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public Kot getKotById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void dodajKota(Kot kot) {
		// TODO Auto-generated method stub
		kotDao.dodajKota(kot);
	}

	@Transactional
	@Override
	public void edytujKota(Long idKot) {
		// TODO Auto-generated method stub

	}

}
