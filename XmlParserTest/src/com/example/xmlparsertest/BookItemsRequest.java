package com.example.xmlparsertest;

import java.util.ArrayList;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.example.xmlparsertest.MainActivity.BookItem;

public class BookItemsRequest extends Request<ArrayList<BookItem>> {
	private Callback callback;
	
	public BookItemsRequest(int method, String url, Callback callback, ErrorListener listener) {
		super(method, url, listener);
		
		callback = callback;
	}
	public BookItemsRequest(int method, String url, ErrorListener listener) {
		super(method, url, listener);
	}

	@Override
	protected void deliverResponse(ArrayList<BookItem> items) {
		callback.deliverToCallback(items);
		
	}

	@Override
	protected Response<ArrayList<BookItem>> parseNetworkResponse(
			NetworkResponse arg0) {
		return null;
	}

	public interface Callback{
		void deliverToCallback(ArrayList<BookItem> items);
	}
}
