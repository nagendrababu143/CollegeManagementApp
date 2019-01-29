package com.example.nagendra.collegemanagementapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nagendra.collegemanagementapp.models.AssignmentModel;

public class AssignmentsActivity extends AppCompatActivity {

    EditText subjectname_lecture,chapone,noone,dateone,chaptwo,notwo,datetwo,
            chapthree,nothree,datethree,chapfour,nofour,datefour,chapfive,nofive,datefive;
    Button updateassignments;

    SqliteHelper sqliteHelper = new SqliteHelper(this);

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments);

        initFun();

        updateassignments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog = new ProgressDialog(AssignmentsActivity.this);
                progressDialog.setMessage("Registering wait..");
                progressDialog.show();

                AssignmentModel assignmentModel = new AssignmentModel();

                assignmentModel.setSubjectname_lecture(subjectname_lecture.getText().toString().trim());

                assignmentModel.setChapone(chapone.getText().toString().trim());
                assignmentModel.setNoone(noone.getText().toString().trim());
                assignmentModel.setDateone(dateone.getText().toString().trim());

                assignmentModel.setChaptwo(chaptwo.getText().toString().trim());
                assignmentModel.setNotwo(notwo.getText().toString().trim());
                assignmentModel.setDatetwo(datetwo.getText().toString().trim());

                assignmentModel.setChapthree(chapthree.getText().toString().trim());
                assignmentModel.setNothree(nothree.getText().toString().trim());
                assignmentModel.setDatethree(datethree.getText().toString().trim());

                assignmentModel.setChapfour(chapfour.getText().toString().trim());
                assignmentModel.setNofour(nofour.getText().toString().trim());
                assignmentModel.setDatefour(datefour.getText().toString().trim());

                assignmentModel.setChapfive(chapfive.getText().toString().trim());
                assignmentModel.setNofive(nofive.getText().toString().trim());
                assignmentModel.setDatefive(datefive.getText().toString().trim());

                long assignment_status = sqliteHelper.addAssignment(assignmentModel);

                if (assignment_status != -1)
                {
                    progressDialog.dismiss();
                    Toast.makeText(AssignmentsActivity.this, "Assignment Added Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AssignmentsActivity.this,TeacherFirstActivity.class));
                    finish();
                }
                else
                {
                    progressDialog.dismiss();
                    Toast.makeText(AssignmentsActivity.this, "Assignment Update Failure", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AssignmentsActivity.this,TeacherFirstActivity.class));
                    finish();
                }

            }
        });




    }

    private void initFun() {

        subjectname_lecture = (EditText)findViewById(R.id.subjectname_lecture);

        chapone = (EditText)findViewById(R.id.chapone);
        noone = (EditText)findViewById(R.id.noone);
        dateone = (EditText)findViewById(R.id.dateone);
        chaptwo = (EditText)findViewById(R.id.chaptwo);
        notwo = (EditText)findViewById(R.id.notwo);
        datetwo = (EditText)findViewById(R.id.datetwo);
        chapthree = (EditText)findViewById(R.id.chapthree);
        nothree = (EditText)findViewById(R.id.nothree);
        datethree = (EditText)findViewById(R.id.datethree);
        chapfour = (EditText)findViewById(R.id.chapfour);
        nofour = (EditText)findViewById(R.id.nofour);
        datefour = (EditText)findViewById(R.id.datefour);
        chapfive = (EditText)findViewById(R.id.chapfive);
        nofive = (EditText)findViewById(R.id.nofive);
        datefive = (EditText)findViewById(R.id.datefive);

        updateassignments = (Button) findViewById(R.id.updateassignments);

    }
}
