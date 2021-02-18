package com.gemography.challenge.models;

import java.util.ArrayList;

public class LanguagesResponseModel {

	public String languageName;
	public int numberOfUsers;
	public ArrayList<String> languageUsers;

	public LanguagesResponseModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LanguagesResponseModel(String languageName, int numberOfUsers) {
		super();
		this.languageName = languageName;
		this.numberOfUsers = numberOfUsers;
		this.languageUsers = new ArrayList<String>();
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public int getNumberOfUsers() {
		return numberOfUsers;
	}

	public void setNumberOfUsers(int numberOfUsers) {
		this.numberOfUsers = numberOfUsers;
	}

	public ArrayList<String> getLanguageUsers() {
		return languageUsers;
	}

	public void setLanguageUsers(ArrayList<String> languageUsers) {
		this.languageUsers = languageUsers;
	}
}
