package com.example.nagendra.collegemanagementapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.nagendra.collegemanagementapp.models.AddAssessmentModel;
import com.example.nagendra.collegemanagementapp.models.AssignmentModel;
import com.example.nagendra.collegemanagementapp.models.AttendanceModel;
import com.example.nagendra.collegemanagementapp.models.HodModel;
import com.example.nagendra.collegemanagementapp.models.StudentModel;
import com.example.nagendra.collegemanagementapp.models.SubjectModel;
import com.example.nagendra.collegemanagementapp.models.TeacherModel;

import java.util.ArrayList;
import java.util.List;

public class SqliteHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "college.db";
    public static final int DATABASE_VERSION = 1;

    //tables
    public static final String TABLE_HOD = "hod";
    public static final String TABLE_SUBJECT = "subject";
    public static final String TABLE_TEACHER = "teacher";
    public static final String TABLE_ASSIGNMENT = "assignment";
    public static final String TABLE_STUDENT = "student";
    public static final String TABLE_ATTENDANCE = "attendance";
    public static final String TABLE_ASSESSMENT = "assessment";

    //hod table data
    public static final String KEY_ID = "id";

    public static final String KEY_HOD_NAME = "hodname";
    public static final String KEY_HOD_NUMBER = "hodnumber";
    public static final String KEY_HOD_MAIL_ID = "hodmailid";
    public static final String KEY_HOD_ID = "hodid";
    public static final String KEY_HOD_DEPARTMENT = "hoddepartment";


    //subject table data
    public static final String KEY_SUBJECT_ID = "id";

    public static final String KEY_SUBJECT_NAME = "subjectname";
    public static final String KEY_CHAPTERS = "chapters";
    public static final String KEY_NOOFTEST = "nooftest";
    public static final String KEY_NOOFPERIOD = "noofperiods";
    public static final String KEY_DATE = "date";

    //teacher table data
    public static final String KEY_TEACH_ID = "id";

    public static final String KEY_TEACHER_NAME = "teachername";
    public static final String KEY_TEACHER_NUMBER = "teachernumber";
    public static final String KEY_TEACHER_MAIL_ID = "teachermailid";
    public static final String KEY_TEACHER_ID = "teacherid";
    public static final String KEY_TEACHER_DEPARTMENT = "teacherdepartment";

    //teacher ASSIGNMENT data
    public static final String KEY_ASSIGNMENT_ID = "id";

    public static final String KEY_SUBJECT_ASSIGN_NAME = "subjectnameassign";

    public static final String KEY_CHAPTER_ONE = "chapterone";
    public static final String KEY_NO_ONE = "numberone";
    public static final String KEY_DATE_ONE = "dateone";

    public static final String KEY_CHAPTER_TWO = "chaptertwo";
    public static final String KEY_NO_TWO = "numbertwo";
    public static final String KEY_DATE_TWO = "datetwo";

    public static final String KEY_CHAPTER_THREE = "chapterthree";
    public static final String KEY_NO_THREE = "numberthree";
    public static final String KEY_DATE_THREE = "datethree";

    public static final String KEY_CHAPTER_FOUR = "chapterfour";
    public static final String KEY_NO_FOUR = "numberfour";
    public static final String KEY_DATE_FOUR = "datefour";

    public static final String KEY_CHAPTER_FIVE = "chapterfive";
    public static final String KEY_NO_FIVE = "numberfive";
    public static final String KEY_DATE_FIVE = "datefive";


    //teacher table data
    public static final String KEY_STUD_ID = "id";

    public static final String KEY_STUDENT_NAME = "studentname";
    public static final String KEY_STUDENT_NUMBER = "studentnumber";
    public static final String KEY_STUDENT_MAIL_ID = "studentmailid";
    public static final String KEY_STUDENT_ID = "studentid";
    public static final String KEY_STUDENT_DEPARTMENT = "studentdepartment";

    //ATTENDANCE table data
    public static final String KEY_ATTEND_ID = "id";

    public static final String KEY_ATTEND_NAME = "attendname";
    public static final String KEY_ATTEND_MONTH = "attendmonth";
    public static final String KEY_ATTEND_DAY = "attendday";
    public static final String KEY_ATTEND_STATUS = "attendstatus";

    //Assessment table data
    public static final String KEY_ASSESSMENT_ID = "id";

    public static final String KEY_ASSESSMENT_STUDENTNAME = "assessmentstudentname";
    public static final String KEY_ASSESSMENT_MONTH = "assessmentmonth";
    public static final String KEY_ASSESSMENT_TEST = "assessmenttest";
    public static final String KEY_ASSESSMENT_TESTMARKS = "assessmenttestmarks";


    public SqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //SQL for creating hod table
    public static final String SQL_TABLE_HOD = " CREATE TABLE " + TABLE_HOD
            + " ( "
            + KEY_ID + " INTEGER PRIMARY KEY, "
            + KEY_HOD_NAME + " TEXT, "
            + KEY_HOD_NUMBER + " TEXT, "
            + KEY_HOD_MAIL_ID + " TEXT,"
            + KEY_HOD_ID + " TEXT,"
            + KEY_HOD_DEPARTMENT + " TEXT"
            + " ) ";


    //SQL for creating subject table
    public static final String SQL_TABLE_SUBJECT = " CREATE TABLE " + TABLE_SUBJECT
            + " ( "
            + KEY_SUBJECT_ID + " INTEGER PRIMARY KEY, "
            + KEY_SUBJECT_NAME + " TEXT, "
            + KEY_CHAPTERS + " TEXT, "
            + KEY_NOOFTEST + " TEXT,"
            + KEY_NOOFPERIOD + " TEXT,"
            + KEY_DATE + " TEXT"
            + " ) ";


    //SQL for creating hod table
    public static final String SQL_TABLE_TEACHER = " CREATE TABLE " + TABLE_TEACHER
            + " ( "
            + KEY_TEACH_ID + " INTEGER PRIMARY KEY, "
            + KEY_TEACHER_NAME + " TEXT, "
            + KEY_TEACHER_NUMBER + " TEXT, "
            + KEY_TEACHER_MAIL_ID + " TEXT,"
            + KEY_TEACHER_ID + " TEXT,"
            + KEY_TEACHER_DEPARTMENT + " TEXT"
            + " ) ";

    //SQL for creating Assignment table
    public static final String SQL_TABLE_ASSIGNMENT = " CREATE TABLE " + TABLE_ASSIGNMENT
            + " ( "
            + KEY_ASSIGNMENT_ID + " INTEGER PRIMARY KEY, "

            + KEY_SUBJECT_ASSIGN_NAME + " TEXT, "

            + KEY_CHAPTER_ONE + " TEXT, "
            + KEY_NO_ONE + " TEXT,"
            + KEY_DATE_ONE + " TEXT,"

            + KEY_CHAPTER_TWO + " TEXT,"
            + KEY_NO_TWO + " TEXT,"
            + KEY_DATE_TWO + " TEXT,"

            + KEY_CHAPTER_THREE + " TEXT,"
            + KEY_NO_THREE + " TEXT,"
            + KEY_DATE_THREE + " TEXT,"

            + KEY_CHAPTER_FOUR + " TEXT,"
            + KEY_NO_FOUR + " TEXT,"
            + KEY_DATE_FOUR + " TEXT,"

            + KEY_CHAPTER_FIVE + " TEXT,"
            + KEY_NO_FIVE + " TEXT,"
            + KEY_DATE_FIVE + " TEXT"

            + " ) ";


    //SQL for creating student table
    public static final String SQL_TABLE_STUDENT = " CREATE TABLE " + TABLE_STUDENT
            + " ( "
            + KEY_STUD_ID + " INTEGER PRIMARY KEY, "
            + KEY_STUDENT_NAME + " TEXT, "
            + KEY_STUDENT_NUMBER + " TEXT, "
            + KEY_STUDENT_MAIL_ID + " TEXT,"
            + KEY_STUDENT_ID + " TEXT,"
            + KEY_STUDENT_DEPARTMENT + " TEXT"
            + " ) ";

    //SQL for creating attendance table
    public static final String SQL_TABLE_ATTENDANCE = " CREATE TABLE " + TABLE_ATTENDANCE
            + " ( "
            + KEY_ATTEND_ID + " INTEGER PRIMARY KEY, "
            + KEY_ATTEND_NAME + " TEXT, "
            + KEY_ATTEND_MONTH + " TEXT, "
            + KEY_ATTEND_DAY + " TEXT,"
            + KEY_ATTEND_STATUS + " TEXT"
            + " ) ";

    //SQL for creating assessment table
    public static final String SQL_TABLE_ASSESSMENT = " CREATE TABLE " + TABLE_ASSESSMENT
            + " ( "
            + KEY_ASSESSMENT_ID + " INTEGER PRIMARY KEY, "
            + KEY_ASSESSMENT_STUDENTNAME + " TEXT, "
            + KEY_ASSESSMENT_MONTH + " TEXT, "
            + KEY_ASSESSMENT_TEST + " TEXT,"
            + KEY_ASSESSMENT_TESTMARKS + " TEXT"
            + " ) ";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //Create Table when oncreate gets called
        sqLiteDatabase.execSQL(SQL_TABLE_HOD);
        sqLiteDatabase.execSQL(SQL_TABLE_SUBJECT);
        sqLiteDatabase.execSQL(SQL_TABLE_TEACHER);
        sqLiteDatabase.execSQL(SQL_TABLE_ASSIGNMENT);
        sqLiteDatabase.execSQL(SQL_TABLE_STUDENT);
        sqLiteDatabase.execSQL(SQL_TABLE_ATTENDANCE);
        sqLiteDatabase.execSQL(SQL_TABLE_ASSESSMENT);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //drop table to create new one if database version updated
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_HOD);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_SUBJECT);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_TEACHER);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_ASSIGNMENT);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_STUDENT);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_ATTENDANCE);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_ASSESSMENT);

        onCreate(sqLiteDatabase);

    }

    //using this method we can add users to user table
    public long addHod(HodModel hodModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_HOD_NAME, hodModel.getHodname());
        values.put(KEY_HOD_NUMBER, hodModel.getHodphonenumber());
        values.put(KEY_HOD_MAIL_ID, hodModel.getHodmailid());
        values.put(KEY_HOD_ID, hodModel.getHodid());
        values.put(KEY_HOD_DEPARTMENT, hodModel.getHoddepartment());

        // insert row
        long todo_id = db.insert(TABLE_HOD, null, values);

        return todo_id;

    }


    public long addSubject(SubjectModel subjectModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values1 = new ContentValues();

        values1.put(KEY_SUBJECT_NAME, subjectModel.getSubjectname());
        values1.put(KEY_CHAPTERS, subjectModel.getChapters());
        values1.put(KEY_NOOFTEST, subjectModel.getNooftest());
        values1.put(KEY_NOOFPERIOD, subjectModel.getNoofperiods());
        values1.put(KEY_DATE, subjectModel.getDate());

        // insert row
        long todo_id1 = db.insert(TABLE_SUBJECT, null, values1);

        return todo_id1;

    }


    //username and password are matching or not

    public HodModel Authenticate(HodModel hodModel) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor1 = db.query(TABLE_HOD,// Selecting Table
                new String[]{KEY_ID, KEY_HOD_NAME, KEY_HOD_NUMBER, KEY_HOD_MAIL_ID,KEY_HOD_ID,KEY_HOD_DEPARTMENT},//Selecting columns want to query
                KEY_HOD_NAME + "=?",
                new String[]{hodModel.getHodname()},//Where clause
                null, null, null);

        if (cursor1 != null && cursor1.moveToFirst()&& cursor1.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email
            HodModel hodModel1 = new HodModel(cursor1.getString(1), cursor1.getString(2), cursor1.getString(3),cursor1.getString(4),cursor1.getString(5));

            //Match both passwords check they are same or not
            if (hodModel.getHodid().equalsIgnoreCase(hodModel1.getHodid())) {
                return hodModel1;
            }
        }

        //if user password does not matches or there is no record with that email then return @false
        return null;
    }

    public long addTeacher(TeacherModel teacherModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values1 = new ContentValues();

        values1.put(KEY_TEACHER_NAME, teacherModel.getTeachername());
        values1.put(KEY_TEACHER_NUMBER, teacherModel.getTeacherphonenumber());
        values1.put(KEY_TEACHER_MAIL_ID, teacherModel.getTeachermailid());
        values1.put(KEY_TEACHER_ID, teacherModel.getTeacherid());
        values1.put(KEY_TEACHER_DEPARTMENT, teacherModel.getTeacherdepartment());

        // insert row
        long todo_id1 = db.insert(TABLE_TEACHER, null, values1);

        return todo_id1;

    }

    public TeacherModel Authenticate(TeacherModel teacherModel) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor1 = db.query(TABLE_TEACHER,// Selecting Table
                new String[]{KEY_TEACH_ID, KEY_TEACHER_NAME, KEY_TEACHER_NUMBER, KEY_TEACHER_MAIL_ID,KEY_TEACHER_ID,KEY_TEACHER_DEPARTMENT},//Selecting columns want to query
                KEY_TEACHER_NAME + "=?",
                new String[]{teacherModel.getTeachername()},//Where clause
                null, null, null);

        if (cursor1 != null && cursor1.moveToFirst()&& cursor1.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email
            TeacherModel teacherModel1 = new TeacherModel(cursor1.getString(1), cursor1.getString(2), cursor1.getString(3),cursor1.getString(4),cursor1.getString(5));

            //Match both passwords check they are same or not
            if (teacherModel.getTeacherid().equalsIgnoreCase(teacherModel1.getTeacherid())) {
                return teacherModel1;
            }
        }

        //if user password does not matches or there is no record with that email then return @false
        return null;

    }

    public SubjectModel getData(String subjectname_teacher_text) {

        SQLiteDatabase db = this.getReadableDatabase();

        SubjectModel subjectModel =null;

        Cursor cursor1 = db.query(TABLE_SUBJECT,// Selecting Table
                new String[]{KEY_SUBJECT_NAME, KEY_CHAPTERS, KEY_NOOFTEST,KEY_NOOFPERIOD,KEY_DATE},//Selecting columns want to query
                KEY_SUBJECT_NAME + "=?",
                new String[]{subjectname_teacher_text},//Where clause
                null, null, null);

        if (cursor1 != null && cursor1.moveToFirst()&& cursor1.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email
            subjectModel = new SubjectModel(cursor1.getString(0), cursor1.getString(1), cursor1.getString(2),cursor1.getString(3),cursor1.getString(4));

            //Match both passwords check they are same or not
            if (subjectname_teacher_text.equalsIgnoreCase(subjectModel.getSubjectname())) {
                return subjectModel;
            }
        }

        return null;
    }

    public long addAssignment(AssignmentModel assignmentModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values1 = new ContentValues();


        values1.put(KEY_SUBJECT_ASSIGN_NAME, assignmentModel.getSubjectname_lecture());

        values1.put(KEY_CHAPTER_ONE, assignmentModel.getChapone());
        values1.put(KEY_NO_ONE, assignmentModel.getNoone());
        values1.put(KEY_DATE_TWO, assignmentModel.getDateone());

        values1.put(KEY_CHAPTER_TWO, assignmentModel.getChaptwo());
        values1.put(KEY_NO_TWO, assignmentModel.getNotwo());
        values1.put(KEY_DATE_ONE, assignmentModel.getDatetwo());

        values1.put(KEY_CHAPTER_THREE, assignmentModel.getChapthree());
        values1.put(KEY_NO_THREE, assignmentModel.getNothree());
        values1.put(KEY_DATE_THREE, assignmentModel.getDatethree());

        values1.put(KEY_CHAPTER_FOUR, assignmentModel.getChapfour());
        values1.put(KEY_NO_FOUR, assignmentModel.getNofour());
        values1.put(KEY_DATE_FOUR, assignmentModel.getDatefour());

        values1.put(KEY_CHAPTER_FIVE, assignmentModel.getChapfive());
        values1.put(KEY_NO_FIVE, assignmentModel.getNofive());
        values1.put(KEY_DATE_FIVE, assignmentModel.getDatefive());


        // insert row
        long todo_id1 = db.insert(TABLE_ASSIGNMENT, null, values1);

        return todo_id1;
    }

    public long addStudent(StudentModel studentModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values1 = new ContentValues();

        values1.put(KEY_STUDENT_NAME, studentModel.getStudentname());
        values1.put(KEY_STUDENT_NUMBER, studentModel.getStudentphonenumber());
        values1.put(KEY_STUDENT_MAIL_ID, studentModel.getStudentmailid());
        values1.put(KEY_STUDENT_ID, studentModel.getStudentid());
        values1.put(KEY_STUDENT_DEPARTMENT, studentModel.getStudentdepartment());

        // insert row
        long todo_id1 = db.insert(TABLE_STUDENT, null, values1);

        return todo_id1;
    }

    public StudentModel Authenticate(StudentModel studentModel) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor1 = db.query(TABLE_STUDENT,// Selecting Table
                new String[]{KEY_STUD_ID, KEY_STUDENT_NAME, KEY_STUDENT_NUMBER, KEY_STUDENT_MAIL_ID,KEY_STUDENT_ID,KEY_STUDENT_DEPARTMENT},//Selecting columns want to query
                KEY_STUDENT_NAME + "=?",
                new String[]{studentModel.getStudentname()},//Where clause
                null, null, null);

        if (cursor1 != null && cursor1.moveToFirst()&& cursor1.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email
            StudentModel studentModel1 = new StudentModel(cursor1.getString(1), cursor1.getString(2), cursor1.getString(3),cursor1.getString(4),cursor1.getString(5));

            //Match both passwords check they are same or not
            if (studentModel.getStudentid().equalsIgnoreCase(studentModel1.getStudentid())) {
                return studentModel1;
            }
        }

        //if user password does not matches or there is no record with that email then return @false
        return null;

    }

    public boolean allCount(String name) {

        SQLiteDatabase db = this.getReadableDatabase();

        SubjectModel subjectModel =null;

        Cursor cursor1 = db.query(TABLE_STUDENT,// Selecting Table
                new String[]{KEY_STUDENT_NAME},//Selecting columns want to query
                KEY_STUDENT_NAME + "=?",
                new String[]{name},//Where clause
                null, null, null);

        if (cursor1 != null && cursor1.moveToFirst()&& cursor1.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email


            //Match both passwords check they are same or not
            if (name.equalsIgnoreCase(cursor1.getString(0))) {
                return true;
            }
        }

        return false;
    }

    public long addAvailability(AttendanceModel attendanceModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values1 = new ContentValues();

        values1.put(KEY_ATTEND_NAME, attendanceModel.getName());
        values1.put(KEY_ATTEND_MONTH, attendanceModel.getMonth());
        values1.put(KEY_ATTEND_DAY, attendanceModel.getDay());
        values1.put(KEY_ATTEND_STATUS, attendanceModel.getStatus());


        // insert row
        long todo_id1 = db.insert(TABLE_ATTENDANCE, null, values1);

        return todo_id1;
    }

    public int getTheCount(String studentname_viewattendance_text, String month_viewattendance_text) {

        String val = "Present";

        SQLiteDatabase db = this.getReadableDatabase();

        /*Cursor cursor1 = db.query(TABLE_ATTENDANCE,// Selecting Table
                new String[]{KEY_ATTEND_NAME,KEY_ATTEND_MONTH,KEY_ATTEND_STATUS},//Selecting columns want to query
                KEY_ATTEND_NAME + "=? AND" + KEY_ATTEND_MONTH +"=? AND"+KEY_ATTEND_STATUS+"=?",
                new String[]{studentname_viewattendance_text,month_viewattendance_text,"Present"},//Where clause
                null, null, null);*/

        //String selectQuery = "SELECT * FROM TABLE_ATTENDANCE " + " WHERE attendname = " + studentname_viewattendance_text + " AND attendmonth = " + month_viewattendance_text + " AND attendstatus = " + val ;

        //SELECT * FROM attendance WHERE attendname="stud" AND attendmonth="march" AND attendstatus="Present";

        Cursor cursor = db.rawQuery("SELECT * FROM attendance  WHERE attendname=? and attendmonth=? and attendstatus=?" ,new String[]{studentname_viewattendance_text,month_viewattendance_text,val});

        /*Cursor cursor1 = db.query(TABLE_ATTENDANCE,// Selecting Table
                new String[]{KEY_ATTEND_NAME,KEY_ATTEND_MONTH,KEY_ATTEND_STATUS},//Selecting columns want to query
                KEY_STUDENT_NAME + " =? AND " + KEY_ATTEND_MONTH + " =? AND " + KEY_ATTEND_STATUS + " =? ",
                new String[]{studentname_viewattendance_text,month_viewattendance_text,val},//Where clause
                null, null, null);*/

        if (cursor.getCount()>0) {
            return cursor.getCount();
        }

        return 0;

    }

    public long addAssessment(AddAssessmentModel addAssessmentModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values1 = new ContentValues();

        values1.put(KEY_ASSESSMENT_STUDENTNAME, addAssessmentModel.getStudentname());
        values1.put(KEY_ASSESSMENT_MONTH, addAssessmentModel.getMonth());
        values1.put(KEY_ASSESSMENT_TEST, addAssessmentModel.getTest());
        values1.put(KEY_ASSESSMENT_TESTMARKS, addAssessmentModel.getTestmarks());


        // insert row
        long todo_id1 = db.insert(TABLE_ASSESSMENT, null, values1);

        return todo_id1;

    }

    public int totalMarks(String studentname_viewassessment_text, String month_viewassessment_text) {

        int val=0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT assessmenttestmarks FROM assessment  WHERE assessmentstudentname=? and assessmentmonth=?" ,new String[]{studentname_viewassessment_text,month_viewassessment_text});

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {

            for (int i=0;i<cursor.getCount();i++) {
                val = val + Integer.valueOf(cursor.getString(0));
            }
        }
        return val;
    }

    public AssignmentModel getAllTopics(String mysubjectname_lecture_text) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM assignment  WHERE subjectnameassign=?" ,new String[]{mysubjectname_lecture_text});

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {

            AssignmentModel assignmentModel = new AssignmentModel();

            assignmentModel.setChapone(cursor.getString(0));
            assignmentModel.setNoone(cursor.getString(1));
            assignmentModel.setDateone(cursor.getString(2));

            assignmentModel.setChaptwo(cursor.getString(3));
            assignmentModel.setNotwo(cursor.getString(4));
            assignmentModel.setDatetwo(cursor.getString(5));

            assignmentModel.setChapthree(cursor.getString(6));
            assignmentModel.setNothree(cursor.getString(7));
            assignmentModel.setDatethree(cursor.getString(8));

            assignmentModel.setChapfour(cursor.getString(9));
            assignmentModel.setNofour(cursor.getString(10));
            assignmentModel.setDatefour(cursor.getString(11));

            assignmentModel.setChapfive(cursor.getString(12));
            assignmentModel.setNofive(cursor.getString(13));
            assignmentModel.setDatefive(cursor.getString(14));

            return assignmentModel;
        }

        return null;
    }





    /*public long addStudent(StudentModel studentModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values1 = new ContentValues();

        values1.put(KEY_STUDENT_NAME, studentModel.getStudentname());
        values1.put(KEY_STUDENT_NUMBER, studentModel.getStudentphonenumber());
        values1.put(KEY_STUDENT_MAIL_ID, studentModel.getStudentmailid());
        values1.put(KEY_STUDENT_ID, studentModel.getStudentid());
        values1.put(KEY_STUDENT_DEPARTMENT, studentModel.getStudentdepartment());

        // insert row
        long todo_id1 = db.insert(TABLE_STUDENT, null, values1);

        return todo_id1;
    }*/

    //hod name exists or not

    /*public boolean isHodnameExists(String hodname) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_HOD,// Selecting Table
                new String[]{KEY_ID, KEY_HOD_NAME, KEY_HOD_NUMBER, KEY_HOD_MAIL_ID,KEY_HOD_ID,KEY_HOD_DEPARTMENT},//Selecting columns want to query
                KEY_HOD_NAME + "=?",
                new String[]{hodname},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email so return true
            return true;
        }

        //if email does not exist return false
        return false;
    }*/
}
