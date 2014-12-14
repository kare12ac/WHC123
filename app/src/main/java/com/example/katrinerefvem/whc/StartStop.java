package com.example.katrinerefvem.whc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

    public class StartStop extends Fragment {
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            View rootView = inflater.inflate(R.layout.activity_main, container,false);
            return rootView;
        }

        private Button startButton;
        private Button pauseButton;
        private Button saveButton;
        protected TextView timerValue;
        private long startTime = 0L;
        private Handler customHandler = new Handler();
        long timeInMilliseconds = 0L;
        long timeSwapBuff = 0L;
        long updatedTime = 0L;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);



            timerValue = (TextView) findViewById(R.id.timerValue);
            startButton = (Button) findViewById(R.id.startButton);
            startButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    startTime = SystemClock.uptimeMillis();
                    customHandler.postDelayed(updateTimerThread, 0);
                }
            });
            pauseButton = (Button) findViewById(R.id.pauseButton);
            pauseButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    timeSwapBuff += timeInMilliseconds;
                    customHandler.removeCallbacks(updateTimerThread);
                }
            });
            //  saveButton = (Button) findViewById(R.id.saveButton);
            //saveButton.setOnClickListener(new View.OnClickListener;
            //public void onClick(View view){
            //		saveTime = SystemClock.setCurrentTimeMillis(timeInMilliseconds)
            // 				customHandler.{


        }

        //	@Override
        //	public void onClick(View view) {
        // TODO Auto-generated method stub

        //	}
        //	})


        private TextView findViewById(int timervalue2) {
            // TODO Auto-generated method stub
            return null;
        }

        private void setContentView(int activityMain) {
            // TODO Auto-generated method stub

        }

        //}
        private Runnable updateTimerThread = new Runnable() {
            public void run() {
                timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
                updatedTime = timeSwapBuff + timeInMilliseconds;
                int secs = (int) (updatedTime / 1000);
                int mins = secs / 60;
                secs = secs % 60;
                int hours = mins / 60;
                hours = hours % 60;
                timerValue.setText( String.format("%02d", hours) + ":" +
                        String.format("%02d" , mins) + ":" +
                        String.format("%02d" , secs));



                customHandler.postDelayed(this, 0);

            }
        };
    }


