package bzu.edu.cn.showflagment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

import java.util.Map;

import bzu.edu.cn.showflagment.dao.UsersDao;
import bzu.edu.cn.showflagment.entity.User;

public class loginActivity extends ActionBarActivity{

    private EditText username;
    private EditText userpass;
    private UsersDao usersDao=new UsersDao(this);
    private Map<String,String> mp=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        username = (EditText) findViewById(R.id.et_name);
        userpass = (EditText) findViewById(R.id.et_password);
    }

    public void loginSuccessed(View view) {
        String user_name=username.getText().toString();
        String user_pass=userpass.getText().toString();
        User s=usersDao.query(user_name, user_pass);
        if(s!=null)
        {
            Intent a=new Intent();
            a.putExtra("user", s);
            setResult(1,a);
            finish();
        }
    }

    public void regist(View view) {
        Intent intent =new Intent(this,registActivity.class);
        startActivity(intent);
    }
}
