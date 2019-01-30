package com.example.nagendra.collegemanagementapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class TestmarksActivity extends AppCompatActivity {

    CardView addassement,viewassement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testmarks);

        addassement = (CardView)findViewById(R.id.addassement);
        viewassement = (CardView)findViewById(R.id.viewassement);

        addassement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TestmarksActivity.this,AddAssementActivity.class);
                startActivity(intent);
            }
        });

        viewassement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TestmarksActivity.this,ViewAssementActivity.class);
                startActivity(intent);
            }
        });
    }
}
