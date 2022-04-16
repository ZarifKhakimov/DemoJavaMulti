package com.example.demojava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.demojava.model.Cast;

public class MainActivity extends AppCompatActivity {
    static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    void initViews(){
        Button b_detail = findViewById(R.id.b_detail);
        b_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cast cast = new Cast(14,"Zarifjon");
                passObject(cast);

                Log.d(TAG, cast.toString());
            }
        });
    }

    void passObject(Cast cast){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("cast", (Parcelable) cast);
        startActivity(intent);
    }
}
