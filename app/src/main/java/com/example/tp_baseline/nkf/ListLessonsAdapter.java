package com.example.tp_baseline.nkf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by dshung on 01/10/2017.
 */

public class ListLessonsAdapter extends ArrayAdapter<LessonVideo> {

    List<LessonVideo> items;

    public ListLessonsAdapter(Context context, int resource, List<LessonVideo> items) {
        super(context, resource, items);
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.activity_lesson_fragment, null);
        }
        LessonVideo p = getItem(position);

        if (p != null) {

            ImageView thumbnail = (ImageView) view.findViewById(R.id.imageView_lesson_thumbnail);
            TextView title_number = (TextView) view.findViewById(R.id.textView_lesson_title_number);
            TextView title_text = (TextView) view.findViewById(R.id.textView_lesson_title_text);

            Glide.with(view).load(p.urlImage).into(thumbnail);
            //thumbnail.setImageResource(p.idImage);

//            if(thumbnail.getDrawable() != null) System.out.println("Noooooooooooooooooooo");
//            else System.out.println("Nullllllllllllllllllll");

            title_number.setText(p.title_number);
            title_text.setText(p.title_text);
        }
        return view;
    }

    @Override
    public LessonVideo getItem(int position)
    {
        return items.get(position);
    }
}


class LessonVideo
{
    String urlImage;
    String title_number;
    String title_text;

    public LessonVideo(String _urlImage, String _title_number, String _title_text)
    {
        urlImage = _urlImage;
        title_number = _title_number;
        title_text = _title_text;
    }


    public static String getURL(String _url)
    {
        String newUrl = "http://img.youtube.com/vi/"+_url+"/mqdefault.jpg";
        return newUrl;
    }
}

