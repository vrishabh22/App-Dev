package com.example.admin.classmanager;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;

import com.google.firebase.messaging.FirebaseMessaging;

public class SetNotification extends AppCompatActivity {

    NotificationCompat.Builder Reminder;
    private static final int ReminderID= 467822;
    private String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_notification);
        Reminder = new NotificationCompat.Builder(this);
        Reminder.setAutoCancel(true);
    }
    public void MakeN(View view){
        final EditText ReminderTF =(EditText)findViewById(R.id.ReminderTF);
        EditText TimeTF =(EditText)findViewById(R.id.TimeTF);
        EditText DateTF =(EditText)findViewById(R.id.DateTF);
        final EditText SubTF= (EditText)findViewById(R.id.Sub);
        //Build the notification
        Reminder.setSmallIcon(R.drawable.unnamed);
        assert SubTF != null;
        Reminder.setTicker(SubTF.getText());
        Reminder.setWhen(System.currentTimeMillis());
        Reminder.setContentTitle(SubTF.getText());
        assert ReminderTF != null;
        assert TimeTF != null;
        assert DateTF != null;
        msg= ReminderTF.getText() + "\nTIME: " +TimeTF.getText()+"\n Date: "+ DateTF.getText() ;
        Reminder.setContentText(msg);

        /*Bitmap icon = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.unnamed);
        MyFirebaseMessagingService send= new MyFirebaseMessagingService();
        send.sendNotification(ReminderTF.getText().toString(),SubTF.getText().toString(),icon,"Boolean.TRUE");*/

        Intent in = new Intent(this,ViewNotification.class);
        in.putExtra("SubjectText",SubTF.getText());
        in.putExtra("Ntext",ReminderTF.getText());
        in.putExtra("time",TimeTF.getText());
        in.putExtra("date",DateTF.getText());
        PendingIntent pi = PendingIntent.getActivity(this,0,in,PendingIntent.FLAG_UPDATE_CURRENT);
        Reminder.setContentIntent(pi);

        //Builds and issues it
        NotificationManager nm= (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nm.notify(ReminderID,Reminder.build());

        Intent i = new Intent(this,CR.class);
        startActivity(i);

    }

}
