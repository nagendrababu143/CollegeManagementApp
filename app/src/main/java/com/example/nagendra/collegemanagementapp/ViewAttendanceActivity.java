package com.example.nagendra.collegemanagementapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ViewAttendanceActivity extends AppCompatActivity {

    EditText studentname_viewattendance,month_viewattendance;
    Button attendeddays_viewattendance_btn;
    TextView attendeddays_viewattendance;

    SqliteHelper sqliteHelper = new SqliteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);

        studentname_viewattendance = (EditText)findViewById(R.id.studentname_viewattendance);
        month_viewattendance = (EditText)findViewById(R.id.month_viewattendance);
        attendeddays_viewattendance_btn = (Button)findViewById(R.id.attendeddays_viewattendance_btn);
        attendeddays_viewattendance = (TextView)findViewById(R.id.attendeddays_viewattendance);

        attendeddays_viewattendance_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String studentname_viewattendance_text = studentname_viewattendance.getText().toString().trim();
                String month_viewattendance_text = month_viewattendance.getText().toString().trim();

                int count = sqliteHelper.getTheCount(studentname_viewattendance_text,month_viewattendance_text);

                attendeddays_viewattendance.setText(String.valueOf(count));
            }
        });
    }
}
