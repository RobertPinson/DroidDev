package com.example.myfirstapp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final ListView listview = (ListView) findViewById(R.id.listview_bills);
	    String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
	        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
	        "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
	        "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
	        "Android", "iPhone", "WindowsMobile" };

	    final ArrayList<String> list = new ArrayList<String>();
	    for (int i = 0; i < values.length; ++i) {
	      list.add(values[i]);
	    }
	    final ArrayAdapter adapter = new ArrayAdapter(this,
	        android.R.layout.simple_list_item_1, list);
	    listview.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void splitMinus(View view) {
		try {
			TextView splitBy = (TextView) findViewById(R.id.edit_splitby);
			int split = Integer.parseInt(splitBy.getText().toString());

			if (split > 0) {
				split--;
			}

			splitBy.setText(String.format("%02d", split));
		} catch (NumberFormatException nfe) {
			System.out.println("Could not parse " + nfe);
		}
	}

	public void splitPlus(View view) {
		try {
			TextView splitBy = (TextView) findViewById(R.id.edit_splitby);
			int split = Integer.parseInt(splitBy.getText().toString());

			if (split < 50) {
				split++;
			}

			splitBy.setText(String.format("%02d", split));
		} catch (NumberFormatException nfe) {
			System.out.println("Could not parse " + nfe);
		}
	}

}
