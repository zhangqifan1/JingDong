package com.bawei.jingdong.TheGuide;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawei.jingdong.Activitys.MainActivity;
import com.bawei.jingdong.Adapters.ViewPagerAdapter;
import com.bawei.jingdong.R;
import com.bawei.jingdong.View.SlideViewPager;


/**
 * 引导页
 * 使用ViewPager
 * 最后一页加定时器
 */
public class GuideActivity extends Activity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener, SlideViewPager.onSideListener {

    private RadioButton mRb0;
    private RadioButton mRb1;
    private RadioButton mRb2;
    private RadioButton mRb3;
    private RadioGroup mRg;
    private SlideViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        getData();
        initView();
        initViewPager();
        State();
    }

    /**
     * 状态监听
     */
    private void State() {
        mVp.addOnPageChangeListener(this);
        mVp.setOnSideListener(this);
        mRg.setOnCheckedChangeListener(this);
    }

    /**
     * 初始化ViewPager
     */
    private void initViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        mVp.setAdapter(adapter);
    }

    private void initView() {
        mRb0 = (RadioButton) findViewById(R.id.rb0);
        mRb1 = (RadioButton) findViewById(R.id.rb1);
        mRb2 = (RadioButton) findViewById(R.id.rb2);
        mRb3 = (RadioButton) findViewById(R.id.rb3);
        mRg = (RadioGroup) findViewById(R.id.rg);
        mVp =  findViewById(R.id.vp);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }


    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                mRg.check(R.id.rb0);
                break;
            case 1:
                mRg.check(R.id.rb1);
                break;
            case 2:
                mRg.check(R.id.rb2);
                break;
            case 3:
                mRg.check(R.id.rb3);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb0:
                mVp.setCurrentItem(0);
                break;
            case R.id.rb1:
                mVp.setCurrentItem(1);
                break;
            case R.id.rb2:
                mVp.setCurrentItem(2);
                break;
            case R.id.rb3:
                mVp.setCurrentItem(3);
                break;
            default:
                break;
        }
    }

    @Override
    public void onLeftSide() {

    }

    @Override
    public void onRightSide() {
        if(mVp.getCurrentItem()==3){
            startActivity(new Intent(GuideActivity.this, MainActivity.class));

            overridePendingTransition(R.anim.set, R.anim.setout);
        }
    }

    public void getData(){
        SharedPreferences sp = getSharedPreferences("content", MODE_PRIVATE);
        boolean flag = sp.getBoolean("flag", false);
        if(flag==false){
            sp.edit().putBoolean("flag",true).commit();
        }
        if(flag==false){
            Intent intent = new Intent(GuideActivity.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.set, R.anim.setout);
        }
    }
}
