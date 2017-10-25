package com.bawei.jingdong.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.jingdong.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张祺钒
 * on2017/9/27.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private List<Integer> list=new ArrayList<>();
    private Context context;

    public ViewPagerAdapter(Context context) {
        this.context = context;
        list.add(R.mipmap.y0);
        list.add(R.mipmap.y1);
        list.add(R.mipmap.y2);
        list.add(R.mipmap.y3);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView=new ImageView(context);
        imageView.setImageResource(list.get(position));
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
