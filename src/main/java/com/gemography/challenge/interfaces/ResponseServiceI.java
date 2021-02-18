package com.gemography.challenge.interfaces;

import java.util.ArrayList;
import java.util.Collection;

import com.gemography.challenge.models.ItemModel;
import com.gemography.challenge.models.LanguagesResponseModel;
/**
 * @author Baxter
*/
public interface ResponseServiceI {

	Collection<LanguagesResponseModel> formatResponseItems(ArrayList<ItemModel> allInputItems);

}
