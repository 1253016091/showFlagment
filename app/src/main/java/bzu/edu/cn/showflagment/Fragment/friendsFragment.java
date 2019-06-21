package bzu.edu.cn.showflagment.Fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

import bzu.edu.cn.showflagment.R;
import bzu.edu.cn.showflagment.adapter.friendsAdapter;
import bzu.edu.cn.showflagment.dao.FriendsDao;
import bzu.edu.cn.showflagment.entity.Friends;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")//忽略警告
public class friendsFragment extends Fragment {

    private List<Friends> friendsList;;
    private Context context;
    private bzu.edu.cn.showflagment.adapter.friendsAdapter friendsAdapter;
    private FriendsDao friendsDao;
    private ImageView shuxin;
    private ListView listView;

    public friendsFragment(Context context) {
        this.context=context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friends, container, false);
        shuxin= (ImageView) view.findViewById(R.id.shuaxin);
        friendsDao = new FriendsDao(context);
        listView = (ListView) view.findViewById(R.id.lv_friends);
        friendsList= friendsDao.query();
        friendsAdapter =new friendsAdapter(context,R.layout.item,friendsList, friendsDao);
        listView.setAdapter(friendsAdapter);
        shuxin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                friendsList = friendsDao.query();
                friendsAdapter =new friendsAdapter(context,R.layout.item,friendsList, friendsDao);
                listView.setAdapter(friendsAdapter);
            }
        });
        return view;
    }

}
