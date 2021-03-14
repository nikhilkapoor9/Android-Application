package com.example.form.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.form.R;
import com.example.form.db.DatabaseHelper;

public class LoginDetails extends AppCompatActivity {

    EditText username,userpswrd;
    TextView link;
    Button logInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_details);

        username =(EditText)findViewById(R.id.useridtext);
        userpswrd=(EditText) findViewById(R.id.passwordtext);
        logInButton=(Button) findViewById(R.id.Loginbutton);
        link=(TextView) findViewById(R.id.linkid);

//        link.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
//      moveTaskToBack(true);

        startActivity(new Intent(LoginDetails.this,MainActivity.class));
        this.finish();

    }



    public void submitLoginDetails(View view){

        String emailid,upaswrd;
        emailid=username.getText().toString();
        upaswrd=userpswrd.getText().toString();

        Log.i("user email id  is ",emailid);
        Log.i("user password is ",upaswrd);

   DatabaseHelper dbh1=new DatabaseHelper(this);


    Boolean fetchresult= dbh1.fetch( emailid, upaswrd);

      if(fetchresult== true){
          Intent i=new Intent(LoginDetails.this,HomeActivity.class);
          i.putExtra("useremail",emailid);
          startActivity(i);
//          startActivity(new Intent(LoginDetails.this,Homepage.class));
          this.finish();
      }
      else
      {
         Toast.makeText(LoginDetails.this,"wrong input details   ,Enter input details again       ",Toast.LENGTH_SHORT).show();
      }


    }


    public void  linkmethod(View view){
         startActivity(new Intent(LoginDetails.this,DetailsActivity.class));
          this.finish();
    }


}
