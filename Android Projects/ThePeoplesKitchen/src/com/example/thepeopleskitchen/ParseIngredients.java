package com.example.thepeopleskitchen;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

public class ParseIngredients {
	
	ArrayList<String> in_list ;
	
	public ArrayList<String> ParseJson(String toParse){
		in_list = new ArrayList<String>() ;
		try {
			
			JSONObject root = new JSONObject(toParse);
//			JSONArray rarray = root.getJSONArray("recipe");
			JSONObject o = root.getJSONObject("recipe");
			JSONArray iarray = o.getJSONArray("ingredients");
			
			Log.d("ingredients",iarray.toString());
		
			for (int i = 0; i < iarray.length(); i++) {
				{
					String ing = iarray.getString(i);				
					in_list.add(ing);
				}
				
			
			
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Log.d("Parser",recipes_list.toString());
		return in_list;
		
		
	}
}
