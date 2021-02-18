package com.gemography.challenge.controllers;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gemography.challenge.models.GitHubRepositoryModel;
import com.gemography.challenge.models.LanguagesResponseModel;
import com.gemography.challenge.services.RequestService;
import com.gemography.challenge.services.ResponseService;

@RestController
@RequestMapping("/top-github")
@CrossOrigin
public class GithubAPIController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RequestService requestService;

	@Autowired
	private ResponseService responseService;
	
	@Value("${GitHub-Repositories-API}")
	private String gitHubReposApi;
	
	@RequestMapping(value= {"/languages/repositories={repositories}"}, method = RequestMethod.GET)
	public Collection<LanguagesResponseModel> getLanguages(@PathVariable(value = "repositories") Integer repositories) {
		String url = requestService.customizeUrl(gitHubReposApi, repositories);

		GitHubRepositoryModel gitHubRepositories = restTemplate.getForObject(url, GitHubRepositoryModel.class);
		
		return responseService.formatResponseItems(gitHubRepositories.getItems());
	}
}
