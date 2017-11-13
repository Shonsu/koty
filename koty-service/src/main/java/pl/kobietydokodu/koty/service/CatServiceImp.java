/*package pl.kobietydokodu.koty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.kobietydokodu.koty.dao.CatDAO;
import pl.kobietydokodu.koty.domain.Cat;
@Service("CatService")
public class CatServiceImp {
	
	CatDAO kotDao;
	@Autowired
	@Qualifier("jpaKotDAO") //jdbcKotDAOBean or jpaKotDAOBean
	private CatDAO kotDao;
	
	@Transactional
	public List<Cat> findAll() {	
		return kotDao.findAll();
	}

	@Transactional
	public Cat findById(Long id) {
		return kotDao.findById(id);
	}

	@Transactional
	public void add(Cat kot) {
		kotDao.add(kot);
	}

	@Transactional
	public void edit(Cat kot) {
		kotDao.edit(kot);
	}

	@Transactional
	public void delete(Cat kot) {
		kotDao.delete(kot);
	}

}
*/