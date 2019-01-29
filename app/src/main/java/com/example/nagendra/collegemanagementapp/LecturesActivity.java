package com.example.nagendra.collegemanagementapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nagendra.collegemanagementapp.models.SubjectModel;

public class LecturesActivity extends AppCompatActivity {

    EditText subjectname_teacher;
    TextView nooftest_teacher,noofperiod_teacher,date_teacher,chapter_teacher;
    Button subjectsearch_teacher;
    SqliteHelper sqliteHelper = new SqliteHelper(this);
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lectures);

        initFun();

        subjectsearch_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SubjectModel subjectModel = null;

                progressDialog = new ProgressDialog(LecturesActivity.this);
                progressDialog.setMessage("Registering wait..");
                progressDialog.show();

                String subjectname_teacher_text = subjectname_teacher.getText().toString().trim();



                subjectModel = sqliteHelper.getData(subjectname_teacher_text);

                if(subjectModel != null)
                {
                    progressDialog.dismiss();
                    nooftest_teacher.setText(subjectModel.getNooftest());
                    noofperiod_teacher.setText(subjectModel.getNoofperiods());
                    date_teacher.setText(subjectModel.getDate());
                    chapter_teacher.setText(subjectModel.getChapters());
                }
                else
                {
                    progressDialog.dismiss();
                    Toast.makeText(LecturesActivity.this, "No subject with this Name", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void initFun() {
        subjectname_teacher = (EditText)findViewById(R.id.subjectname_teacher);
        nooftest_teacher = (TextView)findViewById(R.id.nooftest_teacher);
        noofperiod_teacher = (TextView)findViewById(R.id.noofperiod_teacher);
        date_teacher = (TextView)findViewById(R.id.date_teacher);
        chapter_teacher = (TextView)findViewById(R.id.chapter_teacher);
        subjectsearch_teacher = (Button)findViewById(R.id.subjectsearch_teacher);
    }
}
