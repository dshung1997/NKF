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
 * Created by dshung on 05/10/2017.
 */

public class ListLiveVideoAdapter extends ArrayAdapter<LiveVideo> {

    List<LiveVideo> items;

    public ListLiveVideoAdapter(Context context, int resource, List<LiveVideo> items) {
        super(context, resource, items);
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.single_livestream_video, null);
        }
        LiveVideo p = getItem(position);

        if (p != null) {

            ImageView thumbnail = (ImageView) view.findViewById(R.id.imageView_livevideo_thumbnail);
            TextView title_number = (TextView) view.findViewById(R.id.textView_livevideo_title_number);
            TextView title_text = (TextView) view.findViewById(R.id.textView_livevideo_title_text);

            Glide.with(view).load(p.urlImage).into(thumbnail);

            title_number.setText(p.title_number);
            title_text.setText(p.title_text);
        }
        return view;
    }

    @Override
    public LiveVideo getItem(int position)
    {
        return items.get(position);
    }
}
class LiveVideo
{
    String urlImage;
    String title_number;
    String title_text;
    String urlVideo;

    public LiveVideo(String _urlImage, String _title_number, String _title_text, String _urlVideo)
    {
        urlImage = _urlImage;
        title_number = _title_number;
        title_text = _title_text;
        urlVideo = _urlVideo;
    }
}

