package com.example.babydayssqlite;

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper{

	// Logcat tag
    private static final String LOG = "MySQLiteHelper";
    
	// Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "RoutineDB";
    
    // Table Names
    private static final String TABLE_FEED_MILK = "feed_milk";
    private static final String TABLE_DIAPER = "diaper";
    private static final String TABLE_SLEEP = "sleep";
    private static final String TABLE_MILESTONE = "milestone";
    private static final String TABLE_DIARY = "diary";
    
    // feed_milk Table Columns names
    private static final String KEY_MILK_ID = "id";
    private static final String KEY_MILK_DATE = "date";
    private static final String KEY_MILK_TIME = "time";
    private static final String KEY_MILK_OZ = "oz";
    private static final String[] MILK_COLUMNS = {KEY_MILK_ID,KEY_MILK_DATE,KEY_MILK_TIME,KEY_MILK_OZ};
    
 // diaper Table Columns names
    private static final String KEY_DIAPER_ID = "id";
    private static final String KEY_DIAPER_DATE = "date";
    private static final String KEY_DIAPER_TIME = "time";
    private static final String KEY_DIAPER_TYPE = "type";
    private static final String[] DIAPER_COLUMNS = {KEY_DIAPER_ID,KEY_DIAPER_DATE,KEY_DIAPER_TIME,KEY_DIAPER_TYPE};
    
 
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create feed_milk table
        String CREATE_FEED_MILK_TABLE = "CREATE TABLE feed_milk ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
                "date TEXT, "+
                "time TEXT, "+
                "oz   INTEGER )";
 
        // create feed_milk table
        db.execSQL(CREATE_FEED_MILK_TABLE);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older feed_milk table if existed
        db.execSQL("DROP TABLE IF EXISTS feed_milk");
 
        // create fresh books table
        this.onCreate(db);
    }
    //---------------------------------------------------------------------
 
    /**
     * CRUD operations (create "add", read "get", update, delete)  + get all  + delete all 
     */
 
    public void addFeedMilk(Milk milk){
        Log.d("addBook", milk.toString());
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_MILK_DATE, milk.getDate()); // get date 
        values.put(KEY_MILK_TIME, milk.getTime()); // get time
        values.put(KEY_MILK_OZ, milk.getOZ()); //get oz
        
 
        // 3. insert
        db.insert(TABLE_FEED_MILK, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values
 
        // 4. close
        db.close(); 
    }
 
    public Milk getFeedMilk(int id){
 
        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();
 
        // 2. build query
        Cursor cursor = 
                db.query(TABLE_FEED_MILK, // a. table
                MILK_COLUMNS, // b. column names
                " id = ?", // c. selections 
                new String[] { String.valueOf(id) }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
 
        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
 
        // 4. build milk object
        Milk milk = new Milk();
        milk.setId(Integer.parseInt(cursor.getString(0)));
        milk.setDate(cursor.getString(1));
        milk.setTime(cursor.getString(2));
        milk.setOZ(cursor.getInt(3));
 
        Log.d("getFeedMilk("+id+")", milk.toString());
 
        // 5. return milk
        return milk;
    }
 
    // Get All Books
    public List<Milk> getAllFeedMilk() {
        List<Milk> feed_milk = new LinkedList<Milk>();
 
        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_FEED_MILK;
 
        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
 
        // 3. go over each row, build milk and add it to list
        Milk milk = null;
        if (cursor.moveToFirst()) {
            do {
            	milk = new Milk();
            	milk.setId(Integer.parseInt(cursor.getString(0)));
                milk.setDate(cursor.getString(1));
                milk.setTime(cursor.getString(2));
                milk.setOZ(cursor.getInt(3));
 
                // Add book to books
                feed_milk.add(milk);
            } while (cursor.moveToNext());
        }
 
        Log.d("getAllFeedMilkActivities()", feed_milk.toString());
 
        // return books
        return feed_milk;
    }
 
     // Updating single milk
    public int updateFeedMilk(Milk milk) {
 
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_MILK_DATE, milk.getDate()); // get date 
        values.put(KEY_MILK_TIME, milk.getTime()); // get time
        values.put(KEY_MILK_OZ, milk.getOZ()); //get oz
 
        // 3. updating row
        int i = db.update(TABLE_FEED_MILK, //table
                values, // column/value
                KEY_MILK_ID+" = ?", // selections
                new String[] { String.valueOf(milk.getId()) }); //selection args
 
        // 4. close
        db.close();
 
        return i;
 
    }
 
    // Deleting single book
    public void deleteFeedMilk(Milk milk) {
 
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
        // 2. delete
        db.delete(TABLE_FEED_MILK,
                KEY_MILK_ID+" = ?",
                new String[] { String.valueOf(milk.getId()) });
 
        // 3. close
        db.close();
 
        Log.d("deleteMilk", milk.toString());
 
    }
}
