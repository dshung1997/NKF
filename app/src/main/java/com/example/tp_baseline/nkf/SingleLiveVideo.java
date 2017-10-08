package com.example.tp_baseline.nkf;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class SingleLiveVideo extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private String API_KEY = "AIzaSyCcu2YasxFGsyHNky3YfAyIxmahU9--8N4";
    private String VIDEO_ID;

    private ProgressDialog pDialog;
    private ListView lv;

    private String TAG = SingleLiveVideo.class.getSimpleName();

    ArrayList<Comment> commentList;

    private String url;
//    private String url;
//    public SingleLiveVideo(String _url)
//    {
//        url = _url;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_live_video);

        commentList = new ArrayList<Comment>();
        VIDEO_ID = "gAwEzW37RvY";
        url = "https://www.googleapis.com/youtube/v3/commentThreads?part=snippet&videoId="+"J_ub7Etch2U"+"&key=AIzaSyAgZmlXrAJT0k5KLxkRF8IWCdrdC4KRxlc";


        lv = (ListView) findViewById(R.id.listView_comments);
        YouTubePlayerView youtubePlayerView = (YouTubePlayerView) findViewById(R.id.livevideo);


        new GetComments().execute();



        youtubePlayerView.initialize(API_KEY, this);
        //System.out.println(youtubePlayerView.getWidth() +".... "+ youtubePlayerView.getHeight());
        //if(youtubePlayerView == null) System.out.println("nulllllllllllllllllllllll");
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        youTubePlayer.setPlaybackEventListener(playbackEventListener);
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);

        if (!wasRestored) {
            youTubePlayer.cueVideo(VIDEO_ID); // Plays https://www.youtube.com/watch?v=REyxoxScrbU
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




    private class GetComments extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(SingleLiveVideo.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray contacts = jsonObj.getJSONArray("items");

                    int n = contacts.length() < 10 ? contacts.length() : 10;
                    // looping through All Contacts
                    for (int i = 0; i < n; i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        String urlImageUser = c.getJSONObject("snippet").getJSONObject("topLevelComment").getJSONObject("snippet").getString("authorProfileImageUrl");
                        String textDisplay = c.getJSONObject("snippet").getJSONObject("topLevelComment").getJSONObject("snippet").getString("textDisplay");
                        String userName = c.getJSONObject("snippet").getJSONObject("topLevelComment").getJSONObject("snippet").getString("authorDisplayName");

                        commentList.add(new Comment(urlImageUser, userName, textDisplay));


                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListCommentAdapter adapter = new ListCommentAdapter(
                    SingleLiveVideo.this,
                    R.layout.single_comment,
                    commentList);

            lv.setAdapter(adapter);
        }

    }
}

