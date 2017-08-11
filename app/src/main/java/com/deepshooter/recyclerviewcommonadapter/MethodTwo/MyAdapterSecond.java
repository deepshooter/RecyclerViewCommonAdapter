package com.deepshooter.recyclerviewcommonadapter.MethodTwo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.deepshooter.recyclerviewcommonadapter.MethodTwo.model.SomeBean;
import com.deepshooter.recyclerviewcommonadapter.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avinash on 05-08-2017.
 */

public class MyAdapterSecond extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_TYPE_TEXT = 0;
    private static final int ITEM_TYPE_IMAGE = 1;
    private static final int ITEM_TYPE_BEAN =2;

    private Context context;
    private List<Object> items = new ArrayList<>();


    public MyAdapterSecond(Context context, List<Object> items) {
        this.context = context;
        this.items = items;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == ITEM_TYPE_TEXT) {
            View view = layoutInflater.inflate(R.layout.adapter_five, parent, false);
            return new TextViewHolder(view);
        } else  if (viewType == ITEM_TYPE_IMAGE)  {
            View view = layoutInflater.inflate(R.layout.adapter_six, parent, false);
            return new ImageViewHolder(view);
        }else {
            View view = layoutInflater.inflate(R.layout.adapter_seven, parent, false);
            return new BeanViewHolder(view);
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof String) {
            return ITEM_TYPE_TEXT;
        } else if (items.get(position) instanceof Integer){
            return ITEM_TYPE_IMAGE;
        }else {
            return ITEM_TYPE_BEAN;
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Object item = items.get(position);

        if (holder instanceof TextViewHolder) {
            ((TextViewHolder) holder).bind((String) item);

        } else if (holder instanceof ImageViewHolder) {
            ((ImageViewHolder) holder).bind((Integer) item);

        }else if (holder instanceof BeanViewHolder) {
            ((BeanViewHolder) holder).bind((SomeBean) item);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    private static class TextViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public TextViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.textView);
        }

        public void bind(String s) {

            textView.setText(s);

        }
    }

    private static class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;

        public ImageViewHolder(View itemView) {
            super(itemView);

            mImageView = (ImageView) itemView.findViewById(R.id.imageView);
        }

        public void bind(Integer i) {
            mImageView.setBackgroundResource(i);
        }
    }



    private  class BeanViewHolder extends RecyclerView.ViewHolder {

        ImageView mImage;
        TextView serialNo ;

        public BeanViewHolder(View itemView) {
            super(itemView);

            mImage = (ImageView) itemView.findViewById(R.id.imageViewSecond);
            serialNo = (TextView) itemView.findViewById(R.id.serialNumber);

        }

        public void bind(SomeBean someBean) {

            serialNo.setText(someBean.getSerialNo()+"");

            Glide.with(context).load(someBean.getImageUrl())
                    .thumbnail(0.5f)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(mImage);
        }
    }
}
