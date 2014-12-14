package com.example.katrinerefvem.whc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;



public class TabListener extends Fragment {

    private Fragment fragment;

// the constructor

public TabListener(Fragment fragment){
this.fragment = fragment;

}
  // when the tab is tapped, the fragmentTransaction replaces the content of our main layout
    // with the specified layout, thats why we delcared an id for the main layout

    public void onTabSelected(Tab tab, FragmentTransaction ft){
        ft.replace(R.id.fragment_container,fragment);

    }

 // when a tab is unselected, we have to hide it from the users view.


    public void onTabUnselected(Tab tab, FragmentTransaction ft){
        ft.remove(fragment);

    }

    public void onTabReselected(Tab tab, FragmentTransaction ft){

    }
}









   // protected void onCreate(Bundle savedInstanceState) {
     //   super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_tab_listener);
   // }



   // public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
     //   getMenuInflater().inflate(R.menu.menu_tab_listener, menu);
       // return true;
    //}


    // public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
       // int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
          //  return true;
        //}

        //return super.onOptionsItemSelected(item);
    //}
//}
