package com.example.admin.classmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Student extends AppCompatActivity{

    private String Roll_no;
    private String password;
    private Boolean cr;

    public Student() {
    }

    public Student(String roll_no, String password, Boolean cr) {
        Roll_no = roll_no;
        this.password = password;
        this.cr = cr;
    }

    public String getRoll_no() {
        return Roll_no;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getCr() {
        return cr;
    }

    public void vote(){

    }
    public void BunkMeter(View view) {
        Intent i = new Intent(this,Bunkmeter.class);
        startActivity(i);
    }
    public void Course(View view){
        Intent i = new Intent(this,CourseInfo.class);
        startActivity(i);
    }
    public void logout(View view){
        Intent i = new Intent(this,Login.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

    }
}
