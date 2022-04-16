package com.example.demojava;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demojava.model.Cast;
import com.google.firebase.firestore.auth.User;

public class DetailActivity extends AppCompatActivity {
    static final String TAG = DetailActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initViews();
    }
    void initViews(){
        TextView tv_detail = findViewById(R.id.tv_detail);


        Cast cast = (Cast)getIntent().getParcelableExtra("cast");
        Log.d(TAG, cast.toString());

        tv_detail.setText(cast.toString());


    }
}