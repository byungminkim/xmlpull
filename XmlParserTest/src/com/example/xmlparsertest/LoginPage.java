package com.example.xmlparsertest;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginPage extends Activity {

	private EditText etId;
	private EditText etPw;
	private Button btnLogin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		setEventListener();
	}

	private void setEventListener() {
		etId = (EditText)findViewById(R.id.et_id);
		etPw = (EditText)findViewById(R.id.et_pw);
		btnLogin = (Button)findViewById(R.id.btn_login);

		etId.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				checkLoginEnable();
			}
		});
		
		
		etPw.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				checkLoginEnable();
				
			}
		});

		
		/*
		 *  Log-in
		 */
		btnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(login()){
					goMainPage();
				}else {
					new AlertDialog.Builder(LoginPage.this)
	                .setIconAttribute(android.R.attr.alertDialogIcon)
	                .setTitle("입력하신 정보가 맞지 않습니다.\n다시 로그인해주세요.")
	                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
	                    public void onClick(DialogInterface dialog, int whichButton) {
	                    	etPw.setText("");
	                    }
	                }).create().show();			
				}
			}

		});
		
		btnLogin.setEnabled(false);
	}
	
	private boolean login() {
		boolean result = false;
		
		/*
		
		DB
		 */
		return true;
	}
	
	private void goMainPage() {
		Intent intent = new Intent(this, MainPage.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}
	
	private void checkLoginEnable(){
		Editable id = etId.getText();
		Editable pw = etPw.getText();
		
		if(id != null && id.length() == 7 &&
		   pw != null && (pw.length() == 11 || pw.length() == 10)){
			btnLogin.setEnabled(true);
		}else
			btnLogin.setEnabled(false);

	}
}
