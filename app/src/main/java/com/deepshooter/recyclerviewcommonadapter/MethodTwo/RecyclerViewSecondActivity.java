package com.deepshooter.recyclerviewcommonadapter.MethodTwo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.deepshooter.recyclerviewcommonadapter.MethodTwo.model.SomeBean;
import com.deepshooter.recyclerviewcommonadapter.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewSecondActivity extends AppCompatActivity {


    RecyclerView mRecyclerView;
    MyAdapterSecond mMyAdapterSecond;

    List<Object> items;

    String url1 = "https://api.androidhive.info/images/glide/medium/deadpool.jpg";
    String url2 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTqzzdjI4PIbvPOvwYOlWunYnmjvHJgrDfS1jo56KuQyyUyImbXzg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_second);

        initializeValues();
    }


    private void initializeValues() {

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewSecond);

        items = new ArrayList<>();
        items.add("Hello");
        items.add(R.drawable.email);
        items.add(new SomeBean(100, url1));
        items.add("Hello Again");
        items.add(R.drawable.deleteicon);
        items.add(new SomeBean(200, url2));

        setValues();

    }

    private void setValues() {

        mMyAdapterSecond = new MyAdapterSecond(RecyclerViewSecondActivity.this, items);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setAdapter(mMyAdapterSecond);
        mMyAdapterSecond.notifyDataSetChanged();

    }
}
