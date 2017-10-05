package com.example.tp_baseline.nkf;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class LivestreamFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.activity_livestream_fragment,container,false);

        ListView lv = (ListView) v.findViewById(R.id.listView_livevideos);

        ArrayList<LiveVideo> listItems = new ArrayList<LiveVideo>();

        listItems.add(new LiveVideo("https://i.imgur.com/m0QFAC5.png", "Live Video 1", "What is kidney ?", ""));
        listItems.add(new LiveVideo("https://i.imgur.com/Whd5GY7.png", "Live Video 2", "Why are kidneys important ?", ""));
        listItems.add(new LiveVideo("https://i.imgur.com/GFDopUM.png", "Live Video 3", "Chronic Kidney Disease", ""));

        ListLiveVideoAdapter adapter = new ListLiveVideoAdapter(
                v.getContext(),
                R.layout.single_livestream_video,
                listItems
        );

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(view.getContext(), SingleLiveVideo.class);
                startActivity(intent);

//                System.out.println("Position : " + position);
//                Log.i("Position", String.valueOf(position));
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                QuizFragment temp = new QuizFragment(lessonLibrary.getLesson(position));
//
//                fragmentTransaction.replace(R.id.frame, temp).commit();
//                LessonVideo item = (LessonVideo) parent.getItemAtPosition(position);
//                Intent intent = new Intent(view.getContext(), LessonFragment.class);
//                startActivity(intent);
            }
        });

        return v;
    }

}
