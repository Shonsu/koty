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
import org.springframework.web.bind.annotation.RequestMethod;

import pl.kobietydokodu.koty.dao.impl.JdbcKotDAO;
import pl.kobietydokodu.koty.domain.Kot;
import pl.kobietydokodu.koty.dto.KotDTO;
import pl.kobietydokodu.koty.service.KotServiceImp;

@Controller
public class KotyController {

	
	@Autowired
	private KotServiceImp kotService;
	
	@RequestMapping("/glowny")
	public String glowny() {
		return "glowny";
	}

	@RequestMapping("/wypisz")
	public String wypisz(Model model) {
		model.addAttribute("koty", kotService.getKoty());
		return "wypisz";
	}

	@RequestMapping("/szczegoly/{id}")
	public String szczegoly(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("kot", kotService.getKotById(id));
		return "szczegoly";
	}

	@RequestMapping("/dodaj")
	public String dodajFormularz(HttpServletRequest request, @ModelAttribute("kotDto") @Valid KotDTO kotDto,
			BindingResult result) {
		if (request.getMethod().equalsIgnoreCase("POST") && !result.hasErrors()) {
			Kot kot = new Kot();
//			SimpleDateFormat data_ur = new SimpleDateFormat("yyyy-MM-dd");
//			System.out.println("KotDto Ddate : " + kotDto.getDataUrodzenia());
			kot.setDataUrodzenia(kotDto.getDataUrodzenia());
			kot.setImie(kotDto.getImie());
			kot.setImieOpiekuna(kotDto.getImieOpiekuna());
			kot.setWaga(kotDto.getWaga());
			kotService.dodajKota(kot);
			return "redirect:/wypisz";

		} else {

			return "dodaj";
		}
	}
	// http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/
	@RequestMapping(value = "/edytuj/{id}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable("id") Integer id) {
		System.out.println(kotService.getKotById(id).getDataUrodzenia());
		model.addAttribute("kotDto", kotService.getKotById(id));
		return "edytuj";
	}
}
