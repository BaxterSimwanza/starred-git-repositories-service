package com.gemography.challenge.models;

import java.io.Serializable;

public class ItemModel implements Serializable {
	public String name;
	public int stargazers_count;
	public String language;

	public ItemModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemModel(String name, int stargazers_count, String language) {
		super();
		this.name = name;
		this.stargazers_count = stargazers_count;
		this.language = language;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStargazers_count() {
		return stargazers_count;
	}

	public void setStargazers_count(int stargazers_count) {
		this.stargazers_count = stargazers_count;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
}
