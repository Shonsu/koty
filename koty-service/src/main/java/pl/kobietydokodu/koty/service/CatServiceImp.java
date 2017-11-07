package pl.kobietydokodu.koty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.kobietydokodu.koty.dao.CatDAO;
import pl.kobietydokodu.koty.domain.Cat;
@Service("CatService")
public class CatServiceImp implements CatService {
	
	@Autowired
	@Qualifier("jpaKotDAOBean") //jdbcKotDAOBean or jpaKotDAOBean
	private CatDAO kotDao;
	
	@Transactional
	@Override
	public List<Cat> findAll() {	
		return kotDao.findAll();
	}

	@Transactional
	@Override
	public Cat findById(Long id) {
		return kotDao.findById(id);
	}

	@Transactional
	@Override
	public void add(Cat kot) {
		kotDao.add(kot);
	}

	@Transactional
	@Override
	public void edit(Cat kot) {
		kotDao.edit(kot);
	}

	@Transactional
	@Override
	public void delete(Long idKot) {
		kotDao.delete(idKot);
	}

}
