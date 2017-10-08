package pl.kobietydokodu.koty.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kobietydokodu.koty.KotDAO;

@Controller
public class KotyController {

	@Autowired
	private KotDAO kotDao;
	
	 @RequestMapping("/glowny")
	    public String glowny() {
	        return "glowny";
	 }
	 
	 @RequestMapping("/dodaj")
	    public String dodaj() {
	        return "dodaj";
	 }
	 
	 @RequestMapping("/wypisz")
	    public String wypisz() {
	        return "wypisz";
	 }
	 
	 @RequestMapping("/szczegoly")
	    public String szczegoly() {
	        return "szczegoly";
	 }
}
