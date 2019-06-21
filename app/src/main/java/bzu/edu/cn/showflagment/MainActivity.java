package bzu.edu.cn.showflagment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import bzu.edu.cn.showflagment.Fragment.circleFragment;
import bzu.edu.cn.showflagment.Fragment.friendsFragment;
import bzu.edu.cn.showflagment.Fragment.indexFragment;
import bzu.edu.cn.showflagment.Fragment.myFragment;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private List<Fragment> fragments = new ArrayList<Fragment>();
    private ViewPager viewPager;
    private LinearLayout llMy, llCircle, llFriends, llSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }
    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        llMy = (LinearLayout) findViewById(R.id.llMy);
        llCircle = (LinearLayout) findViewById(R.id.llCircle);
        llFriends = (LinearLayout) findViewById(R.id.llFriends);
        llSettings = (LinearLayout) findViewById(R.id.llsettings);

        llMy.setOnClickListener(this);
        llFriends.setOnClickListener(this);
        llCircle.setOnClickListener(this);
        llSettings.setOnClickListener(this);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                changeTab(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
        viewPager.setOffscreenPageLimit(2); //设置向左和向右都缓存limit个页面

    }
    private  void initData() {
        fragments.add(new indexFragment(this));
        fragments.add(new friendsFragment(MainActivity.this));
        fragments.add(new circleFragment(MainActivity.this));
        fragments.add(new myFragment(MainActivity.this));
        FragmentManager fragmentManager=getSupportFragmentManager();
        MyFragmentPagerAdapter adapter=new MyFragmentPagerAdapter(fragmentManager);
        viewPager.setAdapter(adapter);
    }
    @Override
    public void onClick(View v) {
        changeTab(v.getId());
    }
    private void changeTab(int id) {
        switch (id) {
            case R.id.llsettings:
                viewPager.setCurrentItem(0);
                break;
            case R.id.llFriends:
                viewPager.setCurrentItem(1);
                break;
            case R.id.llCircle:
                viewPager.setCurrentItem(2);
                break;
            case R.id.llMy:
                viewPager.setCurrentItem(3);
                break;
            default:
                break;
        }
    }

    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

}
