package com.example.alzaraapriliani.zaraproject;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class sarang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project1);


        //how to move activity
        //1. create view
        ProgressBar progress_bar1 = findViewById(R.id.progress_bar1);
        progress_bar1.setVisibility(View.GONE);
        //2. make click listener
        progress_bar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //3. create intent
                Intent intent = new Intent(sarang.this, project2.class);
                startActivity(intent);
            }
        });

        new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Intent intent = new Intent(sarang.this, project2.class);
                startActivity(intent);
            }
        }.sendEmptyMessageDelayed(0, 2000);



    }
}
