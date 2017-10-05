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
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class QuizFragment3 extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private Lesson lesson;

    public static int _score2;

//    public QuizFragment2(Lesson _lesson)
//    {
//        this.lesson = _lesson;
//        _score2 = 0;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_fragment3);

        LessonLibrary lessonLibrary = new LessonLibrary();
        lesson = lessonLibrary.getCurrentLesson();


        ListView listViewQuiz = (ListView) findViewById(R.id.listView_quizs2);




        ListQuizsAdapter adapter = new ListQuizsAdapter(
                QuizFragment3.this,
                R.layout.activity_single_quiz_fragment,
                lesson.quizs
        );

        //View header = getLayoutInflater(savedInstanceState).inflate(R.layout.activity_lesson_quiz_header, null);

        YouTubePlayerView youTubePlayer = (YouTubePlayerView) findViewById(R.id.livevideo2) ;
        if(youTubePlayer == null) System.out.println("quiz 3 nulllllllllllllllllllllllllllllllllll");
        youTubePlayer.initialize("AIzaSyCcu2YasxFGsyHNky3YfAyIxmahU9--8N4", this);

        TextView textViewTitle = (TextView) findViewById(R.id.textView_lesson_title2);
        TextView textViewDescription = (TextView) findViewById(R.id.textView_lesson_description2);

        textViewTitle.setText(lesson.title);
        textViewDescription.setText(lesson.description);

//        imageViewImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://" + lesson.urlVideo));
//                startActivity(intent);
//            }
//        });

        //listViewQuiz.addHeaderView(header);

        View footer = getLayoutInflater().inflate(R.layout.activity_lesson_quiz_footer, null);
        listViewQuiz.addFooterView(footer);


        listViewQuiz.setAdapter(adapter);
    }

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

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        youTubePlayer.setPlaybackEventListener(playbackEventListener);
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);

        if (!wasRestored) {
            youTubePlayer.cueVideo(lesson.urlVideo); // Plays https://www.youtube.com/watch?v=REyxoxScrbU
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Failed ...", Toast.LENGTH_SHORT).show();
    }

    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };
    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };


}