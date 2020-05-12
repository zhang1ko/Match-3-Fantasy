package com.example.mygridjava;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context mContext;

    private List<Button> mButtons;

    private int mColumnWidth, mColumnHeight;

    private long mDelay;

    private boolean mNoAnimate;

    public CustomAdapter(Context context, List<Button> buttons, int columnWidth,
                         int columnHeight) {
        mContext = context;
        mButtons = buttons;
        mColumnWidth = columnWidth;
        mColumnHeight = columnHeight;
    }

    @Override
    public int getCount() {
        return mButtons.size();
    }

    @Override
    public Object getItem(int position) {
        return (Object) mButtons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Button button;

        if (convertView == null) {
            button = mButtons.get(position);
        } else {
            button = (Button) convertView;
        }

        return button;
    }

}
