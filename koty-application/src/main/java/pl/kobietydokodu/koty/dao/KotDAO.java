package pl.kobietydokodu.koty.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import pl.kobietydokodu.koty.domain.Kot;

@Component
public interface KotDAO {

	public List<Kot> getKoty();
	public Kot getKotById(Integer id);
	public void dodajKota(Kot kot);
	public void edytujKota(Long idKot);
}
