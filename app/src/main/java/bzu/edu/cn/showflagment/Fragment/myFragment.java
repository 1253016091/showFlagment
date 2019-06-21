package bzu.edu.cn.showflagment.Fragment;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import bzu.edu.cn.showflagment.R;
import bzu.edu.cn.showflagment.dao.FriendsDao;
import bzu.edu.cn.showflagment.entity.Friends;
import bzu.edu.cn.showflagment.entity.User;
import bzu.edu.cn.showflagment.loginActivity;

@SuppressLint("ValidFragment")//忽略警告
public class myFragment extends Fragment {
    private User user;
    private Context context;
    private TextView user_name;
    private EditText number;
    private Button add;
    private Friends friends;
    //private Friends friends;
    private FriendsDao friendsDao=null;
    public myFragment(Context context) {
        this.context=context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_my, container, false);
        user_name = (TextView) view.findViewById(R.id.user_name);
        number = (EditText) view.findViewById(R.id.et_number);
        add = (Button) view.findViewById(R.id.btn_add);
        user_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user==null)
                {
                    Intent intent = new Intent(context, loginActivity.class);
                    startActivityForResult(intent, 1);
                }else
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("您已登陆，需要退出登录吗?");
                    builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            user=null;
                            user_name.setText("登录");
                        }
                    });
                    builder.setNegativeButton("cancel", null);
                    builder.show();
                }

            }
        });
        friendsDao=new FriendsDao(context);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String s=number.getText().toString();
                if(s!=null)
                {
                    friends=friendsDao.add(s);
                    Toast.makeText(context,"添加好友成功",Toast.LENGTH_SHORT).show();
                    number.setText("");
                }
            }
        });
        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data!=null)
        {
            if(resultCode==1)
            {
                if(requestCode==1)
                {
                    user = (User) data.getSerializableExtra("user");
                    user_name.setText(user.getUsername()+"");
                }
            }
        }
    }

}
