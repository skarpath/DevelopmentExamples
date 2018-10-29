package com.example.thepeopleskitchen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class RecipesListActivity extends Activity {

	ListView lv;
	ArrayList<Recipe> recipe_list;
	ProgressDialog PD;
	String url, requestURL;
	int pagecount; 
	Button seebtn;
	int count;
	int check=0,f;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipes_list);
		
		Parse.initialize(this, "NqOWOEYaN8yrTudxum38RVxV6Zx7idHilVszgCZR",
				"gKqM0Spi9jTS2lf25CA2KCWsHoHUlcND8zYiBkPT");
		
		//RECIPE LIST 
		recipe_list = new ArrayList<Recipe>();
		requestURL = null;
		
		lv = (ListView) findViewById(R.id.listView1);
		seebtn = (Button)findViewById(R.id.sendsmsbtn);
		
		loadData async = new loadData();
		
		url = getIntent().getExtras().getString("NEW_URL");
		
		pagecount = getIntent().getExtras().getInt("PAGE");
			
		Log.d("log", "pagecount = "+ pagecount);
		
		requestURL = url + pagecount;
		
		async.execute(requestURL);

		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
				Recipe rr = recipe_list.get(position);
				
				rinfav(rr);
				
//				Log.d("log","f = "+f);
				
				Intent intent = new Intent(RecipesListActivity.this,
						PreviewActivity.class);
				intent.putExtra("Rec", recipe_list.get(position));
				
//				intent.putExtra("fav", f);
				
				startActivity(intent);
			}

		});
		
		seebtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(RecipesListActivity.this, RecipesListActivity.class);
				
				i.putExtra("NEW_URL", url);
				
				count = pagecount +1;
				
				i.putExtra("PAGE", count);
				
				Log.d("log",url + count);
				
				startActivity(i);
				
				finish();
				
				
			}
		});
	}
	public static void rinfav(Recipe r) {
		
		
		Log.d("log1",r.toString());
		// TODO Auto-generated method stub
		ParseQuery<ParseObject> query = ParseQuery.getQuery("FavRecipe");
		query.whereEqualTo("user", ParseUser.getCurrentUser());
		query.whereEqualTo("recipe_id", r.recipe_id);
		query.findInBackground(new FindCallback<ParseObject>() {
			
			
			@Override
			public void done(List<ParseObject> list, ParseException ex) {
				// TODO Auto-generated method stub
				Log.d("log","in rinfav method");
				if(list.size()>0)
				{
					Log.d("log","Recipe exists in favorites");
//					check=1;
					PreviewActivity.favbtn.setImageResource(R.drawable.red);
				}
				else if(list.size()==0){
					Log.d("log","Recipe not in favorites");
//					check=0;
					PreviewActivity.favbtn.setImageResource(R.drawable.black);
				}
				else{
					Log.d("log","ERROR");
				}
				
			}
			
		});
		return;
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

//		if (id == R.id.menu_Trending) {
//			Intent intent = new Intent(getApplicationContext(),
//					RecipesListActivity.class);
//			startActivity(intent);
//		}
//
//		if (id == R.id.menu_Trending) {
//			Intent intent = new Intent(getApplicationContext(),
//					RecipesListActivity.class);
//			startActivity(intent);
//		}

		if (id == R.id.menu_Logout) {
			ParseUser.logOut();

			Toast.makeText(getApplicationContext(), "You were successfully logged out",
					Toast.LENGTH_SHORT).show();
			ParseUser currentUser = ParseUser.getCurrentUser();

			Intent intent = new Intent(getApplicationContext(),
					MainActivity.class);
			startActivity(intent);
			
			Log.d("log", "User Logged Out successfully");
		}
		
		// view favorites
				if (id == R.id.menu_viewall) {
					 Intent i = new Intent(RecipesListActivity.this,FavouritesActivity.class);
					 startActivity(i);

				}

				// clear favorites
				if (id == R.id.menu_clearall) {
					RecipesActivity.deleteallfav();
				}
		return super.onOptionsItemSelected(item);
	}

	class loadData extends AsyncTask<String, Void, ArrayList<Recipe>> {

		@Override
		protected ArrayList<Recipe> doInBackground(String... params) {
			// TODO Auto-generated method stub
			
			Log.d("log", "In async task doInBackground");
			
			URL request = null;
			try {
				request = new URL(params[0]);

				Log.d("request", request.toString());

				HttpURLConnection con = (HttpURLConnection) request
						.openConnection();
				con.setRequestMethod("GET");
				con.connect();

				Log.d("log", "Connected");
				int statusCode = con.getResponseCode();
				if (statusCode == HttpURLConnection.HTTP_OK) {
					InputStream in = con.getInputStream();
					BufferedReader BF = new BufferedReader(
							new InputStreamReader(con.getInputStream()));
					StringBuilder Str = new StringBuilder();
					String line = BF.readLine();

					while (line != null) {
						Str.append(line);
						line = BF.readLine();
					}
					//Log.d("tag1", Str.toString());
					ParseFood parser = new ParseFood();

					recipe_list = parser.ParseJson(Str.toString());

					//Log.d("tag1", recipe_list.toString());

					return recipe_list;

				}

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			Log.d("log", "In async task preexecute");
			PD = new ProgressDialog(RecipesListActivity.this);
			PD.setMessage("Loading Data ...");
			PD.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			PD.show();
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(ArrayList<Recipe> result) {

			
			Log.d("log", "In async task postexecute");
			PD.dismiss();

			RecipeAdapter adapter = new RecipeAdapter(RecipesListActivity.this,
					R.layout.row_item, result);
			
			adapter.setNotifyOnChange(true);
			
			lv.setAdapter(adapter);
			
			super.onPostExecute(result);
		}

	}
}
