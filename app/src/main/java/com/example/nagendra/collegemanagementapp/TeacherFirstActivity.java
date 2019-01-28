package com.example.nagendra.collegemanagementapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class TeacherFirstActivity extends AppCompatActivity {

    CardView lectures,assignments,attendance,testmarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_first);

        initFun();

        lectures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(TeacherFirstActivity.this,LecturesActivity.class));
            }
        });

        assignments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(TeacherFirstActivity.this,AssignmentsActivity.class));
            }
        });

        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(TeacherFirstActivity.this,AttendanceActivity.class));
            }
        });

        testmarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(TeacherFirstActivity.this,TestmarksActivity.class));
            }
        });
    }

    private void initFun() {

        lectures = (CardView)findViewById(R.id.lectures);
        assignments = (CardView)findViewById(R.id.assignments);
        attendance = (CardView)findViewById(R.id.attendance);
        testmarks = (CardView)findViewById(R.id.testmarks);

    }
}
