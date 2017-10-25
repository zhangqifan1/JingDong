package com.bawei.jingdong.View;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bawei.jingdong.R;

/**
 * Created by 张祺钒
 * on2017/10/12.
 */

public class TitleBar extends RelativeLayout {

    private View view;
    private TextView tvSaoYiSao;
    private TextView tvMiddleContent;
    private TextView tvMessage;

    public TitleBar(Context context) {
        this(context,null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }
    private int color= Color.BLACK;

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        view = LayoutInflater.from(context).inflate(R.layout.titlebar, this);
        tvSaoYiSao = view.findViewById(R.id.tvSaoYiSao);
        tvMiddleContent = view.findViewById(R.id.tvMiddleContent);
        tvMessage = view.findViewById(R.id.tvMessage);

        tvSaoYiSao.setTextColor(color);
        tvMiddleContent.setTextColor(color);
        tvMessage.setTextColor(color);
    }
    public  void  setLeftClick(OnClickListener onClickListener){
        view.findViewById(R.id.ll_Left).setOnClickListener(onClickListener);
    }
    public  void  setMiddleClick(OnClickListener onClickListener){
        tvMiddleContent.setOnClickListener(onClickListener);
    }
    public  void  setRightClick(OnClickListener onClickListener){
        view.findViewById(R.id.ll_Right).setOnClickListener(onClickListener);
    }

    public void setColor(int color) {
        this.color = color;
    }
}
