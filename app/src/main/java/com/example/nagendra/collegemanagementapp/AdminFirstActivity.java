package com.example.nagendra.collegemanagementapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.nagendra.collegemanagementapp.models.SubjectModel;
import com.rengwuxian.materialedittext.MaterialEditText;

public class AdminFirstActivity extends AppCompatActivity {

    MaterialEditText subjectname,chapters,nooftest,noofperiods;
    DatePicker datePicker;
    Button updatelecturedetails;
    SqliteHelper sqliteHelper = new SqliteHelper(this);

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_first);

        initFun();

        updatelecturedetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog = new ProgressDialog(AdminFirstActivity.this);
                progressDialog.setMessage("Registering wait..");
                progressDialog.show();

                String subjectname_text = subjectname.getText().toString().trim();
                String chapters_text = chapters.getText().toString().trim();
                String nooftest_text = nooftest.getText().toString().trim();
                String noofperiods_text = noofperiods.getText().toString().trim();
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth()+1;
                int year = datePicker.getYear();

                String date = day+"/"+month+"/"+year;

                if(TextUtils.isEmpty(subjectname_text) || TextUtils.isEmpty(chapters_text) || TextUtils.isEmpty(nooftest_text) || TextUtils.isEmpty(noofperiods_text))
                {
                    Toast.makeText(AdminFirstActivity.this, "All fields are Required", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SubjectModel subjectModel = new SubjectModel();

                    subjectModel.setSubjectname(subjectname_text);
                    subjectModel.setChapters(chapters_text);
                    subjectModel.setNooftest(nooftest_text);
                    subjectModel.setNoofperiods(noofperiods_text);
                    subjectModel.setDate(date);

                    long insertstatus = sqliteHelper.addSubject(subjectModel);

                    if (insertstatus != -1)
                    {
                        progressDialog.dismiss();
                        Toast.makeText(AdminFirstActivity.this, "Updation Success", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AdminFirstActivity.this,AdminFirstActivity.class));

                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(AdminFirstActivity.this, "Updation Failure", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AdminFirstActivity.this,AdminFirstActivity.class));
                    }
                }


            }
        });

    }

    private void initFun() {

        subjectname = (MaterialEditText)findViewById(R.id.subjectname);
        chapters = (MaterialEditText)findViewById(R.id.chapters);
        nooftest = (MaterialEditText)findViewById(R.id.nooftest);
        noofperiods = (MaterialEditText)findViewById(R.id.noofperiods);
        datePicker = (DatePicker)findViewById(R.id.datePicker);
        updatelecturedetails = (Button)findViewById(R.id.updatelecturedetails);

    }
}
