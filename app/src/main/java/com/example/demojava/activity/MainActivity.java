package com.example.demojava.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demojava.R;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    void initViews(){
        Button button = findViewById(R.id.b_click);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRecyclerActivity();
            }
        });

    }
    void openRecyclerActivity(){
        Intent intent = new Intent(this, RecyclerActivity.class);
        startActivity(intent);
    }
}