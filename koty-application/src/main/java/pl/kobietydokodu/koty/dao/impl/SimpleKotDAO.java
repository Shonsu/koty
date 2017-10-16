package pl.kobietydokodu.koty.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.kobietydokodu.koty.dao.KotDAO;
import pl.kobietydokodu.koty.domain.Kot;

@Repository
public class SimpleKotDAO implements KotDAO{

	List<Kot> koty = new ArrayList<Kot>();
	
	public void dodajKota(Kot kot) {
		koty.add(kot);
	}
	
	public List<Kot> getKoty() {
		return koty;
	}
	
	public Kot getKotById(Integer id) {
		if (id<koty.size()) {
			return koty.get(id);
		} else {
			return null;
		}
	}
}
