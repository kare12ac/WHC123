package com.example.katrinerefvem.whc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;






    public class SQLiteCounter extends Activity implements OnClickListener{
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState){
            View view = inflater.inflate(R.layout.activity_sqlview, container, false);
            return view;
        }

        Button sqlView, sqlUpdate, sqlModify, sqlGetInfo, sqlDelete;
        EditText sqlDate, sqlStart,sqlStop, sqlTotal, sqlEarned, sqlRow;

        protected void onCreate(Bundle savedInstanceState)

        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sqlite_counter);
            sqlUpdate= (Button) findViewById(R.id.saveButton);
            sqlDate = (EditText)findViewById(R.id.etSQLdate);
            sqlStart = (EditText) findViewById(R.id.etSQLstart);
            sqlStop = (EditText) findViewById(R.id.etSQLstop);
            sqlTotal = (EditText) findViewById(R.id.etSQLtotal);
            sqlEarned = (EditText) findViewById(R.id.etSQLearned);



            sqlView = (Button) findViewById(R.id.bSQLOpenView);
            sqlView.setOnClickListener(this);
            sqlUpdate.setOnClickListener(this);

            sqlRow = (EditText) findViewById(R.id.etSQLrowInfo);
            sqlModify =(Button) findViewById(R.id.bSQLmodify);
            sqlGetInfo = (Button) findViewById(R.id.bgetinfo);
            sqlDelete = (Button) findViewById(R.id.bSQLdelete);
            sqlModify.setOnClickListener(this);
            sqlGetInfo.setOnClickListener(this);
            sqlDelete.setOnClickListener(this);

        }
        public void onClick(View arg0){

            switch(arg0.getId()){
                case R.id.bSQLUpdate:

                    boolean didItWork = true;

                    try{
                        String date = sqlDate.getText().toString();
                        String start = sqlStart.getText().toString();
                        String stop = sqlStop.getText().toString();
                        String total = sqlTotal.getText().toString();
                        String earned = sqlEarned.getText().toString();

                        WorkingHours entry = new WorkingHours(SQLiteCounter.this);
                        entry.open();
                        entry.createEntry(date, start, stop, total,earned );
                        entry.close();

                    } catch (Exception e){
                        didItWork = false;
                        String error = e.toString();
                        Dialog d = new Dialog (this);
                        d.setTitle("no success");
                        TextView tv = new TextView(this);
                        tv.setText(error);
                        d.setContentView(tv);
                        d.show();
                    }finally{
                        if(didItWork)
                        {
                            Dialog d = new Dialog(this);
                            d.setTitle("yes");
                            TextView tv = new TextView(this);
                            tv.setText("sucess");
                            d.setContentView(tv);
                            d.show();
                        }
                    }
                    break;
                case R.id.bSQLOpenView:
                    Intent i = new Intent ("android.intent.action.MAIN");
                    startActivity(i);
                    break;
                case R.id.bgetinfo:

                    try{
                        String s = sqlRow.getText().toString();
                        long l = Long.parseLong(s);
                        WorkingHours wh = new WorkingHours(this);
                        wh.open();
                        String returnedDate =wh.getDate(l);
                        String returnedStart = wh.getStart(l);
                        String returnedStop = wh.getStop(l);
                        String returnedTotal = wh.getTotal(l);
                        String returnedEarned = wh.getEarned(l);

                        wh.close();

                        sqlDate.setText(returnedDate);
                        sqlStart.setText(returnedStart);
                        sqlStop.setText(returnedStop);
                        sqlTotal.setText(returnedTotal);
                        sqlEarned.setText(returnedEarned);
                    }catch(Exception e){

                        String error = e.toString();
                        Dialog d = new Dialog(this);
                        d.setTitle("no");
                        TextView tv = new TextView(this);
                        tv.setText(error);
                        d.setContentView(tv);
                        d.show();


                    }
                    break;

                case R.id.bSQLmodify:
                    try{
                        String mDate = sqlDate.getText().toString();
                        String mStart = sqlStart.getText().toString();
                        String mStop = sqlStop.getText().toString();
                        String mTotal = sqlTotal.getText().toString();
                        String mEarned = sqlEarned.getText().toString();
                        String sRow = sqlRow.getText().toString();
                        long lRow = Long.parseLong(sRow);

                        WorkingHours ex = new WorkingHours(this);
                        ex.open();
                        ex.updateEntry(lRow, mDate, mStart, mStop, mTotal, mEarned);
                        ex.close();
                    }catch(Exception e){

                        String error = e.toString();
                        Dialog d = new Dialog(this);
                        d.setTitle("no");
                        TextView tv = new TextView(this);
                        tv.setText(error);
                        d.setContentView(tv);
                        d.show();

                        break;
                    }
                case R.id.bSQLdelete:
                    try{
                        String sRow1 = sqlRow.getText().toString();
                        long lRow1 = Long.parseLong(sRow1);
                        WorkingHours ex1 = new WorkingHours(this);
                        ex1.open();
                        ex1.deleteEntry(lRow1);
                        ex1.close();
                    }catch(Exception e){
                        String error = e.toString();
                        Dialog d = new Dialog(this);
                        d.setTitle("no");
                        TextView tv = new TextView(this);
                        tv.setText(error);
                        d.setContentView(tv);
                        d.show();


                        break;

                    }
            }
        }
    }



