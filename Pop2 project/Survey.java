package com.example.admin.classmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.View;

public class Survey extends AppCompatActivity {

    String x;

    RadioButton yes,no;
    private int yes_count=0,no_count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        Bundle QuesData = getIntent().getExtras();
        if(QuesData==null)
            return ;
        String ques=QuesData.getString("Ques");
        TextView Ques = (TextView)findViewById(R.id.Ques);
        Ques.setText(ques);
        yes=(RadioButton)findViewById(R.id.Yes);
        no=(RadioButton)findViewById(R.id.No);
    }

    public void setX(String x) {
        this.x = x;
    }

    public void vote(View view){

    }
    public int getYes_count() {
        return yes_count;
    }

    public int getNo_count() {
        return no_count;
    }
}
