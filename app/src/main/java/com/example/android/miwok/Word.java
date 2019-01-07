/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */
public class Word {

    /** Default translation for the word */
    private String mEnglishTranslation;
    private int mAudioResourceId;

    /** Miwok translation for the word */
    private String mFarsiTranslation;

    private int   mImageResourceId =NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED=-1;

    /**
     * Create a new Word object.
     *
     * @param englishTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param farsiTranslation is the word in the Miwok language
     *
     */
    public Word(String englishTranslation, String farsiTranslation, int audioResourceId) {
        mEnglishTranslation = englishTranslation;
        mFarsiTranslation = farsiTranslation;
        mAudioResourceId = audioResourceId;


    }
    public Word(String englishTranslation, String farsiTranslation,int imageResourceId,int audioResourceId) {
        mEnglishTranslation = englishTranslation;
        mFarsiTranslation = farsiTranslation;
        mImageResourceId=imageResourceId;
        mAudioResourceId = audioResourceId;

    }

    /**
     * Get the default translation of the word.
     */
    public String getEnglishTranslation() {
        return mEnglishTranslation;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getFarsiTranslation() {
        return mFarsiTranslation;
    }

    public int getImageResourceId () {
        return   mImageResourceId ;
    }

    public boolean hasImage(){
     return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}
