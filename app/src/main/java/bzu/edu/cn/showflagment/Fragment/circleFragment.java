package bzu.edu.cn.showflagment.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import bzu.edu.cn.showflagment.R;
import bzu.edu.cn.showflagment.adapter.circleAdapter;
import bzu.edu.cn.showflagment.entity.Circle;
import bzu.edu.cn.showflagment.json.JsonParse;

public class circleFragment extends Fragment {
    private Circle Circle;
    private Context context;
    private LinearLayout lodding;
    private List<Circle> circleList;
    private ListView listView;
    public circleFragment(Context context) {
        this.context=context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_circle, container, false);
        listView= (ListView) view.findViewById(R.id.lv_cirle);
        fillData();
        return view;
    }

    private void fillData() {
        InputStream is=this.getResources().openRawResource(R.raw.weixin);

        try {
            circleList= JsonParse.getNewsInfo(is);
            circleAdapter adapter=new circleAdapter(context,R.layout.cricle_item,circleList);
            listView.setAdapter(adapter);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
