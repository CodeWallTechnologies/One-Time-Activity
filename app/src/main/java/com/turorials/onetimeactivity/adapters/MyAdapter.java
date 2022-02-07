package com.turorials.onetimeactivity.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.model.Model1;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {



    Context context;
    ArrayList<Model1> arrayList;

    public MyAdapter(Context context, ArrayList<Model1> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context1 = parent.getContext();
        View view = LayoutInflater.from(context1).inflate(R.layout.testing_list_item,parent,false);
         MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model1 currentPositionObject = arrayList.get(position);

        if(currentPositionObject.getName().isEmpty()){
            holder.button.setVisibility(View.GONE);
        }else {
            holder.button.setText(currentPositionObject.getName());
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        Button button;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button2);
        }
    }
}
