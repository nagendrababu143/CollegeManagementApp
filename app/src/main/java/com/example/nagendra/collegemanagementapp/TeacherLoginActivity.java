package com.example.nagendra.collegemanagementapp;

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

public class TeacherLoginActivity extends AppCompatActivity {

    TextView teacher_registerref;

    MaterialEditText teachername_login,teacherid_login;
    Button teacher_login;
    SqliteHelper sqliteHelper = new SqliteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);

        initFun();

        teacher_registerref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeacherLoginActivity.this,TeacherRegisterActivity.class);
                startActivity(intent);
            }
        });

        teacher_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String teacher_name = teachername_login.getText().toString().trim();
                String teacher_id =  teacherid_login.getText().toString().trim();

                if(TextUtils.isEmpty(teacher_name) || TextUtils.isEmpty(teacher_id))
                {
                    Toast.makeText(TeacherLoginActivity.this, "All fields are Required", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    TeacherModel currenthodModel = sqliteHelper.Authenticate(new TeacherModel(teacher_name, null, null, teacher_id,null));

                    if (currenthodModel != null)
                    {
                        Toast.makeText(TeacherLoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(TeacherLoginActivity.this,TeacherFirstActivity.class));
                        finish();
                    }
                    else
                    {
                        Toast.makeText(TeacherLoginActivity.this, "Login Failure", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(TeacherLoginActivity.this,MainActivity.class));
                        finish();
                    }
                }

            }
        });

    }

    private void initFun() {

        teachername_login = (MaterialEditText)findViewById(R.id.teachername_login);
        teacherid_login = (MaterialEditText)findViewById(R.id.teacherid_login);
        teacher_login = (Button)findViewById(R.id.teacher_login);
        teacher_registerref = (TextView)findViewById(R.id.teacher_registerref);

    }
}
