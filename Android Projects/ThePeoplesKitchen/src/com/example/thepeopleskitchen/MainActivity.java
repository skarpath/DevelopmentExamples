package com.example.thepeopleskitchen;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button login, signup, reset, devbtn;
	EditText e1, e2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Parse.initialize(this, "NqOWOEYaN8yrTudxum38RVxV6Zx7idHilVszgCZR",
				"gKqM0Spi9jTS2lf25CA2KCWsHoHUlcND8zYiBkPT");

		login = (Button) findViewById(R.id.viewbtn);
		reset = (Button) findViewById(R.id.resetbtn);
		signup = (Button) findViewById(R.id.newuserbtn);
	//	devbtn = (Button) findViewById(R.id.devbtn);

		e1 = (EditText) findViewById(R.id.username);
		e2 = (EditText) findViewById(R.id.password);

//		devbtn.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Toast.makeText(getApplicationContext(), "DEVELOPERS"
//						+ "\nSunakshi Sharma"
//						+ "\nStephen Ksrpathakis"
//						+ "\nChristopher Ballard", Toast.LENGTH_LONG).show();
//			}
//		});
		
		signup.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Log.d("log", "Sign Up Button clicked");

				Intent i = new Intent(MainActivity.this, SignUpActivity.class);
				startActivity(i);
			}
		});

		login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Log.d("log", "Login Button clicked");

				String un = e1.getText().toString();
				String ps = e2.getText().toString();

				boolean SignInError = false;
				if (un.length() < 1 && SignInError == false) {
					Log.d("log", "ERROR logging in");
					Toast.makeText(getApplicationContext(),
							"ERROR! Username can't be blank",
							Toast.LENGTH_SHORT).show();
					SignInError = true;
				}

				// Check to see if Password is valid
				if (ps.length() < 1 && SignInError == false) {
					Log.d("log", "ERROR logging in");
					Toast.makeText(getApplicationContext(),
							"ERROR! Password field cannot be blank",
							Toast.LENGTH_SHORT).show();
					SignInError = true;
				}

				if (SignInError == false) {

					// Sign In User
					ParseUser.logInInBackground(un, ps, new LogInCallback() {

						@Override
						public void done(ParseUser user, ParseException e) {
							// TODO Auto-generated method stub
							if (user != null) {
								Log.d("log","Log in successful");
								// Hooray! The user is logged in.
								Toast.makeText(getApplicationContext(),
										"Log in successful!",
										Toast.LENGTH_SHORT).show();
								Intent i = new Intent(MainActivity.this,
										RecipesActivity.class);
								startActivity(i);

							} else {
								Log.d("log", "ERROR signing in");
								// Signup failed. Look at the ParseException to
								// see what happened.
								Toast.makeText(
										getApplicationContext(),
										"Error - Please check username/password",
										Toast.LENGTH_SHORT).show();
							}
						}
					});

				}
			}
		});

		reset.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.d("log", "Reset Button clicked");

				e1.setText("");
				e2.setText("");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		// int id = item.getItemId();
		// if (id == R.id.action_settings) {
		// return true;
		// }
		return super.onOptionsItemSelected(item);
	}
}
