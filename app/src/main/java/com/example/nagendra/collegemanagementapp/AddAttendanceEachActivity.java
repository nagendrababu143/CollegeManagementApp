package com.example.nagendra.collegemanagementapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddAttendanceEachActivity extends AppCompatActivity {

    Spinner months,days;
    TextView studentname_attendance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attendance_each);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");

        studentname_attendance = (TextView) findViewById(R.id.studentname_attendance);
        studentname_attendance.setText(name);

        months = (Spinner)findViewById(R.id.spinner_months);
        days = (Spinner)findViewById(R.id.spinner_days);

        //months
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(AddAttendanceEachActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.months));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        months.setAdapter(myAdapter);

        months.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String selectedItemText = (String) adapterView.getItemAtPosition(i);
                // Notify the selected item text
                Toast.makeText(AddAttendanceEachActivity.this, "Selected : " + selectedItemText, Toast.LENGTH_SHORT).show();
            }
        });

        //days
        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(AddAttendanceEachActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.days));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        days.setAdapter(myAdapter);

        days.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String selectedItemText = (String) adapterView.getItemAtPosition(i);
                // Notify the selected item text
                Toast.makeText(AddAttendanceEachActivity.this, "Selected : " + selectedItemText, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
