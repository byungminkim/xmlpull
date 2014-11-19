package com.example.xmlparsertest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainPage extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setEventListener();
	}

	private void setEventListener() {
		((Button)findViewById(R.id.btn_mine)).setOnClickListener(this);
		((Button)findViewById(R.id.btn_all)).setOnClickListener(this);
		((Button)findViewById(R.id.btn_lending)).setOnClickListener(this);
		((Button)findViewById(R.id.btn_return)).setOnClickListener(this);
		((Button)findViewById(R.id.btn_request)).setOnClickListener(this);
	}
	
	@SuppressWarnings("rawtypes")
	private void moveToPage(Class toPage){
		Intent intent = new Intent(this, toPage);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);	
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.btn_mine:
			moveToPage(MyLibraryPage.class);
			break;
			
		case R.id.btn_all:
			moveToPage(ShowAllBookPage.class);
			break;
			
		case R.id.btn_lending:
			moveToPage(LendingPage.class);
			break;
			
		case R.id.btn_return:
			moveToPage(ReturnPage.class);
			break;
			
		case R.id.btn_request:
			moveToPage(RequestPage.class);
			break;	
			
		case R.id.btn_register:
			moveToPage(RegisterPage.class);
			break;	
		}
	}
	
	
	
}
