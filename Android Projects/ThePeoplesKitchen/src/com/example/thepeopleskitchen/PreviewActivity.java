package com.example.thepeopleskitchen;

import java.util.List;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PreviewActivity extends Activity {

	public static final String RID = "RID";
	int check;
	static final String MY_PREFS_NAME = "Favs";

	// static final String SEARCH_FAVS = "favs";
	// static final String SHARED_PREF = "SharedPerf";
	// int FavSize;

	Recipe r;
	public static ImageButton favbtn;
	int s ;
	String currentUser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preview);

		Parse.initialize(this, "NqOWOEYaN8yrTudxum38RVxV6Zx7idHilVszgCZR",
				"gKqM0Spi9jTS2lf25CA2KCWsHoHUlcND8zYiBkPT");
		
//		s = getIntent().getExtras().getInt("fav");
		r = (Recipe) getIntent().getSerializableExtra("Rec");

		favbtn = (ImageButton) findViewById(R.id.favbtn);
		
		
//		Log.d("log","s= "+s);
		
//		if(s==1)
//		{
//			favbtn.setImageResource(R.drawable.red);
//		}
//		else{
//			favbtn.setImageResource(R.drawable.black);
//		}
//		
		// getCurrentUser();

		TextView tv1 = (TextView) findViewById(R.id.ingtextview);
		tv1.setText(r.getTitle());

		ImageView iv1 = (ImageView) findViewById(R.id.imageView1);
		Picasso.with(getApplicationContext()).load(r.getImage_url()).into(iv1);

		TextView tv2 = (TextView) findViewById(R.id.textView2);

		tv2.setText("\nPosted By: \t" + r.getPublisher()
				+ "\n\nSocial Rank: \t" + Double.parseDouble(r.getRank()));

		// View Recipe Button
		findViewById(R.id.viewbtn).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent inIntent = new Intent(PreviewActivity.this,
								ViewActivity.class);
						// inIntent.putExtra(RID, r.getRecipe_id());
						inIntent.putExtra("RECIPE", r);
						Log.d("URLdemo", RID + "" + r.getRecipe_id());

						startActivity(inIntent);

					}
				});

		// Share Recipe Button
		findViewById(R.id.sharebtn).setOnClickListener(
				new View.OnClickListener() {

					// send the Recipe URL in a text message
					@Override
					public void onClick(View v) {
						Intent inIntent = new Intent(PreviewActivity.this,
								ContactActivity.class);
						// inIntent.putExtra(RID, r.getRecipe_id());
						inIntent.putExtra("RECIPE", r);
						startActivity(inIntent);

					}
				});

		findViewById(R.id.favbtn).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub

					
						rinfav();
//						if(rinfav()==1)
//						{
////							favbtn.setImageResource(R.drawable.black);
////							deletefav();
//							Toast.makeText(getApplicationContext(), "Recipe deleted from favourites", Toast.LENGTH_LONG).show();
//							
//						}
//						else{
////							favbtn.setImageResource(R.drawable.red);
////
////							savefav();
//
//							Toast.makeText(getApplicationContext(), "Recipe added to favourites", Toast.LENGTH_LONG).show();
//							
//						}
//						
					}

					

				});

	}

	public void rinfav() {
	
		// TODO Auto-generated method stub
		ParseQuery<ParseObject> query = ParseQuery.getQuery("FavRecipe");
		query.whereEqualTo("user", ParseUser.getCurrentUser());
		query.whereEqualTo("recipe_id", r.recipe_id);
		query.findInBackground(new FindCallback<ParseObject>() {
			
			@Override
			public void done(List<ParseObject> list, ParseException ex) {
				// TODO Auto-generated method stub
				Log.d("demo",r.toString());
				if(list.size()>0)
				{
					Log.d("logp","Recipe exists in favorites");
//					check=1;
					deletefav();
					
				}
				else{
					Log.d("logp","Recipe not in favorites");
//					check=0;
					savefav();
					
				}
			}
			
		});
		return ;
		
	}

	// private void getCurrentUser() {
	// // TODO Auto-generated method stub
	// SharedPreferences settings = getSharedPreferences(SHARED_PREF,0);
	// String temp = settings.getString("currentUser", "");
	//
	// this.currentUser = temp;
	// Log.d("currentUser",temp);
	//
	// }

	public void deletefav() {
		// TODO Auto-generated method stub
		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("FavRecipe");
		query.whereEqualTo("user", ParseUser.getCurrentUser());
		query.whereEqualTo("recipe_id", r.recipe_id);
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
		favbtn.setImageResource(R.drawable.black);
		
	}

	public void savefav() {
		// TODO Auto-generated method stub
		
		final ParseObject recipe = new ParseObject("FavRecipe");
		recipe.put("user", ParseUser.getCurrentUser());
		recipe.put("recipe_id", r.getRecipe_id());
		recipe.put("title",r.getTitle() );
		recipe.put("publisher", r.getPublisher());
		recipe.put("image_url", r.getImage_url());
		recipe.put("recipe_url",r.getRecipe_url());
		recipe.put("rank",r.getRank());
		recipe.put("publisher_url", r.getPublisher_url() );
		recipe.put("source_url", r.getSource_url());
		
		recipe.saveInBackground(new SaveCallback() {
			
			@Override
			public void done(ParseException e) {
				// TODO Auto-generated method stub
				if(e == null) {
					Log.d("log", "Save successful");
				} else {
					Toast.makeText(getApplicationContext(), "Save failed", Toast.LENGTH_SHORT).show();
				}
			}
		});
		favbtn.setImageResource(R.drawable.red);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
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
		return super.onOptionsItemSelected(item);
	}
}
