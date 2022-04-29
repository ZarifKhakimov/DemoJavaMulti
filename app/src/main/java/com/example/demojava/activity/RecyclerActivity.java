package com.example.demojava.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.demojava.R;
import com.example.demojava.adapter.RecyclerAdapter;
import com.example.demojava.model.Member;
import com.example.demojava.model.MemberSub;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler);
        initViews();

       List<Member> members = prepareMemberList();
       refreshAdapter(members);
    }
    void initViews(){
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
    }

    private void refreshAdapter(List<Member> members){
        RecyclerAdapter adapter = new RecyclerAdapter(context, members);
        recyclerView.setAdapter(adapter);
    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();

        for(int i = 0; i < 30; i++ ){

            if(i == 1 || i == 10){
                members.add(new Member(14 + i, "Zarifjonn" + i, prepareSubMembers()));
            } else {
                members.add(new Member(14 + i, "Zarifjonn" + i, null));
            }

        }
        return members;
    }

    private List<MemberSub> prepareSubMembers() {
        List<MemberSub> members = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            members.add(new MemberSub());
        }
        return members;
    }
}
