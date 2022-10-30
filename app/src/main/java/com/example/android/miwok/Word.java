package com.example.android.miwok;

public class Word {
    private String mDefaultTranslation;

    private String mMiwokTranslation;

    private int imageResourceID = 0;

    private int audioResourceID;

    public Word(String mDefaultTranslation, String mMiwokTranslation, int imageResourceID, int audioResourceID) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.imageResourceID = imageResourceID;
        this.audioResourceID = audioResourceID;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation, int audioResourceID) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.audioResourceID = audioResourceID;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public int getAudioResourceID() {
        return audioResourceID;
    }

    public boolean hasImage() {
        if (getImageResourceID() == 0) {
            return false;
        } else {
            return true;
        }
    }
}
