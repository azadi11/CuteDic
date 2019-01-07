package com.example.android.miwok;

import android.content.Context;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;



public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;
    public WordAdapter(Context context, ArrayList<Word> words,int ColorResourceId) {
        super(context, 0, words);
        mColorResourceId =ColorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        Word currentWord = getItem(position);


        TextView englishTextView = (TextView) listItemView.findViewById(R.id.englisg_text_view);
        englishTextView.setText(currentWord.getEnglishTranslation());

        TextView farsiTextView = (TextView) listItemView.findViewById(R.id.farsi_text_view);
        farsiTextView.setText(currentWord.getFarsiTranslation());


        ImageView imageView = (ImageView) listItemView.findViewById(R.id.myImage);
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }
        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);
            return listItemView;

    }
}
