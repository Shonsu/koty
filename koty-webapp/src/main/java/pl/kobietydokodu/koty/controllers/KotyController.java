package pl.kobietydokodu.koty.controllers;

//import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kobietydokodu.koty.KotDAO;
import pl.kobietydokodu.koty.domain.Kot;
import pl.kobietydokodu.koty.dto.KotDTO;

@Controller
public class KotyController {

	@Autowired
	public KotDAO kotDao;

	@RequestMapping("/glowny")
	public String glowny() {
		return "glowny";
	}

	@RequestMapping("/wypisz")
	public String wypisz(Model model) {
		model.addAttribute("koty", kotDao.getKoty());
		return "wypisz";
	}

	@RequestMapping("/szczegoly/{id}")
	public String szczegoly(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("kot", kotDao.getKotById(id));
		return "szczegoly";
	}

	@RequestMapping("/dodaj")
	public String dodajFormularz(HttpServletRequest request, @ModelAttribute("kotDto") @Valid KotDTO kotDto,
			BindingResult result) {
		if (request.getMethod().equalsIgnoreCase("POST") && !result.hasErrors()) {
			Kot kot = new Kot();
//			SimpleDateFormat data_ur = new SimpleDateFormat("yyyy-MM-dd");
			kot.setDataUrodzenia(kotDto.getDataUrodzenia());
			kot.setImie(kotDto.getImie());
			kot.setImieOpiekuna(kotDto.getImieOpiekuna());
			kot.setWaga(kotDto.getWaga());
			kotDao.dodajKota(kot);
			return "redirect:/wypisz";

		} else {

			return "dodaj";
		}
	}
}
