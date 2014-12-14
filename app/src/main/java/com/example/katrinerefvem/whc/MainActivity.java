package com.example.katrinerefvem.whc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public class MainActivity extends Activity  {
//missing extends fragment

    ActionBar.Tab WHTab,SSTab, ViewTab;

    Fragment WorkingHours = new WorkingHours(null);
    Fragment StartStop = new StartStop();

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
//Asking for the default ActionBar element that our platform supports.
        ActionBar actionBar = getActionBar();
//Screen handling while hiding ActionBar
        icon.actionBar.setDisplayShowHomeEnabled(false);
//Screen handling while hiding actionbartitle.
        actionBar.setDisplayShowTitleEnabled(false);
//Creating actionbar tabs.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//Setting custom tab text
        WHTab = actionBar.newTab().setText("Manually");
        SSTab = actionBar.newTab().setText("Start and Stop");
//setting tab listeners.

        WHTab.setTabListener(new TabListener(WorkingHours));
        SSTab.setTabListener(new TabListener(StartStop));
//Adding tabs to the ActionBar.
        actionBar.addTab(WHTab);
        actionBar.addTab(SSTab);
        actionBar.addTab(ViewTab);
    }
}