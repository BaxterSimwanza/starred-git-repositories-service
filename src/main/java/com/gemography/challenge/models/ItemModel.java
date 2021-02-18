package com.gemography.challenge.models;

import java.io.Serializable;
/**
 * @author Baxter
*/
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

	public String getLanguage() {
		return language;
	}
}
