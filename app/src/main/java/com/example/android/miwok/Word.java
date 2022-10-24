package com.example.android.miwok;

public class Word {
    private String mDefaultTranslation;

    private String mMiwokTranslation;

    private int imageResourceID = 0;

    public Word(String mDefaultTranslation, String mMiwokTranslation, int imageResourceID) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.imageResourceID = imageResourceID;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
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

    public boolean hasImage() {
        if (getImageResourceID() == 0) {
            return false;
        } else {
            return true;
        }
    }
}
