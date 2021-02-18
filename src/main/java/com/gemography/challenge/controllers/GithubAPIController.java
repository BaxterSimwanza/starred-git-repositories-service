package com.gemography.challenge.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gemography.challenge.models.GitHubRepositoryModel;

@RestController
@RequestMapping("/top-github")
@CrossOrigin
public class GithubAPIController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${GitHub-Repositories-API}")
	private String gitHubReposApi;
	
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
	public GitHubRepositoryModel getLanguages(@PathVariable(value = "repositories") Integer repositories) {

		String url = customizeUrl(gitHubReposApi, repositories);

		GitHubRepositoryModel gitHubRepositories = restTemplate.getForObject(url, GitHubRepositoryModel.class);
		
		return gitHubRepositories;
	}
}
