package pl.kobietydokodu.koty.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kobietydokodu.koty.domain.Cat;


public interface CatRepository extends JpaRepository<Cat, Long>  {
	

}
