package pl.kobietydokodu.koty.dao;

import java.util.List;
import pl.kobietydokodu.koty.domain.Cat;

public interface CatDAO {

	public List<Cat> findAll();
	public Cat findById(Long id);
	public Cat add(Cat kot);
	public Cat edit(Cat kot);
	public void delete(Long idKot);
}
