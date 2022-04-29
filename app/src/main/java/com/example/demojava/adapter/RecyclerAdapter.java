package com.example.demojava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demojava.R;
import com.example.demojava.model.Member;
import com.example.demojava.model.MemberSub;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final int TYPE_AVAILABLE_YES = 0;
    private static final int TYPE_AVAILABLE_NO = 1;

    private Context context;
    private List<Member> members;
    private RecyclerView recyclerView;

    public RecyclerAdapter(Context context, List<Member> members) {
        this.context= context;
        this.members= members;
    }

    @Override
    public int getItemViewType(int position) {

        if(members.get(position).getMemberSubs() != null ) return TYPE_AVAILABLE_YES;

        return TYPE_AVAILABLE_NO;
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if(viewType == TYPE_AVAILABLE_YES){
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_member_view_yes, viewGroup, false);
            return new CustomViewHolder(view);
        }

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_member_view_no, viewGroup, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Member member =  members.get(position);

        if(holder instanceof CustomListHolder){

        }

        if(holder instanceof CustomViewHolder){
            RecyclerView recyclerView = ((CustomViewHolder) holder).reyclerview;
            recyclerView.setLayoutManager(new GridLayoutManager(context, 1));

            List<MemberSub> memberSubs = member.getMemberSubs();
            refreshAdapter(recyclerView, memberSubs);
        }
    }

    private void refreshAdapter(RecyclerView recyclerView, List<MemberSub> memberSubs){
        CustomSubAdapter adapter = new CustomSubAdapter(context, memberSubs);
        recyclerView.setAdapter(adapter);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public RecyclerView reyclerview;

        public CustomViewHolder(View v){
            super(v);
            view = v;
        }
    }

    public class CustomListHolder extends RecyclerView.ViewHolder {
        public View view;

        public CustomListHolder(View v){
            super(v);
            view = v;
        recyclerView = view.findViewById(R.id.recyclerview);
        }
    }

}
