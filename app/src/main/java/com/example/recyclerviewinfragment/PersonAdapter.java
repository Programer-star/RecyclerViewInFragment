package com.example.recyclerviewinfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    ArrayList<Person> people;
    OnItemSelected activity;
    public interface OnItemSelected{
        void onItemClick(int index);
    }

    public PersonAdapter(Context context, ArrayList<Person> list)
    {
        people = list;
        activity = (OnItemSelected) context;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvNameOnList;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameOnList = itemView.findViewById(R.id.tvNameOnList);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClick(people.indexOf((Person) v.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(people.get(position));
        holder.tvNameOnList.setText(people.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
