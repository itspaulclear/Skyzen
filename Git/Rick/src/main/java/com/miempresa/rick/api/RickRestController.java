package com.miempresa.rick.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miempresa.rick.entity.Rick;
import com.miempresa.rick.service.IRickService;

@RestController
@RequestMapping("/api")
public class RickRestController {
	@Autowired
	private IRickService rickService;
	
	@GetMapping("/{number}")
	public Rick getEpisodeByNumber(@PathVariable Long number) {
		return rickService.getEpisodeByNumber(number);
	}
}
