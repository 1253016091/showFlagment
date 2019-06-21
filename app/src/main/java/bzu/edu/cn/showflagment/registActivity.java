package bzu.edu.cn.showflagment;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bzu.edu.cn.showflagment.dao.UsersDao;
import bzu.edu.cn.showflagment.entity.User;


public class registActivity extends ActionBarActivity {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private Button btn;
    private UsersDao usersDao=new UsersDao(this);
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        initView();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editText1.getText().toString();
                String userpass=editText2.getText().toString();
                String userpass2=editText3.getText().toString();
                if(userpass.equals(userpass2))
                {
                    user=new User(username,userpass);
                    usersDao.add(user);
                    Toast.makeText(registActivity.this, "注册成功！", Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(registActivity.this,"两次输入的密码不一致",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    private void initView() {
        editText1 = (EditText) findViewById(R.id.editview1);
        editText2 = (EditText) findViewById(R.id.editview2);
        editText3 = (EditText) findViewById(R.id.editview3);
        editText4 = (EditText) findViewById(R.id.editview4);
        btn = (Button) findViewById(R.id.tijiao);

    }
}
