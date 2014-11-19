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
	 * 로그인
	 */
	public boolean login(String employeeNum, String phoneNum){
		
		boolean result = false;
		SQLiteDatabase db = openHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT * FROM user WHERE userPhoneNumber = ?", new String[]{employeeNum});
		
		if(cursor != null && cursor.moveToFirst()){
			
			String phoneNumFromDB = "";
			
			// cursor에서 PhoneNumber 가져옴.
			
			if(phoneNumFromDB != null && phoneNumFromDB.equals(phoneNum)){
				// 사용자 정보 저장.
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
		
		
		// 우선 DB 파일을 복사하는 로직 필요함. (로그인 안내 메시지로 하자)
		// 누르면 특정 경로로 파일 복사하는 거. (마이샵에서 찾아서)
		// 내 서재
		/* 1. 현재 시점에 내가 대출한 목록
		select BookItem from book b inner join lending l  on (b.bookid = l.bookid) where l.userid = USERID and l.state = 대출
		 */
		/* 2. 현재 시점 희망 도서 목록
		select BookItem from book b inner join request_book r  on (b.bookid = r.bookid) where r.userid = USERID and r.state = 신청
		 */
		
		// 전체 목록

		// 1. 대출 중
		// select BookItem from book b inner join lending l  on (b.bookid = l.bookid) where l.state = 대출

		// 2. 대출 안된 것들
		// select BookItem from book where state != 등록  AND book_id not in (select book_id from lending where state = 대출)

		// 3. 희망 도서 신청
		// SELECT BOOKITEMS from book where state != "등록" or Y
		
		// 4. 전체보기
		
		
		// 대출 
		// 1. 시작하자마자 바코드 입력
		// - 추가 완료 취소 
		// - 완료하면 대출 테이블 생성 추가
		
		// 반납 
		// 1. 시작하자마자 바코드 입력
		// - 추가 완료 취소 
		// - 완료하면 해당 대출 상태 변경
		
		// Barcode 화면 (반납. 대출. 입력하면 BookItem을 넘겨줌, 등록도 넘겨줌. )
		// 1. 등록
		// - 입력이 되면 DB로부터 유효성 체크해서 이미 있는 것이고 희망도서가 아니면 다시 시도하도록
		// - 
		// 2. 대출 
		// - 해당 책의 북아이디로부터 대출 가능한지 체크함.
		// - 1) 등록된 책인지 체크함. 미등록이면  희망도서로 등록하라고 함.(isbn 초기화)
		// - select book_id from book where isbn = isbn and state = 미등록
		// - 2) 반납되지 않은 도서인지 체크함. 반납부터 하세요. 
		// - select username from user where userid = (select user_id from lending where book_id = (select bookid from book where isbn = "") and state = "대출") 
		// 3. 반납
		// - 해당 책이 현재 사용자가 반납 가능한지 체크함.
		// 
		// 닫기를 눌렀을때 이전 페이지에서 목록에 아무것도 없으면 같이 종료함.
		
		return null;
	}
	
	// 등록여부
	/*
	 * 
	 도서
	 사용자 
	 대출
	 신청
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
