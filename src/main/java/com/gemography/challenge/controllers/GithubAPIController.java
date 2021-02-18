package com.gemography.challenge.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/top-github")
@CrossOrigin
public class GithubAPIController {
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/languages")
	public GitRepositoryModel getLanguages() {

		GitRepositoryModel gitRepositories = restTemplate.getForObject("https://api.github.com/search/repositories?q=created:>{date}&sort=stars&order=desc", GitRepositoryModel.class);
		
		return gitRepositories.getItems();
	}
}
