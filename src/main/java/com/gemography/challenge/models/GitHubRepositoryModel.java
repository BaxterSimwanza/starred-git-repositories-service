package com.gemography.challenge.models;

import java.io.Serializable;
import java.util.ArrayList;

public class GitHubRepositoryModel implements Serializable {

	public int total_count;
	
	public boolean incomplete_results;
	
	private ArrayList<ItemModel> items;
	
	public GitHubRepositoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GitHubRepositoryModel(int total_count, boolean incomplete_results, ArrayList<ItemModel> items) {
		super();
		this.total_count = total_count;
		this.incomplete_results = incomplete_results;
		this.items = items;
	}

	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	public boolean isIncomplete_results() {
		return incomplete_results;
	}

	public void setIncomplete_results(boolean incomplete_results) {
		this.incomplete_results = incomplete_results;
	}

	public ArrayList<ItemModel> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemModel> items) {
		this.items = items;
	}
	
}
