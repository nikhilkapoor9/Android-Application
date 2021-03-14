package com.example.form.activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.core.view.GravityCompat;


import android.os.Bundle;
import android.util.Log;
//import android.widget.Toolbar;


import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.form.R;

//import androidx.appcompat.app.AppCompatActivity;

public class NavigationMenu extends AppCompatActivity {

    DrawerLayout drawerlayout;
    Toolbar toolbard;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_menu);
        Log.i("msg","method call done");
        setUpToolBar();
    }

    private void  setUpToolBar(){

        Log.i("msg","inside method call");

        drawerlayout=(DrawerLayout)findViewById(R.id.drawerlayout);
        toolbard=(Toolbar)findViewById(R.id.toolbard);

               setSupportActionBar(toolbard);

               getSupportActionBar().setHomeButtonEnabled(true);
               getSupportActionBar().setDisplayHomeAsUpEnabled(true);
               getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_draghandle);

        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerlayout,toolbard,R.string.app_name,R.string.app_name);

        drawerlayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawerlayout.isDrawerOpen(GravityCompat.START)) {
            drawerlayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }
    }
}
