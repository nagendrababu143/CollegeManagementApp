package com.example.nagendra.collegemanagementapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AttendanceStudentActivity extends AppCompatActivity {

    EditText studentname_myattendance,month_myattendance;
    Button attendeddays_myattendance_btn;
    TextView attendeddays_myattendance;

    SqliteHelper sqliteHelper = new SqliteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_student);

        studentname_myattendance = (EditText)findViewById(R.id.studentname_myattendance);
        month_myattendance = (EditText)findViewById(R.id.month_myattendance);
        attendeddays_myattendance_btn = (Button)findViewById(R.id.attendeddays_myattendance_btn);
        attendeddays_myattendance = (TextView)findViewById(R.id.attendeddays_myattendance);

        attendeddays_myattendance_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String studentname_myattendance_text = studentname_myattendance.getText().toString().trim();
                String month_myattendance_text = month_myattendance.getText().toString().trim();

                int count = sqliteHelper.getTheCount(studentname_myattendance_text,month_myattendance_text);

                attendeddays_myattendance.setText(String.valueOf(count));
            }
        });

    }
}
