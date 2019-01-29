package com.example.nagendra.collegemanagementapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class AttendanceActivity extends AppCompatActivity {

    CardView addattendance,viewattendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        addattendance = (CardView)findViewById(R.id.addattendance);
        viewattendance = (CardView)findViewById(R.id.viewattendance);

        addattendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AttendanceActivity.this,AddAttendanceActivity.class);
                startActivity(intent);
            }
        });

        viewattendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AttendanceActivity.this,ViewAttendanceActivity.class);
                startActivity(intent);
            }
        });
    }
}
