package com.example.admin.classmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class ViewNotification extends AppCompatActivity {
    TextView SubjectText = (TextView)findViewById(R.id.SubjectText);
    TextView Ntext=(TextView)findViewById(R.id.Ntext);
    TextView time = (TextView)findViewById(R.id.time);
    TextView date =(TextView)findViewById(R.id.date);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view_notification);
        onNewIntent(getIntent());

    }
    @Override
    public void onNewIntent(Intent i){
        Bundle NotificationData = i.getExtras();
        if(NotificationData==null)
            return ;
        setContentView(R.layout.activity_view_notification);
        SubjectText.setText(NotificationData.getString("SubjectText"));
        Ntext.setText(NotificationData.getString("Ntext"));
        time.setText(NotificationData.getString("time"));
        date.setText(NotificationData.getString("date"));
    }
    /*@Override
    public void onBackPressed(){
        super.onBackPressed();
        startActivity(new Intent(this,Student.class));
        finish();
    }*/
}
