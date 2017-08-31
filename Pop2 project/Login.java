package com.example.admin.classmanager;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Login extends AppCompatActivity {

    DatabaseLogin db;

    EditText _rollNumText,_passwordText;
    String roll,pass;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DatabaseLogin db;

    }

    public void signup(View view){
        Intent i = new Intent(this,Signup.class);
        startActivity(i);
    }
    public void login(View view){
        int result;
        Intent i;
        _rollNumText =(EditText)findViewById(R.id.input_rollno);
        _passwordText =(EditText)findViewById(R.id.input_password);
        roll=_rollNumText.getText().toString();
        pass=_passwordText.getText().toString();
        db = new DatabaseLogin(this);
        result=db.verify(roll,pass);
        if(result==0) {
            i = new Intent(this, Student.class);
        }
        else if(result==1){
            i = new Intent(this,CR.class);
        }
        else{
            Toast.makeText(this,"Password doesn't match!",Toast.LENGTH_LONG).show();
            i = new Intent(this,Login.class);
        }
        startActivity(i);

    }

}