package com.example.xmlparsertest;

import java.util.ArrayList;

import com.example.xmlparsertest.MainActivity.BookItem;
import com.example.xmlparsertest.MainActivity.UserItem;

public interface ISoldevBookDataProvider {
	
	/*
	 * ���� ���
	 */
	public void addBookItems(ArrayList<BookItem> items);
	
	/*
	 * å ��� ��ȸ
	 */
	public ArrayList<BookItem> getBookItems();

	/*
	 * ISBN���� å �˻�
	 */
	public BookItem getBookItem();
	
	/*
	 * ���� ����
	 */
	public void lendBooks(ArrayList<BookItem> items, UserItem user);
	
	/*
	 * ���� �ݳ�
	 */
	public void returnBooks(ArrayList<BookItem> items, UserItem user);

}
