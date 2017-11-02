package pl.kobietydokodu.koty.controllers;



import java.util.TimeZone;

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

import pl.kobietydokodu.koty.domain.Cat;
import pl.kobietydokodu.koty.dto.KotDTO;
import pl.kobietydokodu.koty.service.CatService;

@Controller
public class KotyController {

	static {
	    TimeZone.setDefault(TimeZone.getTimeZone("UTC")); //bez tego data zapisywana w bazie danych była cofnięta o jeden dzień.  
	  }
	
	@Autowired
	private CatService catService;
	
	@RequestMapping("/glowny")
	public String glowny() {
		return "glowny";
	}

	@RequestMapping("/wypisz")
	public String wypisz(Model model) {
		model.addAttribute("koty", catService.findAll());
		return "wypisz";
	}

	@RequestMapping("/szczegoly/{id}")
	public String szczegoly(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("kot", catService.findById(id));
		return "szczegoly";
	}

	@RequestMapping("/dodaj")
	public String dodajFormularz(HttpServletRequest request, @ModelAttribute("kotDto") @Valid KotDTO kotDto,
			BindingResult result, final RedirectAttributes redirectAttributes) {
		
		if (request.getMethod().equalsIgnoreCase("POST") && !result.hasErrors()) {
			Cat kot = new Cat();
			
		    java.util.Date utilDate = new java.util.Date();
		    utilDate = kotDto.getBirthDate();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    
			kot.setBirthDate(sqlDate);
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
			
			catService.add(kot);
			return "redirect:/wypisz";

		} else {

			return "dodaj";
		}
	}
	// http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/
	@RequestMapping(value = "/edytuj/{id}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("kotDto", catService.findById(id));
		return "edytuj";
	}
	
	// show update form
	@RequestMapping(value = "/cats/{id}/update", method = RequestMethod.GET)
	public String showUpdateCatForm(@PathVariable("id") int id, Model model) {
		//logger.debug("showUpdateUserForm() : {}", id);
		Cat cat = catService.findById(id);
		model.addAttribute("catDto", cat);

		//populateDefaultModel(model);

		return "cats/catform";

	}
	@RequestMapping(value = "/cats", method = RequestMethod.POST)
	public String edit(@ModelAttribute("catDto") @Valid KotDTO catDto,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {

		//logger.debug("saveOrUpdateUser() : {}", user);
		System.out.println("/cats");
		
		if (result.hasErrors()) {
			//populateDefaultModel(model);
			return "cats/catform";
		} else {
			
			System.out.println("new cat etc cuystid " + catDto.getCustId());
			
			Cat cat = new Cat();
			
		    java.util.Date utilDate = new java.util.Date();
		    utilDate = catDto.getBirthDate();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    cat.setCustId(catDto.getCustId());
		    cat.setBirthDate(sqlDate);
		    cat.setName(catDto.getName());
		    cat.setOwner(catDto.getOwner());
		    cat.setWeight(catDto.getWeight());
			
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			if(cat.isNew()){
			  redirectAttributes.addFlashAttribute("msg", "Cat added successfully!");
			}else{
			  redirectAttributes.addFlashAttribute("msg", "Cat updated successfully!");
			}
			System.out.println("before edit cat");
			catService.edit(cat);
			System.out.println("after edit cat");
			// POST/REDIRECT/GET
			//return "redirect:/szczegoly/" + cat.getCustId();

			// POST/FORWARD/GET
			 return "wypisz";

		}

	}
}
