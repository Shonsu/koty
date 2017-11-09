package pl.kobietydokodu.koty.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.kobietydokodu.koty.domain.Cat;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long>  {
	
	//public List<Cat> findAllByOrderByIdAsc();
	@Transactional
	  public <S extends Cat> S save(S entity);   
	@Transactional
	  public Optional<Cat> findByCustId(Long id);
	@Transactional
	  public List<Cat> findAll();     
	@Transactional
	  public long count();    
	@Transactional
	  public void delete(Cat entity);    
	@Transactional
	  public boolean existsByCustId(Long id);
}
