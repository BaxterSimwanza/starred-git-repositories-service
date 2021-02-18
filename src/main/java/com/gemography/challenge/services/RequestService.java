package com.gemography.challenge.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.gemography.challenge.interfaces.RequestServiceI;

/**
 * @author Baxter
*/
@Service
public class RequestService implements RequestServiceI {

	/**
	 * The customizeUrl handles pagination and time interval 
	 * @param url : Is a String of the GitHub API where we will retrieve the repositories data 
	 * @param repositories : Is and integer which represents the pagination or rather number of repositories to return
	 * @return finalUrl : This is the String containing the final-URL
	*/
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
}
