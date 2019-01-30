package com.example.nagendra.collegemanagementapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nagendra.collegemanagementapp.models.AssignmentModel;

import java.util.List;

public class AssignmentsStudentActivity extends AppCompatActivity {

    EditText mysubjectname_lecture;

    TextView mychapone,mynoone,mydateone,mychaptwo,mynotwo,mydatetwo,
            mychapthree,mynothree,mydatethree,mychapfour,mynofour,mydatefour,mychapfive,mynofive,mydatefive;

    Button myassignments;

    SqliteHelper sqliteHelper = new SqliteHelper(this);

    String mysubjectname_lecture_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments_student);

        initFun();

        myassignments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mysubjectname_lecture_text = mysubjectname_lecture.getText().toString().trim();

                AssignmentModel items = sqliteHelper.getAllTopics(mysubjectname_lecture_text);

                mychapone.setText(items.getChapone());
                mynoone.setText(items.getNoone());
                mydateone.setText(items.getDateone());

                mychaptwo.setText(items.getChaptwo());
                mynotwo.setText(items.getNotwo());
                mydatetwo.setText(items.getDatetwo());

                mychapthree.setText(items.getChapthree());
                mynothree.setText(items.getNothree());
                mydatethree.setText(items.getDatethree());

                mychapfour.setText(items.getChapfour());
                mynofour.setText(items.getNofour());
                mydatefour.setText(items.getDatefour());

                mychapfive.setText(items.getChapfive());
                mynofive.setText(items.getNofive());
                mydatefive.setText(items.getDatefive());

            }
        });

    }

    private void initFun() {

        mysubjectname_lecture = (EditText)findViewById(R.id.mysubjectname_lecture);

        mychapone = (TextView)findViewById(R.id.mychapone);
        mynoone = (TextView)findViewById(R.id.mynoone);
        mydateone = (TextView)findViewById(R.id.mydateone);
        mychaptwo = (TextView)findViewById(R.id.mychaptwo);
        mynotwo = (TextView)findViewById(R.id.mynotwo);
        mydatetwo = (TextView)findViewById(R.id.mydatetwo);
        mychapthree = (TextView)findViewById(R.id.mychapthree);
        mynothree = (TextView)findViewById(R.id.mynothree);
        mydatethree = (TextView)findViewById(R.id.mydatethree);
        mychapfour = (TextView)findViewById(R.id.mychapfour);
        mynofour = (TextView)findViewById(R.id.mynofour);
        mydatefour = (TextView)findViewById(R.id.mydatefour);
        mychapfive = (TextView)findViewById(R.id.mychapfive);
        mynofive = (TextView)findViewById(R.id.mynofive);
        mydatefive = (TextView)findViewById(R.id.mydatefive);

        myassignments = (Button) findViewById(R.id.myassignments);

    }
}
