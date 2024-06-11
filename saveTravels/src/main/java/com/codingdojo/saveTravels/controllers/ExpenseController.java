package com.codingdojo.saveTravels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.saveTravels.repositories.ExpenseRepository;

@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@GetMapping("/")
	public String viewHomepage(Model model) {
		model.addAttribute("expenses", expenseRepository.findAll());
		return "expenses.jsp";
	}

}
