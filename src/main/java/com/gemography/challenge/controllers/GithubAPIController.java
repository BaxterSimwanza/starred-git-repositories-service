package com.gemography.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@GetMapping("/languages")
	public GitHubRepositoryModel getLanguages() {

		GitHubRepositoryModel gitHubRepositories = restTemplate.getForObject(gitHubReposApi.replace("{date}", "2021-01-18"), GitHubRepositoryModel.class);
		
		return gitHubRepositories;
	}
}
