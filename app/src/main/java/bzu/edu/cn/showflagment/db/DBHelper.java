package bzu.edu.cn.showflagment.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin on 2019/6/17.
 */
public class DBHelper extends SQLiteOpenHelper {
    public  static  final String CREATE_USERS="create table users(id Integer primary key autoincrement,username varchar(20),userpass varchar(20),usericon integer)";
    public  static  final String CREATE_FRIENDS="create table friends(id Integer primary key autoincrement,friendsname varchar(20),text varchar(20))";

    public DBHelper(Context context, int version) {
        super(context, "Users.db", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USERS);
        sqLiteDatabase.execSQL(CREATE_FRIENDS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists users");
        sqLiteDatabase.execSQL("drop table if exists friends");
        onCreate(sqLiteDatabase);
    }
}
