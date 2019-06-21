package bzu.edu.cn.showflagment.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bzu.edu.cn.showflagment.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class indexFragment extends Fragment {

    private Context context;

    public indexFragment(Context context) {
        this.context=context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_index, container, false);
        return view;
    }

}
