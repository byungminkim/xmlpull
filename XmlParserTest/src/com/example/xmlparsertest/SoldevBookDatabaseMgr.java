package com.example.xmlparsertest;

import java.util.ArrayList;

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
	
	/*
	 * �α���
	 */
	public boolean login(String employeeNum, String phoneNum){
		
		boolean result = false;
		SQLiteDatabase db = openHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT * FROM user WHERE userPhoneNumber = ?", new String[]{employeeNum});
		
		if(cursor != null && cursor.moveToFirst()){
			
			String phoneNumFromDB = "";
			
			// cursor���� PhoneNumber ������.
			
			if(phoneNumFromDB != null && phoneNumFromDB.equals(phoneNum)){
				// ����� ���� ����.
				loadUserInfo(cursor);
				result = true;
			}
		}
		cursor.close();
		
		return result;
	}
	
	private void loadUserInfo(Cursor cursor){
//		userInfo = new UserInfo();
//		userInfo.
	}
	
	private ArrayList<BookItem> getLendingBooks(){
		
		
		// �켱 DB ������ �����ϴ� ���� �ʿ���. (�α��� �ȳ� �޽����� ����)
		// ������ Ư�� ��η� ���� �����ϴ� ��. (���̼����� ã�Ƽ�)
		// �� ����
		/* 1. ���� ������ ���� ������ ���
		select BookItem from book b inner join lending l  on (b.bookid = l.bookid) where l.userid = USERID and l.state = ����
		 */
		/* 2. ���� ���� ��� ���� ���
		select BookItem from book b inner join request_book r  on (b.bookid = r.bookid) where r.userid = USERID and r.state = ��û
		 */
		
		// ��ü ���

		// 1. ���� ��
		// select BookItem from book b inner join lending l  on (b.bookid = l.bookid) where l.state = ����

		// 2. ���� �ȵ� �͵�
		// select BookItem from book where state != ���  AND book_id not in (select book_id from lending where state = ����)

		// 3. ��� ���� ��û
		// SELECT BOOKITEMS from book where state != "���" or Y
		
		// 4. ��ü����
		
		
		// ���� 
		// 1. �������ڸ��� ���ڵ� �Է�
		// - �߰� �Ϸ� ��� 
		// - �Ϸ��ϸ� ���� ���̺� ���� �߰�
		
		// �ݳ� 
		// 1. �������ڸ��� ���ڵ� �Է�
		// - �߰� �Ϸ� ��� 
		// - �Ϸ��ϸ� �ش� ���� ���� ����
		
		// Barcode ȭ�� (�ݳ�. ����. �Է��ϸ� BookItem�� �Ѱ���, ��ϵ� �Ѱ���. )
		// 1. ���
		// - �Է��� �Ǹ� DB�κ��� ��ȿ�� üũ�ؼ� �̹� �ִ� ���̰� ��������� �ƴϸ� �ٽ� �õ��ϵ���
		// - 
		// 2. ���� 
		// - �ش� å�� �Ͼ��̵�κ��� ���� �������� üũ��.
		// - 1) ��ϵ� å���� üũ��. �̵���̸�  ��������� ����϶�� ��.(isbn �ʱ�ȭ)
		// - select book_id from book where isbn = isbn and state = �̵��
		// - 2) �ݳ����� ���� �������� üũ��. �ݳ����� �ϼ���. 
		// - select username from user where userid = (select user_id from lending where book_id = (select bookid from book where isbn = "") and state = "����") 
		// 3. �ݳ�
		// - �ش� å�� ���� ����ڰ� �ݳ� �������� üũ��.
		// 
		// �ݱ⸦ �������� ���� ���������� ��Ͽ� �ƹ��͵� ������ ���� ������.
		
		return null;
	}
	
	// ��Ͽ���
	/*
	 * 
	 ����
	 ����� 
	 ����
	 ��û
	 */
	private void addLendingBooks(){
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
