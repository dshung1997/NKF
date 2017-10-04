package com.example.tp_baseline.nkf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by dshung on 02/10/2017.
 */

public class ListQuizsAdapter extends ArrayAdapter<Quiz> {

    Quiz[] items;

    public ListQuizsAdapter(Context context, int resource, Quiz[] items) {
        super(context, resource, items);
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.activity_single_quiz_fragment, null);
        }
        Quiz p = getItem(position);

        if (p != null) {

            TextView question = (TextView) view.findViewById(R.id.textView_quiz_question);

            RadioButton answer1 = (RadioButton) view.findViewById(R.id.radioButton_answer1);
            RadioButton answer2 = (RadioButton) view.findViewById(R.id.radioButton_answer2);
            RadioButton answer3 = (RadioButton) view.findViewById(R.id.radioButton_answer3);
            RadioButton answer4 = (RadioButton) view.findViewById(R.id.radioButton_answer4);

            question.setText("" + String.valueOf(position+1) + " : " + p.question);
            answer1.setText(p.answers[0]);
            answer2.setText(p.answers[1]);
            answer3.setText(p.answers[2]);
            answer4.setText(p.answers[3]);

        }
        return view;
    }

    @Override
    public Quiz getItem(int position)
    {
        return items[position];
    }
}

class Quiz {
    String question;
    String[] answers;
    String key;
    
    public Quiz(String _question, String[] _answer)
    {
        this.question = _question;
        this.answers = _answer;
    }

    public Quiz(String _question, String[] _answer, String _key)
    {
        this.question = _question;
        this.answers = _answer;
        this.key = _key;
    }
}
