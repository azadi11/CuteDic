package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();


        words.add(new Word("mother","مادر",R.drawable.family_mother,R.raw.mother));
//        words.add(new Word("dad","پدر",R.drawable.family_father,R.raw.));
        words.add(new Word("sister"," خواهر",R.drawable.family_daughter,R.raw.sister));
        words.add(new Word("brother","برادر",R.drawable.family_son,R.raw.brother));
        words.add(new Word("aunt","خاله",R.drawable.family_older_sister,R.raw.ph_ant));
        words.add(new Word("aunt","عمه",R.drawable.family_older_sister,R.raw.ph_ant));
        words.add(new Word("uncle","دایی",R.drawable.family_older_brother,R.raw.ph_ankle));
        words.add(new Word("uncle","عمو",R.drawable.family_older_brother,R.raw.ph_ankle));
        words.add(new Word("niece","دختر برادر",R.drawable.family_younger_sister,R.raw.ph_niece));
        words.add(new Word("niece","دختر خواهر",R.drawable.family_younger_sister,R.raw.ph_niece));
        words.add(new Word("nephew","پسر برادر",R.drawable.family_younger_brother,R.raw.ph_nephew));
        words.add(new Word("nephew","پسر خواهر",R.drawable.family_younger_brother,R.raw.ph_nephew));
        words.add(new Word("grandmother","مادربزرگ",R.drawable.family_grandmother,R.raw.family_grandmother));
        words.add(new Word("grandfather","پدربزرگ",R.drawable.family_grandfather,R.raw.family_grandfather));
        words.add(new Word("wife","زن",R.drawable.family_mother,R.raw.wife));
        words.add(new Word("husbend","شوهر",R.drawable.family_father,R.raw.husbend));
        words.add(new Word("cousin","پسردایی",R.drawable.family_younger_brother,R.raw.ph_cousin));
        words.add(new Word("cousin","دختردایی",R.drawable.family_younger_sister,R.raw.ph_cousin));
        words.add(new Word("cousin","پسرخاله",R.drawable.family_younger_brother,R.raw.ph_cousin));
        words.add(new Word("cousin","دخترخاله",R.drawable.family_younger_sister,R.raw.ph_cousin));


        WordAdapter adapter =
                new WordAdapter(this, words,R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();
            }
        });
    }

}
