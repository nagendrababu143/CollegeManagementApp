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
import com.rengwuxian.materialedittext.MaterialEditText;

public class AdminRegisterActivity extends AppCompatActivity {

    MaterialEditText hodname_register,hodphonenumber_register,hodmailid_register,hodid_register,hoddepartment_register;
    TextView loginref;
    Button hod_register;

    SqliteHelper sqliteHelper = new SqliteHelper(this);

    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_register);

        //initialization
        initFun();


        //login reference
        loginref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminRegisterActivity.this,AdminLoginActivity.class);
                startActivity(intent);
            }
        });

        hod_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog = new ProgressDialog(AdminRegisterActivity.this);
                progressDialog.setMessage("Registering wait..");
                progressDialog.show();

                String hodname_register_text = hodname_register.getText().toString().trim();
                String hodphonenumber_register_text = hodphonenumber_register.getText().toString().trim();
                String hodmailid_register_text = hodmailid_register.getText().toString().trim();
                String hodid_register_text = hodid_register.getText().toString().trim();
                String hoddepartment_register_text = hoddepartment_register.getText().toString().trim();



                if(TextUtils.isEmpty(hodname_register_text) || TextUtils.isEmpty(hodphonenumber_register_text) || TextUtils.isEmpty(hodmailid_register_text) || TextUtils.isEmpty(hodid_register_text) || TextUtils.isEmpty(hoddepartment_register_text))
                {
                    Toast.makeText(AdminRegisterActivity.this, "All fields are Required", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    HodModel hodModel = new HodModel();

                    hodModel.setHodname(hodname_register_text);
                    hodModel.setHodphonenumber(hodphonenumber_register_text);
                    hodModel.setHodmailid(hodmailid_register_text);
                    hodModel.setHodid(hodid_register_text);
                    hodModel.setHoddepartment(hoddepartment_register_text);

                    long register_status = sqliteHelper.addHod(hodModel);

                    if (register_status != -1)
                    {
                        progressDialog.dismiss();
                        Toast.makeText(AdminRegisterActivity.this, "Registration Success", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AdminRegisterActivity.this,AdminLoginActivity.class));
                        finish();
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(AdminRegisterActivity.this, "Registration Failure", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AdminRegisterActivity.this,AdminLoginActivity.class));
                        finish();
                    }

                }


            }
        });


    }

    private void initFun() {

        hodname_register = (MaterialEditText)findViewById(R.id.hodname_register);
        hodphonenumber_register = (MaterialEditText)findViewById(R.id.hodphonenumber_register);
        hodmailid_register = (MaterialEditText)findViewById(R.id.hodmailid_register);
        hodid_register = (MaterialEditText)findViewById(R.id.hodid_register);
        hoddepartment_register = (MaterialEditText)findViewById(R.id.hoddepartment_register);
        loginref = (TextView)findViewById(R.id.loginref);
        hod_register = (Button)findViewById(R.id.hod_register);

    }
}
