package com.example.tp_baseline.nkf;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class QuizFragment extends Fragment {

    private Lesson lesson;

    public static int _score2;

    public QuizFragment(Lesson _lesson)
    {
        this.lesson = _lesson;
        _score2 = 0;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.activity_quiz_fragment,container,false);

        ListView listViewQuiz = (ListView) v.findViewById(R.id.listView_quizs);




        ListQuizsAdapter adapter = new ListQuizsAdapter(
                v.getContext(),
                R.layout.activity_single_quiz_fragment,
                lesson.quizs
        );

        //View header = getLayoutInflater(savedInstanceState).inflate(R.layout.activity_lesson_quiz_header, null);

        TextView textViewTitle = (TextView) v.findViewById(R.id.textView_lesson_title);
        ImageButton imageViewImage = (ImageButton) v.findViewById(R.id.imageView_lesson_image);
        TextView textViewDescription = (TextView) v.findViewById(R.id.textView_lesson_description);
        textViewTitle.setText(lesson.title);
        Glide.with(v).load(lesson.urlImage).into(imageViewImage);
        textViewDescription.setText(lesson.description);

        imageViewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://" + lesson.urlVideo));
                    startActivity(intent);
            }
        });

        //listViewQuiz.addHeaderView(header);

        View footer = getLayoutInflater(savedInstanceState).inflate(R.layout.activity_lesson_quiz_footer, null);
        listViewQuiz.addFooterView(footer);


        listViewQuiz.setAdapter(adapter);


//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                System.out.println("............" + position);
//                RadioButton rb1 = (RadioButton) view.findViewById(R.id.radioButton_answer1);
//                RadioButton rb2 = (RadioButton) view.findViewById(R.id.radioButton_answer2);
//                RadioButton rb3 = (RadioButton) view.findViewById(R.id.radioButton_answer3);
//                RadioButton rb4 = (RadioButton) view.findViewById(R.id.radioButton_answer4);
//
//                int c = 0;
//                if(rb1.isChecked())
//                {
//                    if(key[position] == 1) _score2 += 1;
//                    c = 1;
//                }
//                else if(rb2.isChecked())
//                {
//                    if(key[position] == 2) _score2 += 1;
//                    c = 2;
//                }
//                else if(rb3.isChecked())
//                {
//                    if(key[position] == 3) _score2 += 1;
//                    c = 3;
//                }
//                else if(rb4.isChecked())
//                {
//                    if(key[position] == 4) _score2 += 1;
//                    c = 4;
//                }
//
//            }
//        });

//        Button submitButton = (Button) v.findViewById(R.id.button_quiz_submit);
//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View _view) {
//                ListView lv1 = (ListView) v.findViewById(R.id.listView_quizs);
//                int score = checkSubmisson(v);
//                Toast.makeText(v.getContext(), String.valueOf(score), Toast.LENGTH_SHORT).show();
//            }
//        });

        return v;
    }

//    int checkSubmisson(View v)
//    {
//        int score = 0;
//        ListView listQuiz = (ListView) v.findViewById(R.id.listView_quizs);
//        for(int i = 0; i <=  listQuiz.getChildCount(); i++)
//        {
//            View child = getViewByPosition(i, listQuiz);
//            RadioButton rb1 = (RadioButton) child.findViewById(R.id.radioButton_answer1);
//            RadioButton rb2 = (RadioButton) child.findViewById(R.id.radioButton_answer2);
//            RadioButton rb3 = (RadioButton) child.findViewById(R.id.radioButton_answer3);
//            RadioButton rb4 = (RadioButton) child.findViewById(R.id.radioButton_answer4);
//
//            int c = 0;
//            if(rb1.isChecked())
//            {
//                if(key[i] == 1) score += 1;
//                c = 1;
//            }
//            else if(rb2.isChecked())
//            {
//                if(key[i] == 2) score += 1;
//                c = 2;
//            }
//            else if(rb3.isChecked())
//            {
//                if(key[i] == 3) score += 1;
//                c = 3;
//            }
//            else if(rb4.isChecked())
//            {
//                if(key[i] == 4) score += 1;
//                c = 4;
//            }
//
//            System.out.printf("-------------%d %d %d\n", i, c, key[i]);
//
//        }
//
//        return score;
//    }

    public View getViewByPosition(int pos, ListView listView) {
        final int firstListItemPosition = listView.getFirstVisiblePosition();
        final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;

//        if (pos < firstListItemPosition || pos > lastListItemPosition ) {
//            return listView.getAdapter().getView(pos, null, listView);
//        } else {
//            final int childIndex = pos - firstListItemPosition;
//            return listView.getChildAt(childIndex);
//        }
        if (pos < firstListItemPosition || pos > lastListItemPosition ) {
            return listView.getAdapter().getView(pos, listView.getChildAt(pos), listView);
        } else {
            final int childIndex = pos - firstListItemPosition;
            return listView.getChildAt(childIndex);
        }
    }


}