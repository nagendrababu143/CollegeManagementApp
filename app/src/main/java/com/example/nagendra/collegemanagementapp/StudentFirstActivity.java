package com.example.nagendra.collegemanagementapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class StudentFirstActivity extends AppCompatActivity {

    CardView assignments_student,attendance_student,testmarks_student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_first);

        assignments_student = (CardView)findViewById(R.id.assignments_student);
        attendance_student = (CardView)findViewById(R.id.attendance_student);
        testmarks_student = (CardView)findViewById(R.id.testmarks_student);

        assignments_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(StudentFirstActivity.this,AssignmentsStudentActivity.class);
                startActivity(intent);
            }
        });

        attendance_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(StudentFirstActivity.this,AttendanceStudentActivity.class);
                startActivity(intent);
            }
        });

        testmarks_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(StudentFirstActivity.this,TestmarksStudentActivity.class);
                startActivity(intent);
            }
        });


    }
}
