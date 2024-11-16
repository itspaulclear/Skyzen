package com.miempresa.rick.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rick {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long number;
	
	private String name;
	private String air_date;
	private String episode;
	private String[] characters;
	private String url;
	private String created;
	
	public Rick() {
	}

	public Rick(Long number, String name, String air_date, String episode, String[] characters, String url,
			String created) {
		this.number = number;
		this.name = name;
		this.air_date = air_date;
		this.episode = episode;
		this.characters = characters;
		this.url = url;
		this.created = created;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAir_date() {
		return air_date;
	}

	public void setAir_date(String air_date) {
		this.air_date = air_date;
	}

	public String getEpisode() {
		return episode;
	}

	public void setEpisode(String episode) {
		this.episode = episode;
	}

	public String[] getCharacters() {
		return characters;
	}

	public void setCharacters(String[] characters) {
		this.characters = characters;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}
	
}
