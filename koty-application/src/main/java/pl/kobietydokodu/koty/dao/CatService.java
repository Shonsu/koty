package pl.kobietydokodu.koty.dao;

import java.util.List;


import pl.kobietydokodu.koty.domain.Cat;


public interface CatService {

	public List<Cat> findAll();
	public Cat findById(Integer id);
	public void add(Cat kot);
	public void edit(Long idKot);
	public void delete(Long idKot);
}
