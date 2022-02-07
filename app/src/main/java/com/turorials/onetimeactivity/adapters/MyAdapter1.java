package com.turorials.onetimeactivity.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.model.Model1;
import com.turorials.onetimeactivity.model.Model2;

import java.util.ArrayList;

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.MyViewHolder1> {



    Context context;
    ArrayList<Model2> model2ArrayList;

    public MyAdapter1(Context context, ArrayList<Model2> model2ArrayList) {
        this.context = context;
        this.model2ArrayList = model2ArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context1 = parent.getContext();
        View view = LayoutInflater.from(context1).inflate(R.layout.testing_list_item2,parent,false);
         MyViewHolder1 myViewHolder = new MyViewHolder1(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder1 holder, int position) {
        Model2 currentPositionObjectOfModel2 = model2ArrayList.get(position);

        if(currentPositionObjectOfModel2.getTitle().isEmpty()){
            holder.textView.setVisibility(View.GONE);
        }else {
            holder.textView.setText(currentPositionObjectOfModel2.getTitle());
        }

    }

    @Override
    public int getItemCount() {
        return model2ArrayList.size();
    }

    class MyViewHolder1 extends RecyclerView.ViewHolder{
      TextView textView;

        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewTitle);
        }
    }
}
