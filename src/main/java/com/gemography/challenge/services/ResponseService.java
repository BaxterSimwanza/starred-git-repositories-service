package com.gemography.challenge.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.gemography.challenge.models.ItemModel;
import com.gemography.challenge.models.LanguagesResponseModel;

@Service
public class ResponseService {

	public Collection<LanguagesResponseModel> formatResponseItems(ArrayList<ItemModel> allInputItems) {

		HashMap<String, LanguagesResponseModel> allResponseItems = new HashMap<String, LanguagesResponseModel>();

		for(ItemModel item : allInputItems) {

			LanguagesResponseModel currentResponseItem = allResponseItems.get(item.getLanguage());

			if (currentResponseItem == null) {
				
				currentResponseItem = new LanguagesResponseModel(item.getLanguage());
			} else {
				currentResponseItem.incrementNumberOfUsers();
			}

			currentResponseItem.addNameToLanguageUsers(item.getName());
			allResponseItems.put(item.getLanguage(), currentResponseItem);
		}
		return allResponseItems.values();
	}
}
