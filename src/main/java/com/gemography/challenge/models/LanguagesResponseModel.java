package com.gemography.challenge.models;

import java.util.ArrayList;
/**
 * @author Baxter
*/
public class LanguagesResponseModel {

	public String languageName;
	public int numberOfUsers;
	public ArrayList<String> languageUsers;

	public LanguagesResponseModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LanguagesResponseModel(String languageName) {
		super();
		this.languageName = languageName;
		this.numberOfUsers = 1;
		this.languageUsers = new ArrayList<String>();
	}
	
	public void addNameToLanguageUsers(String languageUser) {
	    this.languageUsers.add(languageUser);
	}
	
	public void incrementNumberOfUsers() {
		numberOfUsers += 1;
	}
}
