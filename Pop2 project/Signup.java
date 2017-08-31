package com.example.admin.classmanager;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Signup extends AppCompatActivity {

    private static final String TAG = "SignupActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

    }

    public void SignUp(View view){
        String roll,pass,cr;
        int cr_int;
        EditText roll_num=(EditText)findViewById(R.id.Roll_num);
        EditText password =(EditText)findViewById(R.id.input_password);
        EditText cr_in = (EditText)findViewById(R.id.cr);
        assert roll_num != null;
        roll=roll_num.getText().toString();
        assert password != null;
        pass=password.getText().toString();
        assert cr_in != null;
        cr=cr_in.getText().toString();
        if(cr.equalsIgnoreCase("1")){
            cr_int=1;
        }
        else
            cr_int=0;

        DatabaseLogin db = new DatabaseLogin(this);
        db.addStudent(roll,pass,cr_int);
        db.close();
        Toast.makeText(this,"Sign up Successful!",Toast.LENGTH_LONG).show();
        Intent i = new Intent(this,Login.class);
        startActivity(i);
    }
    public void login(View view){
        Intent i = new Intent(this,Login.class);
        startActivity(i);
    }

}

