package bzu.edu.cn.showflagment.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

import bzu.edu.cn.showflagment.entity.Circle;

/**
 * Created by admin on 2019/6/19.
 */
public class JsonParse {
    public static List<Circle> getNewsInfo(InputStream is) throws IOException {
        byte[] buffer=new byte[is.available()];
        is.read(buffer);
        String json=new String(buffer,"utf-8");
        Gson gson=new Gson();
        Type listType =new TypeToken<List<Circle>>(){}.getType();
        List<Circle> newsInfos=gson.fromJson(json,listType);
        return newsInfos;
    }
}
