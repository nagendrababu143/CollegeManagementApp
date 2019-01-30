package com.example.nagendra.collegemanagementapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nagendra.collegemanagementapp.models.AddAssessmentModel;

public class AddAssementActivity extends AppCompatActivity {

    EditText studentname_addassessment,testmarks_addassessment;
    Spinner spinner_month_addassessment,spinner_tests;
    Button submit_btn_addassessment;
    String item_month,item_test;
    SqliteHelper sqliteHelper = new SqliteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assement);

        studentname_addassessment = (EditText)findViewById(R.id.studentname_addassessment);
        testmarks_addassessment = (EditText)findViewById(R.id.testmarks_addassessment);

        spinner_month_addassessment = (Spinner)findViewById(R.id.spinner_month_addassessment);
        spinner_tests = (Spinner)findViewById(R.id.spinner_tests);
        submit_btn_addassessment = (Button)findViewById(R.id.submit_btn_addassessment);



        //months
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(AddAssementActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.months));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_month_addassessment.setAdapter(myAdapter);

        spinner_month_addassessment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                item_month = spinner_month_addassessment.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //tests
        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(AddAssementActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.tests));

        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_tests.setAdapter(myAdapter1);

        spinner_tests.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                item_test = spinner_tests.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        submit_btn_addassessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studentname_addassessment_text = studentname_addassessment.getText().toString().trim();
                String testmarks_addassessment_text = testmarks_addassessment.getText().toString().trim();

                AddAssessmentModel addAssessmentModel = new AddAssessmentModel();
                addAssessmentModel.setStudentname(studentname_addassessment_text);
                addAssessmentModel.setTestmarks(testmarks_addassessment_text);
                addAssessmentModel.setTest(item_test);
                addAssessmentModel.setMonth(item_month);


                long val = sqliteHelper.addAssessment(addAssessmentModel);
                if (val != -1)
                {

                    Toast.makeText(AddAssementActivity.this, "Success", Toast.LENGTH_SHORT).show();
                   /* startActivity(new Intent(AddAttendanceEachActivity.this,AdminLoginActivity.class));
                    finish();*/
                }
                else
                {

                    Toast.makeText(AddAssementActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                   /* startActivity(new Intent(AddAttendanceEachActivity.this,AdminLoginActivity.class));
                    finish();*/
                }

            }
        });

    }
}
