package pl.kobietydokodu.koty.controllers;



import java.util.TimeZone;

//import java.text.SimpleDateFormat;

//import javax.servlet.http.HttpServletRequest;
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
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String glowny() {
		return "redirect:/cats";
	}

	@RequestMapping(value = "/cats", method = RequestMethod.GET)
	public String showAllCats(Model model) {
		model.addAttribute("cats", catService.findAll());
		return "cats/list";
	}

	@RequestMapping(value = "/cats/{id}", method = RequestMethod.GET)
	public String show(Model model, @PathVariable("id") long id) {
		model.addAttribute("cat", catService.findById(id));
		return "cats/show";
	}

	// show update form
	@RequestMapping(value = "/cats/{id}/update", method = RequestMethod.GET)
	public String showUpdateCatForm(@PathVariable("id") long id, Model model) {
		//logger.debug("showUpdateUserForm() : {}", id);
		Cat cat = catService.findById(id);
		model.addAttribute("catDto", cat);

		//populateDefaultModel(model);

		return "cats/catform";

	}
	
	
	//update or add Cat
	@RequestMapping(value = "/cats", method = RequestMethod.POST)
	public String saveOrUpdate(@ModelAttribute("catDto") @Valid KotDTO catDto,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {

		//logger.debug("saveOrUpdateUser() : {}", user);
		
		if (result.hasErrors()) {
			//populateDefaultModel(model);
			return "cats/catform";
		} else {
			
			Cat cat = new Cat();
			// convert from util (KotDto) to sql date (Cat)
		    java.util.Date utilDate = new java.util.Date();
		    utilDate = catDto.getBirthDate();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    cat.setBirthDate(sqlDate);
		    
		    cat.setCustId(catDto.getCustId());
		    cat.setName(catDto.getName());
		    cat.setOwner(catDto.getOwner());
		    cat.setWeight(catDto.getWeight());
			
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			if(cat.isNew()){
				catService.add(cat);
			  redirectAttributes.addFlashAttribute("msg", "Cat added successfully!");
			}else{
				catService.edit(cat);
			  redirectAttributes.addFlashAttribute("msg", "Cat updated successfully!");
			}

			// POST/REDIRECT/GET
			return "redirect:/cats/" + cat.getCustId();

		}

	}
	
	@RequestMapping(value = "/cats/add", method = RequestMethod.GET)
	public String showAddCatForm(@ModelAttribute("catDto") @Valid KotDTO catDto,
			BindingResult result, Model model) {

		return "cats/catform";

	}
	
	@RequestMapping(value = "/cats/{id}/delete", method = RequestMethod.POST)
	public String deleteCat(@PathVariable("id") long id, final RedirectAttributes redirectAttributes) {
System.out.println("/cats/{id}/delete");
		catService.delete(id);
		
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Cat is deleted!");
		
		return "redirect:/cats";
	}
	
	// http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/
}
