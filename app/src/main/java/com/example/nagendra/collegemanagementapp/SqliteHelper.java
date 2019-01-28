package com.example.nagendra.collegemanagementapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.nagendra.collegemanagementapp.models.HodModel;
import com.example.nagendra.collegemanagementapp.models.SubjectModel;
import com.example.nagendra.collegemanagementapp.models.TeacherModel;

public class SqliteHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "college.db";
    public static final int DATABASE_VERSION = 1;

    //tables
    public static final String TABLE_HOD = "hod";
    public static final String TABLE_SUBJECT = "subject";
    public static final String TABLE_TEACHER = "teacher";

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




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //Create Table when oncreate gets called
        sqLiteDatabase.execSQL(SQL_TABLE_HOD);
        sqLiteDatabase.execSQL(SQL_TABLE_SUBJECT);
        sqLiteDatabase.execSQL(SQL_TABLE_TEACHER);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //drop table to create new one if database version updated
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_HOD);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_SUBJECT);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_TEACHER);

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
