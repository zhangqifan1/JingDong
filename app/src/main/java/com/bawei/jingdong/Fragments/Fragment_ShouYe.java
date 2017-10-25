package com.bawei.jingdong.Fragments;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.jingdong.Adapters.MyRecycleViewAdapter;
import com.bawei.jingdong.R;
import com.bawei.jingdong.View.MyScrollView;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yzq.zxinglibrary.android.CaptureActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_ShouYe extends Fragment implements MyScrollView.OnScrollViewListenner, View.OnClickListener {


    private RecyclerView cv;
    private MyScrollView mScrollView;
    private LinearLayout mTitleLayout;
    private int height;
    private View inflate;
    private TextView mTvSaoYiSao;
    private TextView mTvMiddleContent;
    private TextView mTvMessage;
    private ImageView image_search;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment__shou_ye, container, false);
        AndPermission.with(getContext())
                .requestCode(100)
                .permission(Permission.CAMERA)
                .start();
        //找控件
        initView();
        //找顶部图片的高度  随时变化的一个高度
        findHeighOfTopView();
        //为ScrollView设置监听
        mScrollView.setmOnScrollViewListenner(this);
        cv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayout.VERTICAL,false));
        MyRecycleViewAdapter adapter = new MyRecycleViewAdapter(getContext());
        cv.setAdapter(adapter);

        return inflate;

    }

    private void findHeighOfTopView() {
        //获取控件的试图观察者,以便通过试图观察者得到控件的宽高参数
        ViewTreeObserver viewTreeObserver = cv.getViewTreeObserver();
        //添加观察者监听
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                //回调监听后首先移除该监听 占资源
                cv.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                //得到高度
                height = cv.getHeight();
            }
        });

    }

    private void initView() {
        cv = (RecyclerView) inflate.findViewById(R.id.cv);
        mScrollView = (MyScrollView) inflate.findViewById(R.id.scrollView);
        mTitleLayout = (LinearLayout) inflate.findViewById(R.id.title_layout);
        mTvSaoYiSao = (TextView) inflate.findViewById(R.id.tvSaoYiSao);
        mTvMiddleContent = (TextView) inflate.findViewById(R.id.tvMiddleContent);
        mTvMessage = (TextView) inflate.findViewById(R.id.tvMessage);
        image_search = inflate.findViewById(R.id.image_search);
        mTvSaoYiSao.setOnClickListener(this);
    }

    //自定义ObeservableScrollView的监听器 ,是ObeservableScrollView在把图片滑到消失后,显示出标题的效果
    @Override
    public void onScrollChanged(MyScrollView mMyScrollView, int l, int t, int oldl, int oldt) {
        //对T轴进行判断,就俩种状态1.消失没有了    2.随着滑动,颜色越来越深
        if (t <= 0) {//没有往下滑
            image_search.setImageResource(R.drawable.as6);
            mTvSaoYiSao.setTextColor(Color.GRAY);
            mTvMiddleContent.setTextColor(Color.GRAY);
            mTvMessage.setTextColor(Color.GRAY);
            mTvMiddleContent.setBackgroundResource(R.drawable.oval_line);
            //设置标题所在背景为透明
            mTitleLayout.setBackgroundColor(Color.argb(0, 0, 0, 0));
        }
        //大于0表示有位移 正在拖动中,发生颜色变化的同时不超过顶部图片的高度
        else if (t > 0 && t < height) {

            if(t>50){
                image_search.setImageResource(R.drawable.aqm);
                mTvSaoYiSao.setTextColor(Color.BLACK);
                mTvMiddleContent.setTextColor(Color.BLACK);
                mTvMessage.setTextColor(Color.BLACK);
                mTvMiddleContent.setBackgroundResource(R.drawable.oval_line_hui);
            }
            //获取ScrollView向下滑动,图片消失部分的比例    注意在配置比例时  一定要强转float
            float scale = (float) t / height;
            //根据这个比例,让标题的颜色慢慢的由浅入深
            float alpha = (255 * scale);
            //设置标题布局颜色
            mTitleLayout.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), CaptureActivity.class);
        startActivity(intent);
    }
}