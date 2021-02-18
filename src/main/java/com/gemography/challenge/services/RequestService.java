package com.gemography.challenge.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class RequestService {

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
