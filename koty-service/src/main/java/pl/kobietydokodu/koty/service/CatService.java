package pl.kobietydokodu.koty.service;

import java.util.List;
import pl.kobietydokodu.koty.domain.Cat;

public interface CatService {
	
	public List<Cat> getKoty();
	public Cat getKotById(Integer id);
	public void dodajKota(Cat kot);
	public void edytujKota(Long idKot);
}
