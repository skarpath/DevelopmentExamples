package com.example.thepeopleskitchen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.example.thepeopleskitchen.RecipesListActivity.loadData;
import com.parse.ParseUser;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewActivity extends Activity {

	String url = null;
	ProgressDialog PD;
	ArrayList<String> in_list;
	TextView t1 , it1;
	Button viewrecipe;
	Recipe r; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_view);
		
		it1 = (TextView) findViewById(R.id.ingtextview);
		it1.setMovementMethod(new ScrollingMovementMethod());
		
		it1.setText("");
		in_list = new ArrayList<String>();
		
		r = (Recipe) getIntent().getSerializableExtra("RECIPE");
		
		//int ID = getIntent().getIntExtra(PreviewActivity.RID,0);

		url = "http://food2fork.com/api/get?key=3432d7cae33142c321c28e2e97d29b02&rId="+ r.getRecipe_id();

		Log.d("URLdemo",url);
		
		loadData async = new loadData();
		async.execute(url);
		
		viewrecipe = (Button) findViewById(R.id.viewrecipe);
		
		viewrecipe.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(r.source_url));
				startActivity(browserIntent);
			}
		});
		
		

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

			Toast.makeText(getApplicationContext(), "You were successfully logged out",
					Toast.LENGTH_SHORT).show();
			ParseUser currentUser = ParseUser.getCurrentUser();

			Intent intent = new Intent(getApplicationContext(),
					MainActivity.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}

	class loadData extends AsyncTask<String, Void, ArrayList<String>> {

		@Override
		protected ArrayList<String> doInBackground(String... params) {
			// TODO Auto-generated method stub
			URL request = null;
			try {
				request = new URL(params[0]);

				HttpURLConnection con = (HttpURLConnection) request
						.openConnection();
				con.setRequestMethod("GET");
				con.connect();

				Log.d("log", "Connected");
				
				int statusCode = con.getResponseCode();
				
				if (statusCode == HttpURLConnection.HTTP_OK) {
					InputStream in = con.getInputStream();
					BufferedReader BF = new BufferedReader(new InputStreamReader(con.getInputStream()));
					StringBuilder Str = new StringBuilder();
					String line = BF.readLine();

					while (line != null) {
						Str.append(line);
						line = BF.readLine();
					}
		
					ParseIngredients parser = new ParseIngredients();

					in_list = parser.ParseJson(Str.toString());

					return in_list;

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
			Log.d("demo", "in preexecute");
			PD = new ProgressDialog(ViewActivity.this);
			PD.setMessage("Loading Data ...");
			PD.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			PD.show();
			super.onPreExecute();
		}

		@SuppressWarnings("unused")
		@Override
		protected void onPostExecute(ArrayList<String> result) {

			PD.dismiss();
			
		//	Log.d("result", result.toString());
			
			
			if(result!=null)
			{
				for(int k = 0 ; k < result.size(); k++)
				{
					it1.setText(it1.getText().toString() + "\n" + (k+1) + ". " + result.get(k));
				}
			}
			
			else{
				it1.setText("\n No ingredients here...");
				
			}
			
			super.onPostExecute(result);
		}

	}
}
