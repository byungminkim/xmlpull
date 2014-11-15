package com.example.xmlparsertest;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	private final String TAG = "Main";
	private final String mIsbnUrl = "http://book.interpark.com/api/search.api";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ArrayList<BookItem> items = new ArrayList<BookItem>();
		try {
//			String isbnCode = "9788996603139";
			String isbnCode = "9788932916200";

			String userKey = "672DC494E29F75F40A38931508CD19AF96653A82A502146C58A62766FFA2AC61";
			
			Map<String, String> params = new HashMap<String, String>();
			
			params.put("key", userKey);
			params.put("query", isbnCode);
			params.put("queryType", "isbn");
			
			new PullParserTask(mIsbnUrl, params, items).execute();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public class PullParserTask extends AsyncTask<Void, Void, Void>{

		private ArrayList<BookItem> mBookItems = null;
		private URL mURL = null;
		
		public PullParserTask(String url, Map<String,String> params, ArrayList<BookItem> bookItems) throws MalformedURLException {
			this.mURL = new URL(getGetURLString(url, params));
			this.mBookItems = bookItems;
		}
		
		private String getGetURLString(String url, Map<String,String> params){
			StringBuilder sb = new StringBuilder(url);
			
			if(params != null && !params.isEmpty()){
				sb.append("?");
				
				for(String key : params.keySet()){
					sb.append(key);
					sb.append("=");
					sb.append(params.get(key));
					sb.append("&");
				}
			}
			
			Log.i(TAG,"[getGetURLString]url : " + sb.toString());
			return sb.toString();
		}

		@Override
		protected Void doInBackground(Void... params) {
			
			try {
				XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
				XmlPullParser parser = factory.newPullParser();
				
				HttpURLConnection urlConnection = (HttpURLConnection) mURL.openConnection();
				
				InputStream in = urlConnection.getInputStream();
				parser.setInput(in, "utf-8");
				
				int eventType = parser.getEventType();
				boolean isItemTag = false;
				
				BookItem item = null;
				String tagName = "";

				while(eventType != XmlPullParser.END_DOCUMENT){
					
					if(eventType == XmlPullParser.START_TAG){
						tagName = parser.getName();

						if(tagName.equals("item")){
							item = new BookItem();
							isItemTag = true;
						}
						
					}else if(eventType == XmlPullParser.END_TAG){
						tagName = parser.getName();

						if(tagName.equals("item")){
							mBookItems.add(item);
							isItemTag = false;
						}
						
						if(isItemTag){
							eventType = parser.nextTag();
							continue;
						}
						
					}else if(eventType == XmlPullParser.TEXT && isItemTag){
						
						if(tagName.equals("title")){
							item.title = parser.getText();

						}else if(tagName.equals("description")){
							item.description = parser.getText();

						}else if(tagName.equals("pubDate")){
							item.pubDate = parser.getText();

						}else if(tagName.equals("coverSmallUrl")){
							item.coverSmallUrl = parser.getText();

						}else if(tagName.equals("coverLargeUrl")){
							item.coverLargeUrl = parser.getText();

						}else if(tagName.equals("publisher")){
							item.publisher = parser.getText();

						}else if(tagName.equals("author")){
							item.author = parser.getText();

						}else if(tagName.equals("isbn")){
							item.isbn = parser.getText();

						}
					}
					eventType = parser.next();
				}
				
			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			for(BookItem item : mBookItems){
				Log.i(TAG,"[onPostExecute]title : " + item.title);
				Log.i(TAG,"[onPostExecute]description : " + item.description);
				Log.i(TAG,"[onPostExecute]pubDate : " + item.pubDate);
				Log.i(TAG,"[onPostExecute]coverSmallUrl : " + item.coverSmallUrl);
				Log.i(TAG,"[onPostExecute]coverLargeUrl : " + item.coverLargeUrl);
				Log.i(TAG,"[onPostExecute]publisher : " + item.publisher);
				Log.i(TAG,"[onPostExecute]author : " + item.author);
				Log.i(TAG,"[onPostExecute]isbn : " + item.isbn);
			}
		}
	}
	
	public class BookItem{
		public String title;
		public String description;
		public String pubDate;
		public String coverSmallUrl;
		public String coverLargeUrl;
		public String publisher;
		public String author;
		public String isbn;
	}

}
