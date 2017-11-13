package pl.kobietydokodu.koty.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.kobietydokodu.koty.domain.Cat;

@Repository
@Qualifier("catRepository")
public interface CatRepository extends JpaRepository<Cat, Long>  {
	

}
