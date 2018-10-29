package com.example.thepeopleskitchen;

import java.lang.reflect.Field;



import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import android.app.Activity;
import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends Activity {

	ParseUser currentUser = ParseUser.getCurrentUser();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);

		Parse.initialize(this, "NqOWOEYaN8yrTudxum38RVxV6Zx7idHilVszgCZR", "gKqM0Spi9jTS2lf25CA2KCWsHoHUlcND8zYiBkPT");

		//Sign up cancel button
		findViewById(R.id.cancelsignup).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
				startActivity(intent); 
			}
		});

		//Sign up button
		findViewById(R.id.submitbtn).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
				boolean SignUpErrors = false;

				//textViewSignUpError

				//Make varibles for sign up activity fields
				EditText signUpEmail, SignUpPassword, SignUpConfirmPassword,signUpUserName;				

				TextView SignUpEntryError;

				//Add to object listners
				signUpUserName = (android.widget.EditText) findViewById(R.id.username);		
				signUpEmail = (android.widget.EditText) findViewById(R.id.eMail);				
				SignUpPassword = (android.widget.EditText) findViewById(R.id.ps);
				SignUpConfirmPassword = (android.widget.EditText) findViewById(R.id.cps);	

				//Assign them to strings and get value of them
				String str_signUpEmail, str_SignUpPassword, str_signUpConfirmPassword,str_signUpUserName;

				str_signUpUserName = signUpUserName.getText().toString();
				str_signUpEmail = signUpEmail.getText().toString();
				str_SignUpPassword = SignUpPassword.getText().toString();
				str_signUpConfirmPassword = SignUpConfirmPassword.getText().toString();


				//Check username
				if ( str_signUpUserName.length() < 1 && SignUpErrors == false)
				{
					Toast.makeText(getApplicationContext(), "Sign up error: Username field can't be left blank.", Toast.LENGTH_SHORT).show();	
					SignUpErrors = true;
				}

				//Check email
				if ( str_signUpEmail.length() < 1 && SignUpErrors == false)
				{					
					Toast.makeText(getApplicationContext(), "Sign up error: Email field can't be left blank.", Toast.LENGTH_SHORT).show();	
					SignUpErrors = true;
				}
				if ( !str_signUpEmail.contains("@") && SignUpErrors == false)
				{					
					Toast.makeText(getApplicationContext(), "Sign up error: Email is invalid.", Toast.LENGTH_SHORT).show();	
					SignUpErrors = true;
				} 
//				if ( (!str_signUpEmail.contains(".com") || !str_signUpEmail.contains(".edu"))  && SignUpErrors == false )
//				{					
//					Toast.makeText(getApplicationContext(), "Sign up error: Email is invalid.", Toast.LENGTH_SHORT).show();	
//					SignUpErrors = true;
//				}

				//Check password
				if ( SignUpPassword.length() < 1 && SignUpErrors == false )
				{
					Toast.makeText(getApplicationContext(), "Sign up error: password field can't be left blank.", Toast.LENGTH_SHORT).show();	
					SignUpErrors = true;
				} 
				if (SignUpConfirmPassword.length() < 1 && SignUpErrors == false)
				{					
					Toast.makeText(getApplicationContext(), "Sign up error: Please confirm your password ", Toast.LENGTH_SHORT).show();	
					SignUpErrors = true;
				}

				if ( !str_SignUpPassword.equals(str_signUpConfirmPassword) && SignUpErrors == false )
				{
					Toast.makeText(getApplicationContext(), "Sign up error: Password don't match", Toast.LENGTH_SHORT).show();	
					SignUpErrors = true;
				}



				//Check if any errors
				if ( SignUpErrors == false)
				{

					//User sign up
					ParseUser user = new ParseUser();
					user.setUsername(str_signUpUserName);
					user.setPassword(str_SignUpPassword);
					user.setEmail(str_signUpEmail);					

					user.signUpInBackground(new SignUpCallback() {

						@Override
						public void done(com.parse.ParseException e) {
							// TODO Auto-generated method stub
							if (e == null) {
								// Hooray! Let them use the app now.						
								Toast.makeText(getApplicationContext(),"Account created!", Toast.LENGTH_SHORT).show();
								Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
								startActivity(intent);
							
							} else {
								// Sign up didn't succeed. Look at the ParseException
								Toast.makeText(getApplicationContext(),"Sign up error, Please check username/password", Toast.LENGTH_SHORT).show();
								Log.d("signUp Error", e.toString());
							}
						}
					});



				} //End of sign up errors
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void makeActionOverflowMenuShown() {
		//devices with hardware menu button (e.g. Samsung Note) don't show action overflow menu
		try {
			ViewConfiguration config = ViewConfiguration.get(this);
			Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
			if (menuKeyField != null) {
				menuKeyField.setAccessible(true);
				menuKeyField.setBoolean(config, false);
			}
		} catch (Exception e) {
			Log.d("TAG", e.getLocalizedMessage());
		}
	}
}

