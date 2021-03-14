package com.example.form.activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.form.R;

public class MainActivity extends AppCompatActivity {

    Button TeacherSignup;
    DrawerLayout drawerlayout;
    Toolbar toolbard;
    ActionBarDrawerToggle actionBarDrawerToggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolBar();

    }

    private  void setUpToolBar(){
        Log.i("msg","inside mthod call");

        drawerlayout=(DrawerLayout)findViewById(R.id.drawerlayout);
        toolbard=(Toolbar) findViewById(R.id.toolbard);
//        setSupportActionBar(toolbard);

        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerlayout,toolbard,R.string.app_name,R.string.app_name);
        drawerlayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }



    @Override
    public void onBackPressed() {
        if(drawerlayout.isDrawerOpen(GravityCompat.START)){
            drawerlayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();

        }
    }



    public void fillsignupdetails(View v){
      startActivity(new Intent(MainActivity.this,DetailsActivity.class));
      this.finish();
    }

    public void loginDetails(View view){
       startActivity(new Intent(MainActivity.this,LoginDetails.class));
        this.finish();
    }

    public  void TeacherViewMethod(View view){
        Log.i("teaachers details","yes method works");
        startActivity(new Intent(MainActivity.this,TeachersActivity.class));
        this.finish();


    }



}
