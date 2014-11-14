package com.example.xmlparsertest;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	private final String TAG = "Main";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ArrayList<BookItem> items = new ArrayList<BookItem>();
		try {
			new PullParserTask("http://book.interpark.com/api/search.api?key=672DC494E29F75F40A38931508CD19AF96653A82A502146C58A62766FFA2AC61&query=9788996603139&queryType=isbn", items).execute();
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
		
		
		public PullParserTask(String url, ArrayList<BookItem> mBookItems) throws MalformedURLException {
			this.mURL = new URL(url);
			this.mBookItems = mBookItems;
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

		@Override
		protected Void doInBackground(Void... params) {
			
			try {
				InputStream in = mURL.openStream();
				XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
				XmlPullParser parser = factory.newPullParser();
				parser.setInput(in, "utf-8");
				
				String tagName = "";
				int eventType = parser.getEventType();
				boolean isItemTag = false;
				BookItem item = null;
				
				while(eventType != XmlPullParser.END_DOCUMENT){
					
					if(eventType == XmlPullParser.START_TAG){
						tagName = parser.getName();
						Log.i(TAG,"XmlPullParser.START_TAG : " + tagName);

						if(tagName.equals("item")){
							item = new BookItem();
							isItemTag = true;
						}
						
					}else if(eventType == XmlPullParser.END_TAG){
						tagName = parser.getName();
						Log.i(TAG,"XmlPullParser.END_TAG : " + tagName);

						if(tagName.equals("item")){
							mBookItems.add(item);
							isItemTag = false;
						}
						
						eventType = parser.nextTag();
						continue;
						
					}else if(eventType == XmlPullParser.TEXT && isItemTag){
						Log.i(TAG,"XmlPullParser.TEXT : " + tagName);
						
						if(tagName.equals("title")){
							item.title = parser.getText();
							Log.i(TAG,"[onPostExecute]XmlPullParser.TEXT : " + item.title);

						}else if(tagName.equals("description")){
							item.description = parser.getText();
							Log.i(TAG,"[onPostExecute]XmlPullParser.TEXT : " + item.description);

						}else if(tagName.equals("pubDate")){
							item.pubDate = parser.getText();
							Log.i(TAG,"[onPostExecute]XmlPullParser.TEXT : " + item.pubDate);

						}else if(tagName.equals("coverSmallUrl")){
							item.coverSmallUrl = parser.getText();
							Log.i(TAG,"[onPostExecute]XmlPullParser.TEXT : " + item.coverSmallUrl);

						}else if(tagName.equals("coverLargeUrl")){
							item.coverLargeUrl = parser.getText();
							Log.i(TAG,"[onPostExecute]XmlPullParser.TEXT : " + item.coverLargeUrl);

						}else if(tagName.equals("publisher")){
							item.publisher = parser.getText();
							Log.i(TAG,"[onPostExecute]XmlPullParser.TEXT : " + item.publisher);

						}else if(tagName.equals("author")){
							item.author = parser.getText();
							Log.i(TAG,"[onPostExecute]XmlPullParser.TEXT : " + item.author);

						}else if(tagName.equals("isbn")){
							item.isbn = parser.getText();
							Log.i(TAG,"[onPostExecute]XmlPullParser.TEXT : " + item.isbn);

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
