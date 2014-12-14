package com.example.katrinerefvem.whc;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Fragment;
import android.os.Bundle;
import  android.view.LayoutInflater;
import  android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;
 import com.example.katrinerefvem.whc.R;

public class SQLView extends Activity {

    public View onCreate(LayoutInflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = Inflater.inflate(R.layout.activity_sqlview, container, false);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlview);


        TextView tv = (TextView) findViewById(R.id.tvSQLinfo);
        WorkingHours info = new WorkingHours();//(this);
        info.open();
        String data = info.getData();
        info.close();
        tv.setText(data);

    }
    }
}