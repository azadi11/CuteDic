package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();



        words.add(new Word("green","سبز",R.drawable.color_green,R.raw.green));
        words.add(new Word("white","سفید",R.drawable.color_white,R.raw.color_white));
        words.add(new Word("black","سیاه",R.drawable.color_black,R.raw.color_black));
        words.add(new Word("red","قرمز",R.drawable.color_red,R.raw.red));
        words.add(new Word("yellow","زرد",R.drawable.color_mustard_yellow,R.raw.yellow));
        words.add(new Word("grey","خاکستری",R.drawable.color_gray,R.raw.grey));
        words.add(new Word("orange","قهوه\u200Cای",R.drawable.color_brown,R.raw.color_brown));
//        words.add(new Word("blue","آبی",R.drawable.circle_blue,R.raw.color_blue));


        WordAdapter adapter =
                new WordAdapter(this, words,R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();
            }
        });
    }
}