package com.example.xmlparsertest;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.xmlparsertest.MainActivity.BookItem;
import com.example.xmlparsertest.MainActivity.UserItem;

public class SoldevBookDatabaseMgr implements ISoldevBookDataProvider{
	private SoldevBookSQLiteHelper openHelper = null;
	
	public SoldevBookDatabaseMgr(Context context){
		openHelper = new SoldevBookSQLiteHelper(context);
	}
	
	@Override
	public void addBookItems(ArrayList<BookItem> items) {
		SQLiteDatabase db = openHelper.getWritableDatabase();
		
		db.beginTransaction();
		
		for(BookItem item : items){
			ContentValues contentValues = new ContentValues();
			contentValues.put(key, value);
			contentValues.put(key, value);
			contentValues.put(key, value);
			contentValues.put(key, value);

			db.insert(table, nullColumnHack, values);
		}
		
//		db.insert(table, nullColumnHack, values);
		
		db.setTransactionSuccessful();
		db.endTransaction();
	}

	@Override
	public ArrayList<BookItem> getBookItems() {
		SQLiteDatabase db = openHelper.getReadableDatabase();
		Cursor cursor = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
		
		cursor.
		
		return null;
	}

	@Override
	public BookItem getBookItem() {
		// TODO Auto-generated method stub
		SQLiteDatabase db = openHelper.getReadableDatabase();
		Cursor cursor = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
		
		cursor.
		
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

}
