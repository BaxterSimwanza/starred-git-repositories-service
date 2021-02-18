package com.gemography.challenge.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.gemography.challenge.interfaces.ResponseServiceI;
import com.gemography.challenge.models.ItemModel;
import com.gemography.challenge.models.LanguagesResponseModel;

/**
 * @author Baxter
*/
@Service
public class ResponseService implements ResponseServiceI {

	/**
	 * The formatResponseItems function gets data from a successful GitHub API call and restructures it to the requested format
	 * The requested format is
	 * 
	 * 	- The name of the programming language
	 * 	- The number of repositories using this language
	 * 	- The names of the repositories using it
	 * 
	 * @param allInputItems : These are the input items we get upon successfully hitting the GitHub repository
	 * @return allResponseItems.values() : These are the restructured or reformatted items
	*/
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
