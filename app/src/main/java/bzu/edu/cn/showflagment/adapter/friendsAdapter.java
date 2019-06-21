package bzu.edu.cn.showflagment.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import bzu.edu.cn.showflagment.R;
import bzu.edu.cn.showflagment.dao.FriendsDao;
import bzu.edu.cn.showflagment.entity.Friends;


/**
 * Created by admin on 2019/6/18.
 */
public class friendsAdapter extends ArrayAdapter<Friends> {
    int ResourceId;
    FriendsDao friendsDao;
    List<Friends> friendsList;
    public friendsAdapter(Context context, int resource, List<Friends> objects,FriendsDao friendsDao) {
        super(context, resource,objects);
        ResourceId=resource;
        this.friendsDao=friendsDao;
        this.friendsList=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Friends friends=getItem(position);

        View view=null;
        ViewHoder viewHoder;
        if(convertView==null)
        {
            view = LayoutInflater.from(getContext()).inflate(ResourceId,null);
            viewHoder=new ViewHoder();
            viewHoder.ivimage= (ImageView) view.findViewById(R.id.iv_image);
            viewHoder.ivdelete= (ImageView) view.findViewById(R.id.iv_delete);
            viewHoder.tvname= (TextView) view.findViewById(R.id.tv_name);
            view.setTag(viewHoder);
        }else
        {
            view=convertView;
            viewHoder= (ViewHoder) view.getTag();
        }
        viewHoder.tvname.setText( friends.getFriendName());
        viewHoder.ivdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("你确定要删除吗?");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int count =friendsDao.delete(friends.getId());
                        Toast.makeText(getContext(),"删除成功",Toast.LENGTH_SHORT).show();
                        friendsList.remove(friends);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("cancel", null);
                builder.show();
            }
        });
        return view;
    }
    class ViewHoder{
        ImageView ivimage;
        TextView tvname;
        ImageView ivdelete;
    }
}
