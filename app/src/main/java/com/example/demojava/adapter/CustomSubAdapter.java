package com.example.demojava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demojava.R;
import com.example.demojava.model.MemberSub;

import java.util.List;

public class CustomSubAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<MemberSub> memberSubs;


    public CustomSubAdapter(Context context, List<MemberSub> memberSubs) {
        this.context = context;
        this.memberSubs = memberSubs;
    }

    @Override
    public int getItemCount() {
        return memberSubs.size();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MemberSub memberSub = memberSubs.get(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View footer = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_member_view_yes, viewGroup,false);
        return new CustomSubViewHolder(footer);
    }

    public class CustomSubViewHolder extends RecyclerView.ViewHolder{
        public View view;

        public CustomSubViewHolder(View v){
            super(v);
            view = v;
        }


    }
}









