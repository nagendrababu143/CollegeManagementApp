package com.example.nagendra.collegemanagementapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nagendra.collegemanagementapp.models.AttendanceModel;

public class AddAttendanceEachActivity extends AppCompatActivity {

    Spinner months,days;
    TextView studentname_attendance;

    private RadioGroup status;
    private RadioButton presentstatus;

    Button submit;

    String item_day,item_month;

    SqliteHelper sqliteHelper = new SqliteHelper(this);
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attendance_each);

        Bundle bundle = getIntent().getExtras();
        final String name1 = bundle.getString("name");

        studentname_attendance = (TextView) findViewById(R.id.studentname_attendance);
        studentname_attendance.setText(name1);

        months = (Spinner)findViewById(R.id.spinner_months);
        days = (Spinner)findViewById(R.id.spinner_days);

        status = (RadioGroup) findViewById(R.id.radioSex);
        submit = (Button)findViewById(R.id.submit);



        //months
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(AddAttendanceEachActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.months));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        months.setAdapter(myAdapter);

        months.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                item_month = months.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //months
        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(AddAttendanceEachActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.days));

        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        days.setAdapter(myAdapter1);

        days.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                item_day = days.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        int selectedId = status.getCheckedRadioButtonId();

        presentstatus = (RadioButton) findViewById(selectedId);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //absent and present
                int selectedId = status.getCheckedRadioButtonId();
                presentstatus = (RadioButton) findViewById(selectedId);

                String available = (String) presentstatus.getText();

                Toast.makeText(AddAttendanceEachActivity.this, name1+"\n"+item_month+"\n"+item_day+"\n"+available, Toast.LENGTH_SHORT).show();

                AttendanceModel attendanceModel = new AttendanceModel();
                attendanceModel.setName(name1);
                attendanceModel.setMonth(item_month);
                attendanceModel.setDay(item_day);
                attendanceModel.setStatus(available);

                long val = sqliteHelper.addAvailability(attendanceModel);

                if (val != -1)
                {

                    Toast.makeText(AddAttendanceEachActivity.this, "Success", Toast.LENGTH_SHORT).show();
                   /* startActivity(new Intent(AddAttendanceEachActivity.this,AdminLoginActivity.class));
                    finish();*/
                }
                else
                {

                    Toast.makeText(AddAttendanceEachActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                   /* startActivity(new Intent(AddAttendanceEachActivity.this,AdminLoginActivity.class));
                    finish();*/
                }
            }
        });
    }
}
