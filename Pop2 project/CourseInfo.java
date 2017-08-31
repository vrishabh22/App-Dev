package com.example.admin.classmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class CourseInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);
    }
    public void ccn(View view){
        Intent i= new Intent(this,ccn.class);
        startActivity(i);
    }
    public void pop2(View view){
        Intent i= new Intent(this,pop2.class);
        startActivity(i);
    }
    public void daa(View view){
        Intent i= new Intent(this,daa.class);
        startActivity(i);
    }
    public void ooad(View view){
        Intent i= new Intent(this,ooad.class);
        startActivity(i);
    }
    public void os(View view){
        Intent i= new Intent(this,os.class);
        startActivity(i);
    }
    public void cg(View view){
        Intent i= new Intent(this,cg.class);
        startActivity(i);
    }
}
