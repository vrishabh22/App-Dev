package com.example.admin.classmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CR extends Student {
    String quest;
    EditText q;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cr);
    }
    public void notify(View view){
        Intent i = new Intent(this,SetNotification.class);
        startActivity(i);
    }
    public void createSurvey(View view){
        q=(EditText)findViewById(R.id.surveyText);
        assert q != null;
            quest = "Quest: "+q.getText();
        Intent i = new Intent(this,Survey.class);
        i.putExtra("Ques",quest);
        startActivity(i);

    }
}
