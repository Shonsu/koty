package pl.kobietydokodu.koty.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import pl.kobietydokodu.koty.domain.Cat;

@Transactional
public interface CatRepository extends JpaRepository<Cat, Long>  {
	

}
