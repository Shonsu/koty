package pl.kobietydokodu.koty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.kobietydokodu.koty.dao.CatService;
import pl.kobietydokodu.koty.domain.Cat;
@Service
public class CatServiceImp implements CatService {
	
	@Autowired
	@Qualifier("jpaKotDAOBean")
	private CatService kotDao;
	
	@Transactional
	@Override
	public List<Cat> findAll() {	
		return kotDao.findAll();
	}

	@Transactional
	@Override
	public Cat findById(Integer id) {
		// TODO Auto-generated method stub
		return kotDao.findById(id);
	}

	@Transactional
	@Override
	public void add(Cat kot) {
		// TODO Auto-generated method stub
		kotDao.add(kot);
	}

	@Transactional
	@Override
	public void edit(Long idKot) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long idKot) {
		// TODO Auto-generated method stub
		
	}

}
