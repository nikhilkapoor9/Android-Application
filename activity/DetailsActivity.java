package com.example.form.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.form.R;
import com.example.form.db.DatabaseHelper;

public class DetailsActivity extends AppCompatActivity {
    public static DatabaseHelper dbh;

    TextView firstname, lastname, emailid, password, repassword;
    Button addsignup;

    public void Clickfunction(View view) {

//        Log.i("info","button pressed");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        dbh = new DatabaseHelper(this);

        firstname = (TextView) findViewById(R.id.firstnametext);
        lastname = (TextView) findViewById(R.id.usertext);
        emailid = (TextView) findViewById(R.id.emailidtext);
        password = (TextView) findViewById(R.id.passwordtext);
        repassword = (TextView) findViewById(R.id.repasswordtext);
        addsignup = (Button) findViewById(R.id.signupdetails);

        addData();
    }

    public void addData() {
        addsignup.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = dbh.insertData(firstname.getText().toString(),
                                lastname.getText().toString(),
                                emailid.getText().toString(),
                                password.getText().toString());
//                        dbh.fetch();

//                            dbh.fetchrows();


                        if (isInserted = true) {
                            Toast.makeText(DetailsActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(DetailsActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                        }


                        startActivity(new Intent(DetailsActivity.this, MainActivity.class));

                    }
                }
        );
    }


}
