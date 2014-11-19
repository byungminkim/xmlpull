package com.example.xmlparsertest;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.xmlparsertest.MainActivity.BookItem;
import com.example.xmlparsertest.MainActivity.UserItem;

public class SoldevBookDatabaseMgr implements ISoldevBookDataProvider{
//	private UserInfo userInfo = null;
	
	private SoldevBookSQLiteHelper openHelper = null;
	private Context mContext;
	public SoldevBookDatabaseMgr(Context context){
		openHelper = new SoldevBookSQLiteHelper(context);
		mContext = context;

	}
	
	@Override
	public void addBookItems(ArrayList<BookItem> items) {
//		SQLiteDatabase db = openHelper.getWritableDatabase();
//		
//		db.beginTransaction();
//		
//		for(BookItem item : items){
//			ContentValues contentValues = new ContentValues();
//			contentValues.put(key, value);
//			contentValues.put(key, value);
//			contentValues.put(key, value);
//			contentValues.put(key, value);
//
//			db.insert(table, nullColumnHack, values);
//		}
//		
////		db.insert(table, nullColumnHack, values);
//		
//		db.setTransactionSuccessful();
//		db.endTransaction();
	}
	
	public boolean login(String employeeNum, String phoneNum){
		
		boolean result = true;
		/*
		SQLiteDatabase db = openHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT * FROM user WHERE userPhoneNumber = ?", new String[]{employeeNum});
		
		if(cursor != null && cursor.moveToFirst()){
			
			String phoneNumFromDB = "";
			// PhoneNumber 가져옴.
			
			if(phoneNumFromDB != null && phoneNumFromDB.equals(phoneNum)){
				
				// 사용자 정보 저장.
				loadUserInfo(cursor);
				result = true;
			}
		}
		cursor.close();
		*/
		return result;
	}
	
	private void loadUserInfo(Cursor cursor){
//		userInfo = new UserInfo();
//		userInfo.
	}

	@Override
	public BookItem getBookItem() {
		// TODO Auto-generated method stub
//		SQLiteDatabase db = openHelper.getReadableDatabase();
//		Cursor cursor = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
//		
//		cursor.
//		
		return null;
	}

	@Override
	public void lendBooks(ArrayList<BookItem> items, UserItem user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void returnBooks(ArrayList<BookItem> items, UserItem user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<BookItem> getBookItems() {
		// TODO Auto-generated method stub
		return null;
	}

}
