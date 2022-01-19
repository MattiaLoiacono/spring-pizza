package org.generation.italy.controller;

import org.generation.italy.model.Ingrediente;
import org.generation.italy.service.IngredientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ingredienti")
@Controller
public class IngredienteController {
	
	@Autowired
	private IngredientiService service;
	
	@GetMapping
	public String ingredintiList(Model model) {
		model.addAttribute("ingredienti", service.findAllSortName());
		return "/ingredienti/lista";
	}
	
	@GetMapping("/new")
	public String newIngrediente(Model model) {
		model.addAttribute("ingrediente",new Ingrediente());
		return "/ingredienti/creazione";
	}
	
	@PostMapping("/new")
	public String doCreate(@ModelAttribute("ingrediente") Ingrediente formIngrediente, Model model) {
		service.save(formIngrediente);
		return "redirect:/ingredienti";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("ingrediente", service.getById(id));
		return "/ingredienti/edit";
	}
	
	@PostMapping("/edit/{id}")
	public String doEdit(@ModelAttribute("ingrediente") Ingrediente formIngrediente, Model model) {
		service.save(formIngrediente);
		return "redirect:/ingredienti";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable("id") Integer id) {
		service.deleteById(id);
		return "redirect:/ingredienti";
	}
}
