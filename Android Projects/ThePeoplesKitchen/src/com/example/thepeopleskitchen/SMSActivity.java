package com.example.thepeopleskitchen;

import java.util.ArrayList;

import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SMSActivity extends Activity {

	EditText ed1 , ed2;
	Button sendbtn ;
	Recipe r;
	ArrayList<String> names, numbers;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sms);
		
		sendbtn = (Button) findViewById(R.id.sendsmsbtn);
		ed1 = (EditText) findViewById(R.id.editText1);
		ed2 = (EditText) findViewById(R.id.editText2);
		
		names = new ArrayList<String>();
		numbers = new ArrayList<String>();
		
		r = new Recipe();
		r = (Recipe) getIntent().getSerializableExtra("RECIPE");
		
		names = getIntent().getStringArrayListExtra("CNAME");
		numbers = getIntent().getStringArrayListExtra("CNO");
		
		ed1.setText(names.toString());
		
		sendbtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Log.d("log","send button clicked");
				
				String addmsg = ed2.getText().toString();
				
				final StringBuilder msgs = new StringBuilder().append(addmsg).append(" ").append(r.title).append(" Visit: ").append(r.recipe_url);
				
				for(int i = 0; i < numbers.size() ; i++)
				{
					String no = numbers.get(i);
					Log.d("number = ",no);
					if(no.contains("+1"))
					{
						sendSMS(no,msgs.toString());
					}
					 else
					{
						
						sendSMS("+1"+no,msgs.toString());
					}
				}
				Toast.makeText(getApplicationContext(), "Message sent", Toast.LENGTH_SHORT).show();
				Intent i = new Intent(SMSActivity.this,RecipesActivity.class);
				startActivity(i);
				
			}
		});

	}
	
	private void sendSMS(String phoneNumber, String message)
	   {
	       SmsManager sms = SmsManager.getDefault();
	       sms.sendTextMessage(phoneNumber, null, message, null, null);
	       
	       Log.d("log", "in send sms method");
	       
	       //Toast.makeText(getApplicationContext(), "Message sent", Toast.LENGTH_SHORT).show();
	       
	       ed1.setText("");
	       ed2.setText("");
      
	    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
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
}
