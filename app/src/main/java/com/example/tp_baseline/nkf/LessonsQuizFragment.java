package com.example.tp_baseline.nkf;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import android.widget.*;

import java.util.ArrayList;

public class LessonsQuizFragment extends Fragment{

    LessonLibrary lessonLibrary;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        lessonLibrary = new LessonLibrary();

        final View v = inflater.inflate(R.layout.activity_lessons_quiz_fragment,container,false);

        ListView lv = (ListView) v.findViewById(R.id.listView_lessons);

        ArrayList<LessonVideo> listItems = new ArrayList<LessonVideo>();

        listItems.add(new LessonVideo("https://image.ibb.co/mz0z5b/1.png", "Lesson 1", "What is kidney ?"));
        listItems.add(new LessonVideo("https://image.ibb.co/gF8adw/2.png", "Lesson 2", "Why are kidneys important ?"));
        listItems.add(new LessonVideo("https://image.ibb.co/jqkMJw/3.png", "Lesson 3", "Chronic Kidney Disease"));
        listItems.add(new LessonVideo("https://image.ibb.co/fodadw/4.png", "Lesson 4", "How to prevent kidney failure ?"));


        ListLessonsAdapter adapter = new ListLessonsAdapter(
                v.getContext(),
                R.layout.activity_lesson_fragment,
                listItems
        );

        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://" + "8t-J6hJInZI"));
//                    startActivity(intent);

                System.out.println("Position : " + position);
                Log.i("Position", String.valueOf(position));
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                QuizFragment temp = new QuizFragment(lessonLibrary.getLesson(position));

                fragmentTransaction.replace(R.id.frame, temp).commit();
//                LessonVideo item = (LessonVideo) parent.getItemAtPosition(position);
//                Intent intent = new Intent(view.getContext(), LessonFragment.class);
//                startActivity(intent);
            }
        });


        return v;
    }



}

