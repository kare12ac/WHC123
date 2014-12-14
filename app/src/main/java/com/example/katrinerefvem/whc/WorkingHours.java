package com.example.katrinerefvem.whc;

import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class WorkingHours extends Fragment {
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
      View rootView = inflater.inflate(R.layout.activity_working_hours,container,false);
      return rootView;
  }
        public static final String KEY_ROWID = "_id";
        public static final String KEY_DATE = "_date";
        public static final String KEY_START = "_start_time";
        public static final String KEY_STOP = " _end_time";
        public static final String KEY_TOTAL = "_total_hours";
        public static final String KEY_EARNED = "total_earned";

    private static final String DATABASE_NAME = "WorkingHoursDB";
    private static final String DATABASE_TABLE = "workingTable";
    public static final int DATABASE_VERSION = 1;

   private DbHelper ourHelper;
   private  Context ourContext;
    private SQLiteDatabase ourDatabase;


    private static class DbHelper extends SQLiteOpenHelper{


        public DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);

        }
        public void onCreate(SQLiteDatabase db){
            db.execSQL("CREATE TABLE" +"DATABASE_TABLE" + "(" + KEY_ROWID +
                    "INTEGER PRIMARY KEY AUTPOMCREMEMT"+
                    KEY_DATE+"TEXT NOT NULL,"+
                    KEY_START+ "TEXT NOT NULL," +
                    KEY_STOP + "TEXT NOT NULL," +
                    KEY_TOTAL + "TEXT NOT NULL," +
                    KEY_EARNED + "TEXT NOT NULL,"
            );
        }
    public void onUpgrade(SQLiteDatabase db, int OldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + DATABASE_TABLE);
        onCreate(db);
    }
    }
    public WorkingHours open() throws SQLException {
        ourHelper = new DbHelper(ourContext);
        ourDatabase = ourHelper.getWritableDatabase();
        return this;
    }

    public void close () {
        ourHelper.close();
    }

    public long createEntry(String date, String start, String stop, String total, String earned) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_DATE, date);
        cv.put(KEY_START, start);
        cv.put(KEY_STOP, stop);
        cv.put(KEY_TOTAL, total);
        cv.put(KEY_EARNED, earned);


        return ourDatabase.insert(DATABASE_TABLE, null, cv);
    }
        public String getData(){
            String[] columns = new String[]{KEY_ROWID,KEY_DATE,KEY_START,KEY_STOP, KEY_TOTAL,KEY_EARNED};
            Cursor c = ourDatabase.query(DATABASE_TABLE,columns,null,null,null,null,null);
            String result = "";

        int iRow = c.getColumnIndex(KEY_ROWID);
        int iDate = c.getColumnIndex(KEY_DATE);
        int iStart = c.getColumnIndex(KEY_START);
        int iStop = c.getColumnIndex(KEY_STOP);
        int iTotal = c.getColumnIndex(KEY_TOTAL);
        int iEarned = c.getColumnIndex(KEY_EARNED);

            for(c.moveToFirst(); !c.isAfterLast();c.moveToNext()){
            result = result + c.getString(iRow)+ "" + c.getString(iDate)+"" + c.getString(iStart)+
                "" + c.getString(iStop)+"" + c.getString(iTotal) + "" + c.getString(iEarned)+ "\n";

            }
            return result;
        }

    public String getDate(long l)throws SQLException {
        // TODO Auto-generated method stub
        String [] columns = new String[]{KEY_ROWID, KEY_DATE, KEY_START, KEY_STOP, KEY_TOTAL, KEY_EARNED};
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "=" + l, null, null, null, null);
        if(c != null){
            c.moveToFirst();
            String date = c.getString(1);
            return date;
        }

        return null;
    }

    public String getStart(long l) throws SQLException{
        // TODO Auto-generated method stub
        String [] columns = new String[]{KEY_ROWID, KEY_DATE, KEY_START, KEY_STOP, KEY_TOTAL, KEY_EARNED};
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "=" + l, null, null, null, null);
        if(c != null){
            c.moveToFirst();
            String start = c.getString(2);
            return start;
        }
        return null;
    }

    public String getStop(long l)throws SQLException {
        // TODO Auto-generated method stub
        String [] columns = new String[]{KEY_ROWID, KEY_DATE, KEY_START, KEY_STOP, KEY_TOTAL, KEY_EARNED};
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "=" + l, null, null, null, null);
        if(c != null){
            c.moveToFirst();
            String stop = c.getString(3);
            return stop;
        }
        return null;
    }

    public String getTotal(long l)throws SQLException {
        // TODO Auto-generated method stub
        String [] columns = new String[]{KEY_ROWID, KEY_DATE, KEY_START, KEY_STOP, KEY_TOTAL, KEY_EARNED};
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "=" + l, null, null, null, null);
        if(c != null){
            c.moveToFirst();
            String total = c.getString(4);
            return total;
        }
        return null;
    }

    public String getEarned(long l)throws SQLException {
        // TODO Auto-generated method stub
        String [] columns = new String[]{KEY_ROWID, KEY_DATE, KEY_START, KEY_STOP, KEY_TOTAL, KEY_EARNED};
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "=" + l, null, null, null, null);
        if(c != null){
            c.moveToFirst();
            String earned = c.getString(5);
            return earned;
        }
        return null;
    }

    public void updateEntry(long lRow, String mDate, String mStart,
                            String mStop, String mTotal, String mEarned) throws SQLException {
        // TODO Auto-generated method stub
        ContentValues cvUpdate = new ContentValues();
        cvUpdate.put(KEY_DATE, mDate);
        cvUpdate.put(KEY_START, mStart);
        cvUpdate.put(KEY_STOP, mStop);
        cvUpdate.put(KEY_TOTAL, mTotal);
        cvUpdate.put(KEY_EARNED, mEarned);

        ourDatabase.update(DATABASE_TABLE, cvUpdate, KEY_ROWID + "=" + lRow, null);
    }

    public void deleteEntry(long lRow1) throws SQLException {
        // TODO Auto-generated method stub
        ourDatabase.delete(DATABASE_TABLE, KEY_ROWID, null);
    }
}




















