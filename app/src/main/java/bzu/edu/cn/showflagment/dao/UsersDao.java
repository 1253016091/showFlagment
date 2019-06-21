package bzu.edu.cn.showflagment.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import bzu.edu.cn.showflagment.db.DBHelper;
import bzu.edu.cn.showflagment.entity.User;

/**
 * Created by admin on 2019/6/17.
 */
public class UsersDao{
    private DBHelper dbHelper;
    private Context context;
    private User user=null;
    public UsersDao(Context context) {
        dbHelper=new DBHelper(context,2);
        this.context=context;
    }
    public  void add(User user){
        SQLiteDatabase sq = dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("username",user.getUsername());
        values.put("userpass",user.getUserpass());
        //values.put("usericon",user.getUsericon());
        long id=sq.insert("users",null,values);
        user.setId(id);
        sq.close();
    }
    public User query(String username1,String userpass1){
        final String username=username1;
        SQLiteDatabase sq = dbHelper.getWritableDatabase();
        Cursor cursor=sq.query("users", new String[]{"username", "userpass"}, "username=?", new String[]{(username)}, null, null, null);
        int flag=0;
        while(cursor.moveToNext())
        {
            flag=1;
            final String userpass=cursor.getString(cursor.getColumnIndex("userpass"));
            if(userpass.equals(userpass1))
            {
                user=new User(username,userpass);
                break;
            }
            else
            {
                Toast.makeText(context, "用户名密码不正确", Toast.LENGTH_LONG).show();
                break;
            }
        }
        if(flag==0)
        {
            Toast.makeText(context, "用户名不存在", Toast.LENGTH_LONG).show();
        }
        return user;
    }

}
