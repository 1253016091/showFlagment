package bzu.edu.cn.showflagment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.loopj.android.image.SmartImageView;

import java.util.List;

import bzu.edu.cn.showflagment.R;
import bzu.edu.cn.showflagment.entity.Circle;

public class circleAdapter extends ArrayAdapter<Circle> {
    int ResourceId;
    List<Circle> circleList;
    private Context context;
    public circleAdapter(Context context, int resource, List<Circle> objects) {
        super(context, resource,objects);
        ResourceId=resource;
        this.context=context;
        this.circleList=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Circle circle=getItem(position);
        View view=null;
        ViewHoder viewHoder;
        if(convertView==null)
        {
            view = LayoutInflater.from(getContext()).inflate(ResourceId,null);
            viewHoder=new ViewHoder();
            viewHoder.title = (TextView) view.findViewById(R.id.tv_title);
            viewHoder.description = (TextView) view.findViewById(R.id.tv_description);
            viewHoder.comment = (TextView) view.findViewById(R.id.tv_comment);
            viewHoder.icon = (SmartImageView) view.findViewById(R.id.siv_icon);

            view.setTag(viewHoder);
        }else
        {
            view=convertView;
            viewHoder= (ViewHoder) view.getTag();
        }
        viewHoder.title.setText(circle.getTitle()+"");
        viewHoder.description.setText(circle.getContent() + "");
        viewHoder.comment.setText("评论:" + circle.getComment() + "");
        return view;
    }

    class ViewHoder{
        SmartImageView icon;
        TextView description;
        TextView title;
        TextView comment;
    }

}
