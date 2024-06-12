package com.example.counterwhale;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ImageButton btn_img_addMore;
    List<Counter> counterList = new LinkedList<>();

    //RecyclerView elements
    RecyclerView rv_counter;
    RecyclerView.Adapter<RVCounterAdapter.MyViewHolder> rv_counterAdapter;
    RecyclerView.LayoutManager rv_layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_img_addMore = findViewById(R.id.btn_img_addMore);

        //add first Counter
        counterList.add(new Counter());

        //RecyclerView initialisation
        rv_counter = findViewById(R.id.rv_counter);
        rv_counter.hasFixedSize();
        rv_layoutManager = new LinearLayoutManager(this);
        rv_counter.setLayoutManager(rv_layoutManager);
        rv_counterAdapter = new RVCounterAdapter (counterList, this);
        rv_counter.setAdapter(rv_counterAdapter);


        btn_img_addMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterList.add(new Counter());
                rv_counterAdapter.notifyItemInserted(counterList.size()-1); //to refresh after insert
            }
        });


    }
}