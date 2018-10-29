package com.example.thepeopleskitchen;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ContactActivity extends Activity {

	Button selectbtn;
	ListView listView;
	ArrayAdapter<String> adapter;
	String output = new String();
	ArrayList<String> contactname;
	ArrayList<String> contactno;
	ArrayList<String> sports;
	Recipe r ;
	
	public void fetchContacts() {

		Log.d("log", "fetch contacts");

		String phoneNumber = null;
		Uri CONTENT_URI = ContactsContract.Contacts.CONTENT_URI;
		String _ID = ContactsContract.Contacts._ID;
		String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
		String HAS_PHONE_NUMBER = ContactsContract.Contacts.HAS_PHONE_NUMBER;
		Uri PhoneCONTENT_URI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
		String Phone_CONTACT_ID = ContactsContract.CommonDataKinds.Phone.CONTACT_ID;
		String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;
		ContentResolver contentResolver = getContentResolver();
		Cursor cursor = contentResolver.query(CONTENT_URI, null, null, null,
				null);
		if (cursor.getCount() > 0) {
			while (cursor.moveToNext()) {
				String contact_id = cursor
						.getString(cursor.getColumnIndex(_ID));
				String name = cursor.getString(cursor
						.getColumnIndex(DISPLAY_NAME));
				int hasPhoneNumber = Integer.parseInt(cursor.getString(cursor
						.getColumnIndex(HAS_PHONE_NUMBER)));
				if (hasPhoneNumber > 0) {

					// output.append("\n First Name:" + name);
					Cursor phoneCursor = contentResolver.query(
							PhoneCONTENT_URI, null, Phone_CONTACT_ID + " = ?",
							new String[] { contact_id }, null);

					while (phoneCursor.moveToNext()) {

						phoneNumber = phoneCursor.getString(phoneCursor
								.getColumnIndex(NUMBER));
						output = "" + name + "\n"
								+ phoneNumber;
					}
					contactname.add(name);
					contactno.add(phoneNumber);
					sports.add(output.toString());
					// output = null;
					phoneCursor.close();

				}
			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact);

		sports = new ArrayList<String>();
		contactname = new ArrayList<String>();
		contactno = new ArrayList<String>();

		fetchContacts();

		Log.d("log", "oncreate");

		listView = (ListView) findViewById(R.id.list);
		selectbtn = (Button) findViewById(R.id.testbutton);

		r = (Recipe) getIntent().getSerializableExtra("RECIPE");
		
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_multiple_choice, sports);
		
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		listView.setAdapter(adapter);

		selectbtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Log.d("log", "select clicked");

				SparseBooleanArray checked = listView.getCheckedItemPositions();
				ArrayList<String> selectedname = new ArrayList<String>();
				ArrayList<String> selectedno = new ArrayList<String>();

				for (int i = 0; i < checked.size(); i++) {
					// Item position in adapter
					int position = checked.keyAt(i);
					// Add sport if it is checked i.e.) == TRUE!
					if (checked.valueAt(i)) {
						selectedname.add(contactname.get(position));
						selectedno.add(contactno.get(position));
					}

				}

				Intent intent = new Intent(getApplicationContext(),
						SMSActivity.class);

				intent.putStringArrayListExtra("CNAME", selectedname);
				intent.putStringArrayListExtra("CNO", selectedno);
				intent.putExtra("RECIPE", r);
				
				Log.d("log",selectedname.toString() + "\n" + selectedno.toString());
				// start the ResultActivity
				startActivity(intent);

			}
		});

	}
}
