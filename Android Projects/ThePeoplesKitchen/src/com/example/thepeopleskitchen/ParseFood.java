package com.example.thepeopleskitchen;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class ParseFood {

	public ArrayList<Recipe> ParseJson(String toParse) {
		ArrayList<Recipe> recipes_list = new ArrayList<Recipe>();
		try {

			JSONObject root = new JSONObject(toParse);
			JSONArray rarray = root.getJSONArray("recipes");
			
			JSONObject obj;
			
			for (int i = 0; i < rarray.length(); i++) {
			{
				obj = rarray.getJSONObject(i);
			
				Recipe r = new Recipe();
				r.setTitle(obj.getString("title"));
				r.setImage_url(obj.getString("image_url"));

				r.setRecipe_id(obj.getString("recipe_id"));
				r.setPublisher_url(obj.getString("publisher_url"));
				r.setPublisher(obj.getString("publisher"));
				r.setRecipe_url(obj.getString("f2f_url"));
				r.setSource_url(obj.getString("source_url"));
				r.setRank(obj.getString("social_rank"));

				recipes_list.add(r);
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Log.d("Parser",recipes_list.toString());
		return recipes_list;

	}
}
