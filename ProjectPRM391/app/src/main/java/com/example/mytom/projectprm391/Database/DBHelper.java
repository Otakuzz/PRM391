package com.example.mytom.projectprm391.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.mytom.projectprm391.Item.QuestionSets;
import com.example.mytom.projectprm391.Item.User;

/**
 * Created by Mytom on 3/15/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    public static final String DB_NAME = "MobileQuiz.db";
    public static final String USERS_TABLE_NAME = "users";
    public static final String USERS_COLUMN_ID = "id";
    public static final String USERS_COLUMN_NAME = "name";
    public static final String USERS_COLUMN_EMAIL = "email";
    public static final String USERS_COLUMN_PASSWORD = "password";
    public static final int DB_VERSION = 1;

    public DBHelper(Context context, String DB_NAME, SQLiteDatabase.CursorFactory factory, int DB_VERSION) {
        super(context, DB_NAME, factory, DB_VERSION);
        this.db = getWritableDatabase();
    }

    public DBHelper(Context context, String DB_NAME, SQLiteDatabase.CursorFactory factory, int DB_VERSION, DatabaseErrorHandler errorHandler) {
        super(context, DB_NAME, factory, DB_VERSION, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE `users` (\n" +
                "`user_id` mediumint,\n" +
                "`user_name` varchar(255) default NULL,\n" +
                "`user_email` varchar(255) default NULL,\n" +
                "`user_password` varchar(100) default NULL\n" +
                ");" +
                "CREATE TABLE 'question_sets' (\n"+
                "'set_id' mediumint, \n" +
                "'set_name' varchar(255) default NULL, \n" +
                "'user_id' int default 0, FOREIGN KEY(user_id) REFERENCES 'users'(user_id) \n" +
                "'time_limit' int default 0, \n" +
                "'is_saved' boolean default 0); \n" +
                "CREATE TABLE 'history' (\n"+
                "'user_id' int default 0, FOREIGN KEY(user_id) REFERENCES 'users'(user_id) \n" +
                "'set_id' int default 0, FOREIGN KEY(set_id) REFERENCES 'question_sets'(set_id) \n" +
                "'time_finish' varchar(255) default NULL, \n" +
                "'user_id' int default 0, FOREIGN KEY(user_id) REFERENCES 'users'(user_id) \n" +
                "'time_finish' int default 0, \n" +
                "'num_passed' boolean default 0, \n"+
                "'date_take' datetime  default NULL); \n"+
                "CREATE TABLE 'questions' (\n"+
                "'set_id' int default 0, FOREIGN KEY(set_id) REFERENCES 'question_sets'(set_id) \n" +
                "'type' varchar(255) default NULL" +
                "'image_path' varchar(255) default NULL" +
                "'question_id' mediumint" +
                "'question_title' varchar(1000) default null, \n" +
                "'is_correct' boolean default 0); \n" +
                "CREATE TABLE 'multiple_choice_data' (\n"+
                "'question_id' int default 0, FOREIGN KEY(question_id) REFERENCES 'questions'(question_id) \n" +
                "'answer_id' mediumint" +
                "'answer_title' varchar(1000) default null, \n" +
                "'is_checked' boolean default 0) \n";


        //and after that, execute the sql statement
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }

    public boolean insertNewUser(int id, String name, String email, String pass) {
        try {
            ContentValues data = new ContentValues();
            data.put(USERS_COLUMN_ID, id);
            data.put(USERS_COLUMN_NAME, name);
            data.put(USERS_COLUMN_EMAIL, email);
            data.put(USERS_COLUMN_PASSWORD, pass);

            db.insert(USERS_TABLE_NAME,null,data);
            Log.v("Insert New User", "Completed!");
            db.close();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }


    public User getUser(int userID) {
        String sql = "SELECT user_name,user_password,user_email FROM users WHERE user_id = " + userID;
        Cursor rs = null;
        rs = this.db.rawQuery(sql, null);
        rs.moveToFirst();
        User user = new User();
        user.setUserID(rs.getInt(rs.getColumnIndex(USERS_COLUMN_ID)));
        user.setUserName(rs.getString(rs.getColumnIndex(USERS_COLUMN_NAME)));
        user.setEmail(rs.getString(rs.getColumnIndex(USERS_COLUMN_EMAIL)));
        user.setPassword(rs.getString(rs.getColumnIndex(USERS_COLUMN_PASSWORD)));
        rs.moveToNext();
        rs.close();
        Log.v("Insert New User", "Completed!");
        db.close();
        return user;
    }
    public QuestionSets getQuestionSet(int userID) {
        String sql = "SELECT set_id,user_password,user_email FROM users WHERE user_id = " + userID;
        Cursor rs = null;
        rs = this.db.rawQuery(sql, null);
        rs.moveToFirst();
        User user = new User();
        user.setUserID(rs.getInt(rs.getColumnIndex(USERS_COLUMN_ID)));
        user.setUserName(rs.getString(rs.getColumnIndex(USERS_COLUMN_NAME)));
        user.setEmail(rs.getString(rs.getColumnIndex(USERS_COLUMN_EMAIL)));
        user.setPassword(rs.getString(rs.getColumnIndex(USERS_COLUMN_PASSWORD)));
        rs.moveToNext();
        rs.close();
        Log.v("Insert New User", "Completed!");
        db.close();
        return null;
    }
    public boolean insertNewUser(String name, String email, String pass) {
        try {
            ContentValues data = new ContentValues();
            data.put(USERS_COLUMN_NAME, name);
            data.put(USERS_COLUMN_EMAIL, email);
            data.put(USERS_COLUMN_PASSWORD, pass);

            db.insert(USERS_TABLE_NAME,null,data);
            Log.v("Insert New User", "Completed!");
            db.close();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    public User getUserByID(int userID) {
        String sql = "SELECT user_name,user_password,user_email FROM users WHERE user_id = " + userID;
        Cursor rs = null;
        rs = this.db.rawQuery(sql, null);
        rs.moveToFirst();
        User user = new User();

        while(rs.isAfterLast() == false) {
            user.setUserID(rs.getInt(rs.getColumnIndex(USERS_COLUMN_ID)));
            user.setUserName(rs.getString(rs.getColumnIndex(USERS_COLUMN_NAME)));
            user.setEmail(rs.getString(rs.getColumnIndex(USERS_COLUMN_EMAIL)));
            user.setPassword(rs.getString(rs.getColumnIndex(USERS_COLUMN_PASSWORD)));
            rs.moveToNext();
        }

        rs.close();
        db.close();
        return user;
    }

    public User getUserByName(String userName) {
        String sql = "SELECT user_id, user_name,user_password,user_email FROM users WHERE user_name = '" + userName + "'";
        Cursor rs = null;
        rs = this.db.rawQuery(sql, null);
        rs.moveToFirst();
        User user = new User();

        while(rs.isAfterLast() == false) {
            user.setUserID(rs.getInt(rs.getColumnIndex(USERS_COLUMN_ID)));
            user.setUserName(rs.getString(rs.getColumnIndex(USERS_COLUMN_NAME)));
            user.setEmail(rs.getString(rs.getColumnIndex(USERS_COLUMN_EMAIL)));
            user.setPassword(rs.getString(rs.getColumnIndex(USERS_COLUMN_PASSWORD)));
            rs.moveToNext();
        }

        rs.close();
        db.close();
        return user;
    }
}
