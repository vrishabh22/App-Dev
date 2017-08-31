package com.example.admin.classmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Bunkmeter extends AppCompatActivity {

    DatabaseBunk db;
    TextView v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bunkmeter);
        db = new DatabaseBunk(this);

        v = (TextView)findViewById(R.id.Bunk0);
        assert v != null;
        v.setText(db.toString(1));
        v = (TextView)findViewById(R.id.Bunk1);
        assert v != null;
        v.setText(db.toString(2));
        v = (TextView)findViewById(R.id.Bunk2);
        assert v != null;
        v.setText(db.toString(3));
        v = (TextView)findViewById(R.id.Bunk3);
        assert v != null;
        v.setText(db.toString(4));
        v = (TextView)findViewById(R.id.Bunk4);
        assert v != null;
        v.setText(db.toString(5));
        v = (TextView)findViewById(R.id.Bunk5);
        assert v!=null;
        v.setText(db.toString(6));

    }
    public void Inc(View view) {
        switch (view.getId()) {
            case R.id.Inc0:
                v = (TextView) findViewById(R.id.Bunk0);
                db.IncBunk(1);
                assert v != null;
                v.setText(db.toString(1));
                break;
            case R.id.Inc1:
                v = (TextView) findViewById(R.id.Bunk1);
                db.IncBunk(2);
                assert v != null;
                v.setText(db.toString(2));
                break;
            case R.id.Inc2:
                v = (TextView) findViewById(R.id.Bunk2);
                db.IncBunk(3);
                assert v != null;
                v.setText(db.toString(3));
                break;
            case R.id.Inc3:
                v = (TextView) findViewById(R.id.Bunk3);
                db.IncBunk(4);
                assert v != null;
                v.setText(db.toString(4));
                break;
            case R.id.Inc4:
                v = (TextView) findViewById(R.id.Bunk4);
                db.IncBunk(5);
                assert v != null;
                v.setText(db.toString(5));
                break;
            case R.id.Inc5:
                v = (TextView) findViewById(R.id.Bunk5);
                db.IncBunk(6);
                assert v != null;
                v.setText(db.toString(6));
                break;
        }
    }
    public void Dec(View view){
        switch (view.getId()){
            case R.id.Dec0:
                v=(TextView)findViewById(R.id.Bunk0);
                db.DecBunk(1);
                assert v != null;
                v.setText(db.toString(1));
                break;
            case R.id.Dec1:
                v=(TextView)findViewById(R.id.Bunk1);
                db.DecBunk(2);
                assert v != null;
                v.setText(db.toString(2));
                break;
            case R.id.Dec2:
                v=(TextView)findViewById(R.id.Bunk2);
                db.DecBunk(3);
                assert v != null;
                v.setText(db.toString(3));
                break;
            case R.id.Dec3:
                v=(TextView)findViewById(R.id.Bunk3);
                db.DecBunk(4);
                assert v != null;
                v.setText(db.toString(4));
                break;
            case R.id.Dec4:
                v=(TextView)findViewById(R.id.Bunk4);
                db.DecBunk(5);
                assert v != null;
                v.setText(db.toString(5));
                break;
            case R.id.Dec5:
                v=(TextView)findViewById(R.id.Bunk5);
                db.DecBunk(6);
                assert v != null;
                v.setText(db.toString(6));
                break;
        }
    }
    public void Add(View view){
        Bunk sub1=new Bunk(1);
        Bunk sub2=new Bunk(2);
        Bunk sub3=new Bunk(3);
        Bunk sub4=new Bunk(4);
        Bunk sub5=new Bunk(5);
        Bunk sub6=new Bunk(6);
        db.addSub(sub1);
        db.addSub(sub2);
        db.addSub(sub3);
        db.addSub(sub4);
        db.addSub(sub5);
        db.addSub(sub6);
    }
}

