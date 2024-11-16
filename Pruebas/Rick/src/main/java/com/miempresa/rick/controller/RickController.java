package com.miempresa.rick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miempresa.rick.entity.Rick;
import com.miempresa.rick.service.IRickService;

@Controller
@RequestMapping("/rick/")
public class RickController {
	@Autowired
	private IRickService rickService;
	
	@GetMapping("/{number}")
	public String getEpisodeById(@PathVariable Long number, Model model) {
		Rick rick = rickService.getEpisodeByNumber(number);
		model.addAttribute("cabecera", "Selección de capítulo");
		model.addAttribute("titulo", "Este es el episodio seleccionado: ");
		model.addAttribute("episodio", rick);
		model.addAttribute("numeroEpisodio", number);
		return "rick/resultado";
	}
	
	@GetMapping("/buscar")
	public String buscarEpisodio(Model model) {
		model.addAttribute("cabecera", "Buscador de episodios");
		model.addAttribute("titulo", "Capítulo a buscar: ");
		model.addAttribute("episodio", new Rick());
		return "rick/buscar";
	}
	
	@PostMapping("/form")
	public String form(Long number) {
		return "redirect:/rick/" + number;
	}
}
