package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class phrasesActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

     final ArrayList<Word> words = new ArrayList<Word>();


            words.add(new Word("Who?","چه کسی؟",R.raw.ph_who));
            words.add(new Word("I know","من می دانم. ",R.raw.ph_i_know));
//            words.add(new Word("Listen"," گوش کن.",R.raw.ph_listen));
            words.add(new Word("Really?","واقعا؟ ",R.raw.ph_really));
            words.add(new Word("Help me","کمکم کن. ",R.raw.ph_help_me));
//            words.add(new Word("See you?","به امید دیدار.",R.raw.s));
//            words.add(new Word("Welcome","خوش آمدید. ",R.raw.ph_welcome));
            words.add(new Word("Hurry up","عجله کن! ",R.raw.ph_hurry_up));
            words.add(new Word("Excuse me","ببخشید.",R.raw.ph_excuseme));
            words.add(new Word("I am sorry","من متاسفم.",R.raw.ph_im_sorry));
            words.add(new Word("How are you?","حال شما چطوره؟",R.raw.ph_how_are_u));
            words.add(new Word("What time is it?","ساعت چند است. ",R.raw.ph_what_time));
            words.add(new Word("I love chocolate","من شکلات دوست دارم.",R.raw.ph_ilike_choc));


    WordAdapter adapter =
            new WordAdapter(this, words,R.color.category_phrases);
    ListView listView = (ListView) findViewById(R.id.list);
                listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(phrasesActivity.this, word.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();
            }
        });
}
}
