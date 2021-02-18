package com.gemography.challenge.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gemography.challenge.models.GitHubRepositoryModel;
import com.gemography.challenge.models.ItemModel;
import com.gemography.challenge.models.LanguagesResponseModel;

@RestController
@RequestMapping("/top-github")
@CrossOrigin
public class GithubAPIController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${GitHub-Repositories-API}")
	private String gitHubReposApi;
	
	public Collection<LanguagesResponseModel> formatResponseItems(ArrayList<ItemModel> allInputItems) {

		HashMap<String, LanguagesResponseModel> allResponseItems = new HashMap<String, LanguagesResponseModel>();

		for(ItemModel item : allInputItems) {

			LanguagesResponseModel currentResponseItem = allResponseItems.get(item.getLanguage());

			if (currentResponseItem == null) {	
				currentResponseItem = new LanguagesResponseModel(item.getLanguage(), 1);
			} else {
				currentResponseItem.setNumberOfUsers(currentResponseItem.getNumberOfUsers() + 1);
			}

			currentResponseItem.addNameToLanguageUsers(item.getName());
			allResponseItems.put(item.getLanguage(), currentResponseItem);
		}
		return allResponseItems.values();
	}
	
	public String customizeUrl(String url, Integer repositories) {
		LocalDate date = LocalDate.now().minusDays(30);

		String finalUrl = url.replace("{date}", date.toString());

		if (repositories > 0) {
			finalUrl = finalUrl.concat("&per_page="+repositories);
		} else {
			finalUrl = finalUrl.concat("&per_page="+100);
		}

		return finalUrl;
	}
	
	@RequestMapping(value= {"/languages/repositories={repositories}"}, method = RequestMethod.GET)
	public Collection<LanguagesResponseModel> getLanguages(@PathVariable(value = "repositories") Integer repositories) {
		String url = customizeUrl(gitHubReposApi, repositories);

		GitHubRepositoryModel gitHubRepositories = restTemplate.getForObject(url, GitHubRepositoryModel.class);
		
		return formatResponseItems(gitHubRepositories.getItems());
	}
}
