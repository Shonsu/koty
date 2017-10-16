package pl.kobietydokodu.koty.dao;

import java.util.List;

import pl.kobietydokodu.koty.domain.Kot;


public interface KotDAO {

	public void dodajKota(Kot kot);
	public List<Kot> getKoty();
	public Kot getKotById(Integer id);
}
