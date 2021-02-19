package com.gemography.challenge.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gemography.challenge.interfaces.RequestServiceI;
import com.gemography.challenge.interfaces.ResponseServiceI;
import com.gemography.challenge.models.GitHubRepositoryModel;
import com.gemography.challenge.models.LanguagesResponseModel;

/**
 * @author Baxter
 * GO TO: http://localhost:{PORT}/top-github/languages/repositories=75. THE PORT IS 9090 IF RUN WITH DOCKER-COMPOSE AND 8080 IN OTHER CASES
*/

@RestController
@RequestMapping("/top-github")
@CrossOrigin
public class GithubAPIController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RequestServiceI requestService;

	@Autowired
	private ResponseServiceI responseService;
	
	@Value("${GitHub-Repositories-API}")
	private String gitHubReposApi;

	/**
	 * The getLanguages function is a REST end point with a GET request method
	 * 
	 * @param repositories : This is an integer which represents the total number of top repositories within the last 30 days which we would like to process
	 * 						 By default the GitHub API returns 30 hits, but with this we can choose as many repositories as we like. If the value < 0 then it returns the top 100 by default
	 * @return languagesResponseItems : This is requested and restructured collection of data returned to the client
	*/

	@RequestMapping(value= {"/languages/repositories={repositories}"}, method = RequestMethod.GET)
	public Collection<LanguagesResponseModel> getLanguages(@PathVariable(value = "repositories") Integer repositories) {

		String url = requestService.customizeUrl(gitHubReposApi, repositories);

		GitHubRepositoryModel gitHubRepositories = restTemplate.getForObject(url, GitHubRepositoryModel.class);

		Collection<LanguagesResponseModel> languagesResponseItems = responseService.formatResponseItems(gitHubRepositories.getItems());

		return languagesResponseItems;
	}
	
	@RequestMapping("/")
	public String getLanguages() {
		return "";
	}
}
