package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        final ArrayList<Word> words = new ArrayList<Word>();


        words.add(new Word("one", "یک", R.drawable.number_one,R.raw.one));
        words.add(new Word("two", "دو", R.drawable.number_two,R.raw.two));
        words.add(new Word("three", " سه", R.drawable.number_three,R.raw.three));
        words.add(new Word("four", "چهار", R.drawable.number_four,R.raw.four));
        words.add(new Word("five", "پنج", R.drawable.number_five,R.raw.five));
        words.add(new Word("sex", "شش", R.drawable.number_six,R.raw.six));
        words.add(new Word("seven", "هفت", R.drawable.number_seven,R.raw.seven));
        words.add(new Word("eight", "هشت", R.drawable.number_eight,R.raw.eight));
        words.add(new Word("nine", "نه", R.drawable.number_nine,R.raw.nine));
        words.add(new Word("ten", "ده", R.drawable.number_ten,R.raw.ten));


        WordAdapter adapter =
                new WordAdapter(this, words, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();
            }
        });
    }
}

