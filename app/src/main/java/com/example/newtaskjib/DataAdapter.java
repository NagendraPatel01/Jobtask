package com.example.newtaskjib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

    Context context;
 List<DataModel.Entry> list;

    public DataAdapter(Context context, List<DataModel.Entry> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.entriesdesign,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.text1.setText(list.get(position).getApi());
        holder.text2.setText(list.get(position).getDescription());
        holder.text3.setText(list.get(position).getCors());
        holder.text4.setText(list.get(position).getLink());
        holder.text5.setText(list.get(position).getCategory());

        holder.linear.setVisibility(View.GONE);

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (holder.linear.getVisibility() == View.VISIBLE){
                    holder.linear.setVisibility(View.GONE);
                }
                else {
                    holder.linear.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView text1,text2,text3,text4,text5;
        Button btn;
        LinearLayout linear;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            text1=itemView.findViewById(R.id.text1);
            text2=itemView.findViewById(R.id.text2);
            text3=itemView.findViewById(R.id.text3);
            text4=itemView.findViewById(R.id.text4);
            text5=itemView.findViewById(R.id.text5);
            btn=itemView.findViewById(R.id.btn);
            linear=itemView.findViewById(R.id.linear);
        }
    }
}
