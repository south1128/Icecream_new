package com.example.icecream_new.home;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.icecream_new.R;

import java.util.ArrayList;

public class HomeGridViewAdapter extends BaseAdapter {
    //    String TAG = HomeFragment.class.getSimpleName();
    ArrayList<HomeItemInfo> item = new ArrayList<HomeItemInfo>();


    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int i) {
        return item.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void addItem(HomeItemInfo add_item) {
        item.add(add_item);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Context context = viewGroup.getContext();
        final HomeItemInfo myitem = item.get(i);

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_icon, viewGroup, false);

            TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
            TextView tv_category = (TextView) view.findViewById(R.id.tv_category);
            ImageView iv_icon = (ImageView) view.findViewById(R.id.iv_icon);

            tv_name.setText(myitem.getName());
            tv_category.setText(myitem.getCategory());
            iv_icon.setImageResource(myitem.getResId());

            Log.d(TAG, "getView() - [ " + i + " ] " + myitem.getName());
        } else {
            View view_1 = new View(context);
            view_1 = (View) view;
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //팝업 생성
                HomeItemDialog homeItemDialog = HomeItemDialog.getInstance();
                homeItemDialog.setNameText(myitem.getName());
                homeItemDialog.show(getChildFragmentManager(), HomeItemDialog.TAG_EVENT_DIALOG);
            }
        });

        //홀리몰리

        return view;

    }
}
