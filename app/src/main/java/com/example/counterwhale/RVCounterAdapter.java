package com.example.counterwhale;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVCounterAdapter extends RecyclerView.Adapter<RVCounterAdapter.MyViewHolder> {
    private List<Counter> counterList;
    private Context context;

    public RVCounterAdapter (List<Counter> counterList, Context context){
        this.counterList = counterList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_layout_counter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.et_countWhat.setText(counterList.get(position).getCountWhat());
        holder.et_number.setText(String.valueOf(counterList.get(position).getCount()));

        //Button-ClickListener - DOWN, UP, DELETE
        holder.btn_img_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newCount = Integer.parseInt(holder.et_number.getText().toString());
                holder.et_number.setText(String.valueOf(counterList.get(position).decreaseCount(newCount)));
            }
        });

        holder.btn_img_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newCount = Integer.parseInt(holder.et_number.getText().toString());
                holder.et_number.setText(String.valueOf(counterList.get(position).increaseCount(newCount)));
            }
        });

        holder.btn_img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position != RecyclerView.NO_POSITION) {
                    counterList.remove(position);
                    notifyItemRemoved(position);
                }
            }
        });

        //EditText-Listener for Changes of CountWhat
        holder.et_countWhat.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                String newText = holder.et_countWhat.getText().toString();
                counterList.get(position).setCountWhat(newText);
            }
        });
    }


    @Override
    public int getItemCount() {
        return counterList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageButton btn_img_up, btn_img_down, btn_img_delete;
        EditText et_countWhat, et_number;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            btn_img_up = itemView.findViewById(R.id.btn_img_up);
            btn_img_down = itemView.findViewById(R.id.btn_img_down);
            btn_img_delete = itemView.findViewById(R.id.btn_img_delete);
            et_countWhat = itemView.findViewById(R.id.et_countWhat);
            et_number = itemView.findViewById(R.id.et_number);
        }
    }



}
