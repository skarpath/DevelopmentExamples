package com.example.thepeopleskitchen;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class FavouritesActivity extends Activity {

	ArrayList<Recipe> reclist ;
	ListView lv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favourites);

		
		lv = (ListView) findViewById(R.id.listView1);
		
		reclist = new ArrayList<Recipe>();
		
		loaddata();
		
		
	}

	public void loaddata() {
		final ParseQuery<ParseObject> query = ParseQuery.getQuery("FavRecipe");
		query.whereEqualTo("user", ParseUser.getCurrentUser());
		query.findInBackground(new FindCallback<ParseObject>() {

			@Override
			public void done(List<ParseObject> list,
					com.parse.ParseException ex) {
				// TODO Auto-generated method stub
				if (ex == null) {
					for (ParseObject p : list) {
		
						Recipe r = new Recipe();
						r.setRecipe_id(p.getString("recipe_id"));
						r.setTitle(p.getString("title"));
						r.setImage_url(p.getString("image_url"));
						r.setPublisher(p.getString("publisher"));
						
						r.setPublisher_url(p.getString("publisher_url"));
						r.setRank(p.getString("rank"));
						r.setSource_url(p.getString("source_url"));
						r.setRecipe_url(p.getString("recipe_url"));
						
						reclist.add(r);
					}
					
				} else {
					Log.d("logf", "Error: " + ex.getMessage());
				}
			}
		});
		
		RecipeAdapter adapter = new RecipeAdapter(FavouritesActivity.this,
				R.layout.row_item, reclist);
		
		adapter.setNotifyOnChange(true);
		
		lv.setAdapter(adapter);
		
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
				Recipe rr = reclist.get(position);
				
				RecipesListActivity.rinfav(rr);
		
				Intent intent = new Intent(FavouritesActivity.this,
						PreviewActivity.class);
				intent.putExtra("Rec", reclist.get(position));
			
				startActivity(intent);
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.favourites, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
		return super.onOptionsItemSelected(item);
	}
}
