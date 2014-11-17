package com.example.xmlparsertest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SoldevBookSQLiteHelper extends SQLiteOpenHelper {
	private final static String DATABASE_NAME = "soldevBook";
	private static int DB_Version = 1;
	
	public SoldevBookSQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DB_Version);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

	}

}
