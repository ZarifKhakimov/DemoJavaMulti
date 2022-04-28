package com.example.demojava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demojava.R;
import com.example.demojava.model.Member;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final int TYPE_AVAILABLE_YES = 0;
    private static final int TYPE_AVAILABLE_NO = 1;

    private Context context;
    private List<Member> members;

    public RecyclerAdapter(Context context, List<Member> members) {
        this.context= context;
        this.members= members;
    }


    @Override
    public int getItemViewType(int position) {
        if(members.get(position).isAvailable()){
            return TYPE_AVAILABLE_YES;
        }
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
            return new CustomViewYesHolder(view);
        }

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_member_view_no, viewGroup, false);
        return new CustomViewNotHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Member member =  members.get(position);

        if(holder instanceof CustomViewYesHolder){
            TextView name = ((CustomViewYesHolder) holder).name;
            TextView age = ((CustomViewYesHolder) holder).age;

            name.setText(member.getName());
            age.setId(member.getAge());
        }

        if(holder instanceof CustomViewNotHolder){
            TextView name = ((CustomViewNotHolder) holder).name;
            TextView age = ((CustomViewNotHolder) holder).age;

            name.setText("Name isn't Available");
            age.setText("Age isn't Available");
        }
    }

    public class CustomViewYesHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView age, name;

        public CustomViewYesHolder(View v){
            super(v);
            view = v;

            name = view.findViewById(R.id.name);
            age = view.findViewById(R.id.age);
        }
    }

    public class CustomViewNotHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView name, age;

        public CustomViewNotHolder(View v){
            super(v);
            view = v;

            name = view.findViewById(R.id.name);
            age = view.findViewById(R.id.age);
        }
    }


}
