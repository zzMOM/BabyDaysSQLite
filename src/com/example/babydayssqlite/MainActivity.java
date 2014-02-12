package com.example.babydayssqlite;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	private MySQLiteHelper dbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dbHelper = new MySQLiteHelper(this);
        
        /**
         * CRUD Operations
         * */
        
		dbHelper.addBabyActivity(new BabyActivity("01-10-2014", "7:00am", "FeedMilk",  "4"));
		dbHelper.addBabyActivity(new BabyActivity("01-10-2014", "10:00am", "FeedMilk", "4"));
		dbHelper.addBabyActivity(new BabyActivity("01-10-2014", "12:00pm", "FeedMilk", "6"));
        
        // get all books
        List<BabyActivity> list = dbHelper.getAllBabyActivity();
        
        // delete one book
        dbHelper.deleteBabyActivity(list.get(0));
        
        // get all books
        dbHelper.getAllBabyActivity();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onDestroy() {
	    super.onDestroy();
	    if (dbHelper != null) {
	        dbHelper.close();
	    }
	}

}
