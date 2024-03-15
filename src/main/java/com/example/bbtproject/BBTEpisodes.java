package com.example.bbtproject;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BBTEpisodes implements Parcelable {
    private String name;
    private String descript;
    private int image;
    private int number;

    int progress;

    public BBTEpisodes(String name, int number, String description, int image){
        this.name = name;
        this.number = number;
        this.descript = description;
        this.image = image;
        progress = 0;
    }

    protected BBTEpisodes(Parcel in) {
        name = in.readString();
        descript = in.readString();
        image = in.readInt();
        number = in.readInt();
    }

    public static final Creator<BBTEpisodes> CREATOR = new Creator<BBTEpisodes>() {
        @Override
        public BBTEpisodes createFromParcel(Parcel in) {
            return new BBTEpisodes(in);
        }

        @Override
        public BBTEpisodes[] newArray(int size) {
            return new BBTEpisodes[size];
        }
    };

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getName() {
        return name;
    }
    public int getNumber() {
        return number;
    }
    public String getDescript() {
        return descript;
    }
    public int getimage() {
        return image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(descript);
        dest.writeInt(image);
        dest.writeInt(number);
    }
}