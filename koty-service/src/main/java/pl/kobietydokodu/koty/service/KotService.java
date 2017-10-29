package pl.kobietydokodu.koty.service;

import java.util.List;

import pl.kobietydokodu.koty.domain.Kot;

public interface KotService {
	public List<Kot> getKoty();
	public Kot getKotById(Integer id);
	public void dodajKota(Kot kot);
	public void edytujKota(Long idKot);
}
