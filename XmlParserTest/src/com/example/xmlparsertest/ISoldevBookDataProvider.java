package com.example.xmlparsertest;

import java.util.ArrayList;

import com.example.xmlparsertest.MainActivity.BookItem;
import com.example.xmlparsertest.MainActivity.UserItem;

public interface ISoldevBookDataProvider {
	
	/*
	 * 도서 등록
	 */
	public void addBookItems(ArrayList<BookItem> items);
	
	/*
	 * 책 목록 조회
	 */
	public ArrayList<BookItem> getBookItems();

	/*
	 * ISBN으로 책 검색
	 */
	public BookItem getBookItem();
	
	/*
	 * 도서 대출
	 */
	public void lendBooks(ArrayList<BookItem> items, UserItem user);
	
	/*
	 * 도서 반납
	 */
	public void returnBooks(ArrayList<BookItem> items, UserItem user);

}
