package com.example.nagendra.collegemanagementapp;

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

public class StudentLoginActivity extends AppCompatActivity {

    TextView student_registerref;

    MaterialEditText studentname_login,studentid_login;
    Button student_login;

    SqliteHelper sqliteHelper = new SqliteHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        initFun();

        student_registerref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentLoginActivity.this,StudentRegisterActivity.class);
                startActivity(intent);
            }
        });

        student_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String student_name = studentname_login.getText().toString().trim();
                String student_id =  studentid_login.getText().toString().trim();

                if(TextUtils.isEmpty(student_name) || TextUtils.isEmpty(student_id))
                {
                    Toast.makeText(StudentLoginActivity.this, "All fields are Required", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    StudentModel currenthodModel = sqliteHelper.Authenticate(new StudentModel(student_name, null, null, student_id,null));

                    if (currenthodModel != null)
                    {
                        Toast.makeText(StudentLoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(StudentLoginActivity.this,StudentFirstActivity.class));
                        finish();
                    }
                    else
                    {
                        Toast.makeText(StudentLoginActivity.this, "Login Failure", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(StudentLoginActivity.this,StudentLoginActivity.class));
                        finish();
                    }
                }

            }
        });
    }
    private void initFun() {

        studentname_login = (MaterialEditText)findViewById(R.id.studentname_login);
        studentid_login = (MaterialEditText)findViewById(R.id.studentid_login);
        student_login = (Button)findViewById(R.id.student_login);
        student_registerref = (TextView)findViewById(R.id.student_registerref);

    }
}
