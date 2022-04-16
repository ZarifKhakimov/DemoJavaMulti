package com.example.demojava.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.demojava.MainActivity;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Cast  implements Parcelable {

    private int age;
    private String name;

    public Cast(int age, String name){
        this.age= age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cast " +
                "age=" + age +
                ", name='" + name + '\'' ;
    }

    protected Cast(Parcel in) {
        age = in.readInt();
        name = in.readString().toString();
    }

    public static final Creator<Cast> CREATOR = new Creator<Cast>() {
        @Override
        public Cast createFromParcel(Parcel in) {
            return new Cast(in);
        }

        @Override
        public Cast[] newArray(int size) {
            return new Cast[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(age);
        parcel.writeString(name);
    }
}