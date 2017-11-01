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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.kobietydokodu.koty.dao.impl.JdbcCatDAO;
import pl.kobietydokodu.koty.domain.Cat;
import pl.kobietydokodu.koty.dto.KotDTO;
import pl.kobietydokodu.koty.service.CatServiceImp;

@Controller
public class KotyController {

	
	@Autowired
	private CatServiceImp kotService;
	
	@RequestMapping("/glowny")
	public String glowny() {
		return "glowny";
	}

	@RequestMapping("/wypisz")
	public String wypisz(Model model) {
		model.addAttribute("koty", kotService.findAll());
		return "wypisz";
	}

	@RequestMapping("/szczegoly/{id}")
	public String szczegoly(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("kot", kotService.findById(id));
		return "szczegoly";
	}

	@RequestMapping("/dodaj")
	public String dodajFormularz(HttpServletRequest request, @ModelAttribute("kotDto") @Valid KotDTO kotDto,
			BindingResult result, final RedirectAttributes redirectAttributes) {
		if (request.getMethod().equalsIgnoreCase("POST") && !result.hasErrors()) {
			Cat kot = new Cat();
//			SimpleDateFormat data_ur = new SimpleDateFormat("yyyy-MM-dd");
//			System.out.println("KotDto Ddate : " + kotDto.getDataUrodzenia());
			kot.setBirthDate(kotDto.getBirthDate());
			kot.setName(kotDto.getName());
			kot.setOwner(kotDto.getOwner());
			kot.setWeight(kotDto.getWeight());
			// Add message to flash scope
						redirectAttributes.addFlashAttribute("css", "success");
						if(kot.isNew()){
						  redirectAttributes.addFlashAttribute("msg", "Kot dodany pomyślnie!");
						}else{
						  redirectAttributes.addFlashAttribute("msg", "Kot zaktualizowany pomyślnie!");
						}
			kotService.add(kot);
			return "redirect:/wypisz";

		} else {

			return "dodaj";
		}
	}
	// http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/
	@RequestMapping(value = "/edytuj/{id}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("kotDto", kotService.findById(id));
		return "edytuj";
	}
}
