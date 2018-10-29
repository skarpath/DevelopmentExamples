package com.example.thepeopleskitchen;

import java.util.List;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RecipesActivity extends Activity {

	Button search, trending, toprated;
	EditText et1;
	// static final String SEARCH_KEY = "search";
	// static final String KEY = "key";
	// static final String COUNT = "page";
	String API_key;
	String URL;
	String keyword;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipes);

		keyword = "";
		API_key = "6cf2b31d9d002211d4b2ee3759591135";

		search = (Button) findViewById(R.id.viewbtn);
		trending = (Button) findViewById(R.id.newuserbtn);
		toprated = (Button) findViewById(R.id.ratedbtn);
		et1 = (EditText) findViewById(R.id.username);

		trending.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// keyword = et1.getText().toString();

				Intent i = new Intent(RecipesActivity.this,
						RecipesListActivity.class);
				URL = "http://food2fork.com/api/search?key=" + API_key
						+ "&sort=t&page=";
				// i.putExtra("KEY", "t");
				// i.putExtra("SEARCH_KEY", keyword);
				// i.putExtra("COUNT", 1);

				i.putExtra("NEW_URL", URL);
				i.putExtra("PAGE", 1);

				startActivity(i);
			}
		});

		toprated.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// keyword = et1.getText().toString();

				Intent i = new Intent(RecipesActivity.this,
						RecipesListActivity.class);

				URL = "http://food2fork.com/api/search?key=" + API_key
						+ "&sort=r&page=";

				// i.putExtra("KEY", "t");
				// i.putExtra("SEARCH_KEY", keyword);
				// i.putExtra("COUNT", 1);

				i.putExtra("NEW_URL", URL);
				i.putExtra("PAGE", 1);

				startActivity(i);
			}
		});

		search.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				keyword = et1.getText().toString();
				if (keyword.equals("") || keyword.equals(" ")) {
					Toast.makeText(getApplicationContext(),
							"Search keyword cannot be empty",
							Toast.LENGTH_SHORT).show();
					// Intent i = new Intent(RecipesActivity.this,
					// RecipesActivity.class);
					// startActivity(i);
				} else {
					Intent i = new Intent(RecipesActivity.this,

					RecipesListActivity.class);

					URL = "http://food2fork.com/api/search?key=" + API_key
							+ "&q=" + keyword + "&page=";

					// i.putExtra("KEY", "t");
					// i.putExtra("SEARCH_KEY", keyword);
					// i.putExtra("COUNT", 1);

					i.putExtra("NEW_URL", URL);
					i.putExtra("PAGE", 1);

					startActivity(i);
				}

			}
		});
	}

	public static void deleteallfav() {
		ParseQuery<ParseObject> query = ParseQuery.getQuery("FavRecipe");
		query.whereEqualTo("user", ParseUser.getCurrentUser());
	
		query.findInBackground(new FindCallback<ParseObject>() {
			
			@Override
			public void done(List<ParseObject> list, ParseException ex) {
				// TODO Auto-generated method stub
				if(list.size()>0)
				{
					for(ParseObject p : list)
					{
						p.deleteInBackground();
					}
				}
				else{
					
				}
			}
			
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_one, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		// if (id == R.id.menu_Toprated) {
		// Intent i = new
		// Intent(RecipesActivity.this,RecipesListActivity.class);
		// i.putExtra(KEY, "r");
		// i.putExtra(SEARCH_KEY, keyword);
		// startActivity(i);
		// return true;
		// }
		//
		// if (id == R.id.menu_Trending) {
		// Intent i = new
		// Intent(RecipesActivity.this,RecipesListActivity.class);
		// i.putExtra(KEY, "t");
		// i.putExtra(SEARCH_KEY, keyword);
		// startActivity(i);
		// return true;
		// }

		// Log out
		if (id == R.id.menu_Logout) {
			ParseUser.logOut();

			Toast.makeText(getApplicationContext(),
					"You were successfully logged out", Toast.LENGTH_SHORT)
					.show();
			ParseUser currentUser = ParseUser.getCurrentUser();

			Intent intent = new Intent(getApplicationContext(),
					MainActivity.class);
			startActivity(intent);
		}

		// view favorites
		if (id == R.id.menu_viewall) {
			 Intent i = new Intent(RecipesActivity.this,FavouritesActivity.class);
			 startActivity(i);

		}

		// clear favorites
		if (id == R.id.menu_clearall) {
			deleteallfav();
		}
		return super.onOptionsItemSelected(item);
	}
}
