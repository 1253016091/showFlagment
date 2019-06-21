package bzu.edu.cn.showflagment.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import bzu.edu.cn.showflagment.db.DBHelper;
import bzu.edu.cn.showflagment.entity.Friends;

/**
 * Created by admin on 2019/6/18.
 */
public class FriendsDao {

    private DBHelper dbHelper;
    private Friends friends=new Friends();
    private Context context=null;
    public FriendsDao(Context context) {
        dbHelper=new DBHelper(context,2);
        this.context=context;
    }
    public Friends add(String s){
        SQLiteDatabase sq = dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("friendsname", s);

        long id=sq.insert("friends", null, values);
        friends.setFriendName(s);
        friends.setId(id);
        sq.close();
        return friends;
    }

    public int delete(long id)
    {
        SQLiteDatabase sq = dbHelper.getWritableDatabase();
        int count=sq.delete("friends", "id=?", new String[]{id+ ""});
        sq.close();
        return count;
    }
    public List<Friends> query() {
        List<Friends> list = new ArrayList<>();
        SQLiteDatabase sq = dbHelper.getWritableDatabase();
        Cursor cursor = sq.query("friends", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String Name = cursor.getString(cursor.getColumnIndex("friendsname"));
                long id=cursor.getLong(cursor.getColumnIndex("id"));
                //String text=cursor.getString(cursor.getColumnIndex("text"));
                Friends friends = new Friends(id,Name);
                list.add(friends);
            } while (cursor.moveToNext());
        }
        return list;
    }

}
