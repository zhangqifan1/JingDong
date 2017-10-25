package com.bawei.jingdong.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.jingdong.Activitys.LoginActivity;
import com.bawei.jingdong.JavaBeans.EventMessage;
import com.bawei.jingdong.R;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentWoDe extends Fragment implements View.OnClickListener {


    private View view;
    private LinearLayout mLlReg;
    private String name="请先登录";
    /**
     * 登录状态
     */
    private TextView mTvStatus;

    public FragmentWoDe() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wo_de, container, false);
        EventBus.getDefault().register(this);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mLlReg = (LinearLayout) view.findViewById(R.id.llReg);
        mLlReg.setOnClickListener(this);
        mTvStatus = (TextView) view.findViewById(R.id.tvStatus);
        mTvStatus.setText(name);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.llReg:
                getContext().startActivity(new Intent(getContext(), LoginActivity.class));
                break;
        }
    }

    @Subscribe(sticky = true)
    public void onEvent(EventMessage message) {
        mTvStatus.setText( "登录用户:"+message.name);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
