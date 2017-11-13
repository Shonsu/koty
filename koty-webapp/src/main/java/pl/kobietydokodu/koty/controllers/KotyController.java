package pl.kobietydokodu.koty.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import pl.kobietydokodu.koty.service.JdbcCatDAOService;
import pl.kobietydokodu.koty.service.JpaRepositoryService;

@Controller
public class KotyController {

	private final Logger logger = LoggerFactory.getLogger(KotyController.class);

	static {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC")); // bez tego data zapisywana w bazie danych była cofnięta o
															// jeden dzień.
	}

	@Autowired
	@Qualifier("JpaKotDAOService") // JpaRepositoryService JpaKotDAOService JdbcCatDAOService
	private CatService catService; 

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String glowny() {
		return "redirect:/cats";
	}

	@RequestMapping(value = "/cats", method = RequestMethod.GET)
	public String showAllCats(Model model) {

		logger.debug("showAllCats()");

		model.addAttribute("cats", catService.findAll());
		return "cats/list";
	}

	@RequestMapping(value = "/cats/{id}", method = RequestMethod.GET)
	public String showCat(Model model, @PathVariable("id") long id) {

		logger.debug("showCat() id: {}", id);

		if (catService.existsById(id)) {
			model.addAttribute("cat", catService.findById(id).get());
		} else {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Cat not found.");
		}
		return "cats/show";
	}

	// show update form
	@RequestMapping(value = "/cats/{id}/update", method = RequestMethod.GET)
	public String showUpdateCatForm(@PathVariable("id") long id, Model model) {

		logger.debug("showUpdateCatForm() id: {}", id);

		if (catService.existsById(id)) {
			Cat cat = catService.findById(id).get();
			
			model.addAttribute("catDto", cat);
			return "cats/catform";
		} else {
			/* model.addAttribute("cats", catService.findAll()); */
			/*
			 * model.addAttribute("css", "danger"); model.addAttribute("msg",
			 * "Cat not found.");
			 */

		}
		return "redirect:/cats";

	}

	// update or add Cat
	@RequestMapping(value = "/cats", method = RequestMethod.POST)
	public String saveOrUpdateCat(@ModelAttribute("catDto") @Valid KotDTO catDto, BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {

		logger.debug("saveOrUpdateCat() : {}", catDto);

		if (result.hasErrors()) {
			// populateDefaultModel(model);
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
			cat.setSex(catDto.getSex());
			cat.setColoring(catDto.getColoring());
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			if (cat.isNew()) {
				catService.save(cat);
				redirectAttributes.addFlashAttribute("msg", "Cat added successfully!");
			} else {
				catService.save(cat);
				redirectAttributes.addFlashAttribute("msg", "Cat updated successfully!");
			}

			// POST/REDIRECT/GET
			return "redirect:/cats/" + cat.getCustId();

		}

	}

	@RequestMapping(value = "/cats/add", method = RequestMethod.GET)
	public String showAddCatForm(@ModelAttribute("catDto") @Valid KotDTO catDto, BindingResult result, Model model) {

		logger.debug("showAddCatForm()");

		return "cats/catform";

	}

	@RequestMapping(value = "/cats/{id}/delete", method = RequestMethod.POST)
	public String deleteCat(@PathVariable("id") long id, final RedirectAttributes redirectAttributes) {

		logger.debug("deleteCat() id: {}", id);

		if (catService.existsById(id)) {
			catService.delete(catService.findById(id).get());
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Cat is deleted!");
		} else {
			redirectAttributes.addAttribute("css", "danger");
			redirectAttributes.addAttribute("msg", "Cat not found.");
		}

		return "redirect:/cats";
	}

	@ModelAttribute("webColoringList")
	public List<String> populateWebColoringList() {

		// Data referencing for web framework checkboxes
		List<String> webColoringList = new ArrayList<String>();
		webColoringList.add("white");
		webColoringList.add("black");
		webColoringList.add("red");
		webColoringList.add("chocolate");
		webColoringList.add("blue");
		webColoringList.add("silver");
		webColoringList.add("spotted");
		webColoringList.add("tiger");
		webColoringList.add("other");

		return webColoringList;
	}
	// http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/
}
