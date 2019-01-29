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

import com.example.nagendra.collegemanagementapp.models.StudentModel;
import com.example.nagendra.collegemanagementapp.models.TeacherModel;
import com.rengwuxian.materialedittext.MaterialEditText;

public class StudentRegisterActivity extends AppCompatActivity {


    MaterialEditText studentname_register,studentphonenumber_register,
            studentmailid_register,studentid_register,studentdepartment_register;

    TextView student_loginref;
    Button student_register;

    SqliteHelper sqliteHelper = new SqliteHelper(this);

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);

        //initialization
        initFun();

        student_loginref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentRegisterActivity.this,StudentLoginActivity.class);
                startActivity(intent);
            }
        });

        student_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog = new ProgressDialog(StudentRegisterActivity.this);
                progressDialog.setMessage("Registering wait..");
                progressDialog.show();

                String studentname_register_text = studentname_register.getText().toString().trim();
                String studentphonenumber_register_text = studentphonenumber_register.getText().toString().trim();
                String studentmailid_register_text = studentmailid_register.getText().toString().trim();
                String studentid_register_text = studentid_register.getText().toString().trim();
                String studentdepartment_register_text = studentdepartment_register.getText().toString().trim();

                if(TextUtils.isEmpty(studentname_register_text) || TextUtils.isEmpty(studentphonenumber_register_text) || TextUtils.isEmpty(studentmailid_register_text) || TextUtils.isEmpty(studentid_register_text) || TextUtils.isEmpty(studentdepartment_register_text))
                {
                    Toast.makeText(StudentRegisterActivity.this, "All fields are Required", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    StudentModel studentModel = new StudentModel();

                    studentModel.setStudentname(studentname_register_text);
                    studentModel.setStudentphonenumber(studentphonenumber_register_text);
                    studentModel.setStudentmailid(studentmailid_register_text);
                    studentModel.setStudentid(studentid_register_text);
                    studentModel.setStudentdepartment(studentdepartment_register_text);

                    long register_status = sqliteHelper.addStudent(studentModel);

                    if (register_status != -1)
                    {
                        progressDialog.dismiss();
                        Toast.makeText(StudentRegisterActivity.this, "Registration Success", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(StudentRegisterActivity.this,StudentLoginActivity.class));
                        finish();
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(StudentRegisterActivity.this, "Registration Failure", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(StudentRegisterActivity.this,StudentLoginActivity.class));
                        finish();
                    }

                }
            }
        });


    }

    private void initFun() {

        studentname_register = (MaterialEditText)findViewById(R.id.studentname_register);
        studentphonenumber_register = (MaterialEditText)findViewById(R.id.studentphonenumber_register);
        studentmailid_register = (MaterialEditText)findViewById(R.id.studentmailid_register);
        studentid_register = (MaterialEditText)findViewById(R.id.studentid_register);
        studentdepartment_register = (MaterialEditText)findViewById(R.id.studentdepartment_register);

        student_loginref = (TextView)findViewById(R.id.student_loginref);
        student_register = (Button)findViewById(R.id.student_register);

    }
}
