package com.codingdojo.saveTravels.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.saveTravels.models.Travel;
import com.codingdojo.saveTravels.services.TravelService;

import jakarta.validation.Valid;

@Controller
public class TravelController {
	private final TravelService travelService;
	
	public TravelController(TravelService travelService) {
		this.travelService = travelService;
	}
	
	@GetMapping("/")
	public String index(@ModelAttribute("travel")Travel travel, Model model) {
		List<Travel> travels = travelService.allTravels();
		model.addAttribute("travels", travels);
		return "index.jsp";
	}
	
	@PostMapping("/createtravel")
	public String create(@Valid @ModelAttribute("trave")Travel travel, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Travel> travels = travelService.allTravels();
			model.addAttribute("travels", travels);
			return "index.jsp";
		} else {
			travelService.createTravel(travel);
			return "redirect:/";
		}
	}
	
	@GetMapping("/travels/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Travel travel = travelService.findTravel(id);
		model.addAttribute("travel", travel);
		return "edit.jsp";
	}
	
	@GetMapping("/travels/{id}/show")
	public String show(Model model, @PathVariable("id") Long id) {
		Travel travel = travelService.findTravel(id);
		model.addAttribute("travel", travel);
		return "show.jsp";
	}
	
	@PutMapping("/travels/{id}")
	public String upddate(@Valid @ModelAttribute("travel") Travel travel, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("travel", travel);
			return"edit.jsp";
		} else {
			travelService.updateTravel(travel);
			return"redirect:/";
		}
	}
	
	@DeleteMapping("/travels/{id}")
	public String delete(@PathVariable("id") Long id) {
		travelService.deleteTravel(id);
		return"redirect:/";
	}
}

