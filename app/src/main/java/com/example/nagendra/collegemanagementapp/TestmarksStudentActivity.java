package com.example.nagendra.collegemanagementapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TestmarksStudentActivity extends AppCompatActivity {

    EditText studentname_myassessment,month_myassessment;
    Button marks_btn_myassessment;
    TextView totalmarks_myassessment;

    SqliteHelper sqliteHelper = new SqliteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testmarks_student);

        studentname_myassessment = (EditText)findViewById(R.id.studentname_myassessment);
        month_myassessment = (EditText)findViewById(R.id.month_myassessment);
        marks_btn_myassessment = (Button)findViewById(R.id.marks_btn_myassessment);
        totalmarks_myassessment = (TextView)findViewById(R.id.totalmarks_myassessment);

        marks_btn_myassessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String studentname_myassessment_text = studentname_myassessment.getText().toString().trim();
                String month_myassessment_text = month_myassessment.getText().toString().trim();

                int val = sqliteHelper.totalMarks(studentname_myassessment_text,month_myassessment_text);

                //String val1 = val;
                totalmarks_myassessment.setText(String.valueOf(val));
            }
        });


    }
}
