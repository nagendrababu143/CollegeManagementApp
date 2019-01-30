package com.example.nagendra.collegemanagementapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ViewAssementActivity extends AppCompatActivity {

    EditText studentname_viewassessment,month_viewassessment;
    Button marks_btn_viewassessment;
    TextView totalmarks_viewassessment;
    SqliteHelper sqliteHelper = new SqliteHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_assement);

        studentname_viewassessment = (EditText)findViewById(R.id.studentname_viewassessment);
        month_viewassessment = (EditText)findViewById(R.id.month_viewassessment);
        marks_btn_viewassessment = (Button)findViewById(R.id.marks_btn_viewassessment);
        totalmarks_viewassessment = (TextView)findViewById(R.id.totalmarks_viewassessment);

        marks_btn_viewassessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String studentname_viewassessment_text = studentname_viewassessment.getText().toString().trim();
                String month_viewassessment_text = month_viewassessment.getText().toString().trim();

                int val = sqliteHelper.totalMarks(studentname_viewassessment_text,month_viewassessment_text);

                //String val1 = val;
                totalmarks_viewassessment.setText(String.valueOf(val));
            }
        });
    }
}
