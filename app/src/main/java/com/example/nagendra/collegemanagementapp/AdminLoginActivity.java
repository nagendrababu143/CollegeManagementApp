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
import com.rengwuxian.materialedittext.MaterialEditText;

public class AdminLoginActivity extends AppCompatActivity {

    TextView registerref;
    MaterialEditText hodname_login,hodid_login;
    Button hod_login;
    SqliteHelper sqliteHelper = new SqliteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        initFun();

        registerref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminLoginActivity.this,AdminRegisterActivity.class);
                startActivity(intent);
            }
        });

        hod_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String hod_name = hodname_login.getText().toString().trim();
                String hod_id =  hodid_login.getText().toString().trim();

                if(TextUtils.isEmpty(hod_name) || TextUtils.isEmpty(hod_id))
                {
                    Toast.makeText(AdminLoginActivity.this, "All fields are Required", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    HodModel currenthodModel = sqliteHelper.Authenticate(new HodModel(hod_name, null, null, hod_id,null));

                    if (currenthodModel != null)
                    {
                        Toast.makeText(AdminLoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(AdminLoginActivity.this,AdminFirstActivity.class));
                        finish();
                    }
                    else
                    {
                        Toast.makeText(AdminLoginActivity.this, "Login Failure", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(AdminLoginActivity.this,MainActivity.class));
                        finish();
                    }
                }

            }
        });
    }

    private void initFun() {

        hodname_login = (MaterialEditText)findViewById(R.id.hodname_login);
        hodid_login = (MaterialEditText)findViewById(R.id.hodid_login);
        hod_login = (Button)findViewById(R.id.hod_login);
        registerref = (TextView)findViewById(R.id.registerref);

    }
}
