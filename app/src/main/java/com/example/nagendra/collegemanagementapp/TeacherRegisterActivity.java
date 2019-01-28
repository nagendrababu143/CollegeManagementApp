package com.example.nagendra.collegemanagementapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nagendra.collegemanagementapp.models.HodModel;
import com.example.nagendra.collegemanagementapp.models.TeacherModel;
import com.rengwuxian.materialedittext.MaterialEditText;

public class TeacherRegisterActivity extends AppCompatActivity {

    MaterialEditText teachername_register,teacherphonenumber_register,
            teachermailid_register,teacherid_register,teacherdepartment_register;

    TextView teacher_loginref;
    Button teacher_register;

    SqliteHelper sqliteHelper = new SqliteHelper(this);

    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_register);

        //initialization
        initFun();

        teacher_loginref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeacherRegisterActivity.this,TeacherLoginActivity.class);
                startActivity(intent);
            }
        });

        teacher_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog = new ProgressDialog(TeacherRegisterActivity.this);
                progressDialog.setMessage("Registering wait..");
                progressDialog.show();

                String teachername_register_text = teachername_register.getText().toString().trim();
                String teacherphonenumber_register_text = teacherphonenumber_register.getText().toString().trim();
                String teachermailid_register_text = teachermailid_register.getText().toString().trim();
                String teacherid_register_text = teacherid_register.getText().toString().trim();
                String teacherdepartment_register_text = teacherdepartment_register.getText().toString().trim();

                if(TextUtils.isEmpty(teachername_register_text) || TextUtils.isEmpty(teacherphonenumber_register_text) || TextUtils.isEmpty(teachermailid_register_text) || TextUtils.isEmpty(teacherid_register_text) || TextUtils.isEmpty(teacherdepartment_register_text))
                {
                    Toast.makeText(TeacherRegisterActivity.this, "All fields are Required", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    TeacherModel teacherModel = new TeacherModel();

                    teacherModel.setTeachername(teachername_register_text);
                    teacherModel.setTeacherphonenumber(teacherphonenumber_register_text);
                    teacherModel.setTeachermailid(teachermailid_register_text);
                    teacherModel.setTeacherid(teacherid_register_text);
                    teacherModel.setTeacherdepartment(teacherdepartment_register_text);

                    long register_status = sqliteHelper.addTeacher(teacherModel);

                    if (register_status != -1)
                    {
                        progressDialog.dismiss();
                        Toast.makeText(TeacherRegisterActivity.this, "Registration Success", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(TeacherRegisterActivity.this,TeacherLoginActivity.class));
                        finish();
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(TeacherRegisterActivity.this, "Registration Failure", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(TeacherRegisterActivity.this,TeacherLoginActivity.class));
                        finish();
                    }

                }
            }
        });
    }

    private void initFun() {

        teachername_register = (MaterialEditText)findViewById(R.id.teachername_register);
        teacherphonenumber_register = (MaterialEditText)findViewById(R.id.teacherphonenumber_register);
        teachermailid_register = (MaterialEditText)findViewById(R.id.teachermailid_register);
        teacherid_register = (MaterialEditText)findViewById(R.id.teacherid_register);
        teacherdepartment_register = (MaterialEditText)findViewById(R.id.teacherdepartment_register);

        teacher_loginref = (TextView)findViewById(R.id.teacher_loginref);
        teacher_register = (Button)findViewById(R.id.teacher_register);

    }
}
