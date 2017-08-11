package com.deepshooter.recyclerviewcommonadapter.MethodOne;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.deepshooter.recyclerviewcommonadapter.MethodOne.model.Bean;
import com.deepshooter.recyclerviewcommonadapter.MethodOne.model.URLBean;
import com.deepshooter.recyclerviewcommonadapter.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter mMyAdapter;


    List<Object> items;

    String mUrl1 = "http://4.bp.blogspot.com/-8v_k_fOcfP8/UQIL4ufghBI/AAAAAAAAEDo/9ffRRTM9AnA/s1600/android-robog-alone.png";
    String mUrl2 = "https://lh5.googleusercontent.com/-385nYn358IU/AAAAAAAAAAI/AAAAAAAAFKk/3BG6SzJ4jIM/photo.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        initializeValues();
    }


    private void initializeValues() {

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        items = new ArrayList<>();
        items.add("Hello");
        items.add(new Bean(R.drawable.deleteicon, "Delete"));
        items.add("Bye");
        items.add(R.drawable.fb);
        items.add(new Bean(R.drawable.email, "Email"));
        items.add(R.drawable.inst);
        items.add("Okay");
        items.add(new URLBean(mUrl1));
        items.add("Taata");
        items.add(new URLBean(mUrl2));
        items.add(R.drawable.gp);


        setValues();
    }

    private void setValues() {

        mMyAdapter = new MyAdapter(RecyclerViewActivity.this, items);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setAdapter(mMyAdapter);
        mMyAdapter.notifyDataSetChanged();
    }


}
