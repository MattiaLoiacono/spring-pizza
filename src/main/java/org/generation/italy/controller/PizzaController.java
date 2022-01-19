package org.generation.italy.controller;

import org.generation.italy.model.Pizza;
import org.generation.italy.service.IngredientiService;
import org.generation.italy.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/menu")
public class PizzaController {
	
	@Autowired
	private PizzaService service;
	
	@Autowired
	private IngredientiService service1;
	
	@GetMapping
	public String menu(Model model, @RequestParam(name="keyword", required=false) String keyword) {
		if(keyword != null && !keyword.isEmpty()) {
			model.addAttribute("menu",service.findByKeyword(keyword)	);
		}else {
			model.addAttribute("menu", service.findAllSortName());
		}
		return "/pizza/menu";
	}
	
	@GetMapping("/new")
	public String newPizza(Model model) {
		model.addAttribute("pizza", new Pizza());
		model.addAttribute("ingredienti", service1.findAllSortName());
		return "/pizza/creazione";
	}
	
	@PostMapping("/new")
	public String doCreate(@ModelAttribute("pizza") Pizza formPizza, Model model) {
		service.save(formPizza);
		return "redirect:/menu";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("pizza", service.getById(id));
		model.addAttribute("ingredienti", service1.findAllSortName());
		return "/pizza/edit";
	}
	
	@PostMapping("/edit/{id}")
	public String doEdit(@ModelAttribute("pizza") Pizza formPizza, Model model) {
		service.save(formPizza);
		return "redirect:/menu";
	}
	
	
	@GetMapping("/delete/{id}")
	public String doDelete(Model model, @PathVariable("id") Integer id) {
		service.deleteById(id);
		return "redirect:/menu";
	}
}
