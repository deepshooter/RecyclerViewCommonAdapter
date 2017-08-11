package com.deepshooter.recyclerviewcommonadapter.MethodOne;

import android.content.Context;
import android.support.annotation.Nullable;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.deepshooter.recyclerviewcommonadapter.MethodOne.model.Bean;
import com.deepshooter.recyclerviewcommonadapter.MethodOne.model.URLBean;
import com.deepshooter.recyclerviewcommonadapter.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Avinash on 04-08-2017.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_TYPE_TEXT = 0;
    private static final int ITEM_TYPE_IMAGE = 1;
    private static final int ITEM_TYPE_BEAN = 2;
    private static final int ITEM_TYPE_URL = 3;


    Context context;
    private List<Object> items = new ArrayList<>();

    public MyAdapter(Context context, List<Object> items) {
        this.items.addAll(items);
        this.context = context;
    }


    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof String) {
            return ITEM_TYPE_TEXT;
        } else if (items.get(position) instanceof Integer) {
            return ITEM_TYPE_IMAGE;
        } else if (items.get(position) instanceof Bean) {
            return ITEM_TYPE_BEAN;
        } else {
            return ITEM_TYPE_URL;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == ITEM_TYPE_TEXT) {
            View view = layoutInflater.inflate(R.layout.adapter_one, parent, false);
            return new BaseViewHolder(view);
        } else if (viewType == ITEM_TYPE_IMAGE) {
            View view = layoutInflater.inflate(R.layout.adapter_two, parent, false);
            return new BaseViewHolder(view);
        } else if (viewType == ITEM_TYPE_BEAN) {
            View view = layoutInflater.inflate(R.layout.adapter_three, parent, false);
            return new BaseViewHolder(view);
        } else {
            View view = layoutInflater.inflate(R.layout.adapter_four, parent, false);
            return new BaseViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Object item = items.get(position);
        switch (getItemViewType(position)) {
            case ITEM_TYPE_TEXT:
                ((BaseViewHolder) holder).bind((String) item);
                break;
            case ITEM_TYPE_IMAGE:
                ((BaseViewHolder) holder).bind((Integer) item);
                break;
            case ITEM_TYPE_BEAN:
                ((BaseViewHolder) holder).bind((Bean) item);
                break;
            case ITEM_TYPE_URL:
                ((BaseViewHolder) holder).bind((URLBean) item);
                break;
        }


    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class BaseViewHolder extends RecyclerView.ViewHolder {
        @Nullable
        ImageView mImageView;
        @Nullable
        TextView mTextView;

        public BaseViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image);
            mTextView = (TextView) itemView.findViewById(R.id.text);
        }

        public void bind(URLBean urlBean) {
            Picasso.with(context).load(urlBean.getUrl()).placeholder(R.mipmap.ic_launcher).into(mImageView);
        }

        public void bind(String item) {
            if (mTextView != null) {
                mTextView.setText(item);
            }
        }

        public void bind(Integer item) {
            if (mImageView != null) {
                mImageView.setBackgroundResource(item);
            }
        }

        public void bind(Bean bean) {
            if (mImageView != null) {
                mImageView.setBackgroundResource(bean.getImage());
            }
            if (mTextView != null) {
                mTextView.setText(bean.getName());
            }
        }
    }


}
