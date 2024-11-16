package com.miempresa.rick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.miempresa.rick.entity.Rick;

@Service("rickService")
public class RickService implements IRickService {
	@Autowired
	private RestTemplate restTemplate;
	private String apiUrl = "https://rickandmortyapi.com/api/episode/";
	
	public Rick getEpisodeByNumber(Long number) {
		return restTemplate.getForObject(apiUrl + number, Rick.class);
	}
}
