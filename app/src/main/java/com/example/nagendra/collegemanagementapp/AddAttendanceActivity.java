package com.example.nagendra.collegemanagementapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddAttendanceActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    SqliteHelper sqliteHelper = new SqliteHelper(this);
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attendance);

        editText = (EditText)findViewById(R.id.student_name_teacher);
        button = (Button)findViewById(R.id.search);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString().trim();

                boolean count = sqliteHelper.allCount(name);

                if(count)
                {
                    Intent intent = new Intent(AddAttendanceActivity.this,AddAttendanceEachActivity.class);
                    intent.putExtra("name",name);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(AddAttendanceActivity.this, "No student with this name", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
