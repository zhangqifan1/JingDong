package com.bawei.jingdong.View;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class SlideViewPager extends ViewPager {
    /**
     * 开始点击的位置
     */
    private int startX;
    /**
     * 临界值
     */
    private int criticalValue = 200;

    /**
     * 边界滑动回调
     */
    public interface onSideListener {
        /**
         * 左边界回调
         */
        void onLeftSide();

        /**
         * 右边界回调
         */
        void onRightSide();
    }

    /**
     * 回调
     */
    private onSideListener mOnSideListener;

    /**
     * 设置回调
     *
     * @param listener
     */
    public void setOnSideListener(onSideListener listener) {
        this.mOnSideListener = listener;
    }

    /**
     * 设置临界值
     *
     * @param criticalValue
     */
    public void setCriticalValue(int criticalValue) {
        this.criticalValue = criticalValue;
    }

    public SlideViewPager(Context context) {
        this(context, null);
    }

    public SlideViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 调度触摸事件  这个方法在onTunchEnent 之前
     * @param event
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //  一.先获得鼠标点下的位置
                startX = (int) event.getX();
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:

                if (startX - event.getX() > criticalValue && (getCurrentItem() == getAdapter().getCount() - 1)) {
                    if (null != mOnSideListener) {
                        mOnSideListener.onRightSide();
                    }
                }
                if ((event.getX() - startX) > criticalValue && (getCurrentItem() == 0)) {
                    if (null != mOnSideListener) {
                        mOnSideListener.onLeftSide();
                    }
                }
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}