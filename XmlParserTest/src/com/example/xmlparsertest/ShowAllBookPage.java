package com.example.xmlparsertest;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ShowAllBookPage extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_all_books);
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("1");
		list.add("1");
		list.add("1");
		list.add("1");
		list.add("1");
		list.add("1");
		list.add("1");
		list.add("1");
		list.add("1");
		list.add("1");

		ListView lv = (ListView)findViewById(R.id.list_books);
		
		BookItemAdapter adapter = new BookItemAdapter(this, list);
		
		lv.setAdapter(adapter);
		
	}
}
