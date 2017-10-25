package com.bawei.jingdong.Activitys;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawei.jingdong.Fragments.FragmentWoDe;
import com.bawei.jingdong.Fragments.Fragment_FaXian;
import com.bawei.jingdong.Fragments.Fragment_FenLei;
import com.bawei.jingdong.Fragments.Fragment_ShoppingCar;
import com.bawei.jingdong.Fragments.Fragment_ShouYe;
import com.bawei.jingdong.R;
import com.readystatesoftware.systembartint.SystemBarTintManager;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioButton mRb0;
    private RadioButton mRb1;
    private RadioButton mRb2;
    private RadioButton mRb3;
    private RadioButton mRb4;
    private Fragment_ShouYe shouYe;
    private Fragment_FenLei fenLei;
    private Fragment_ShoppingCar shoppingCar;
    private Fragment_FaXian faXian;
    private FragmentWoDe woDe;
    private RadioGroup mLlbottom;
    private FrameLayout mFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            // 激活状态栏
            tintManager.setStatusBarTintEnabled(true);
            //给状态栏设置颜色
            tintManager.setStatusBarTintResource(Color.argb(0, 0, 0, 0));
        }
        initView();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, shouYe).commit();
        mLlbottom.setOnCheckedChangeListener(this);
    }


    private void initView() {
        mRb0 = (RadioButton) findViewById(R.id.rb0);
        mRb1 = (RadioButton) findViewById(R.id.rb1);
        mRb2 = (RadioButton) findViewById(R.id.rb2);
        mRb3 = (RadioButton) findViewById(R.id.rb3);
        mRb4 = (RadioButton) findViewById(R.id.rb4);

        shouYe = new Fragment_ShouYe();
        fenLei = new Fragment_FenLei();
        shoppingCar = new Fragment_ShoppingCar();
        faXian = new Fragment_FaXian();
        woDe = new FragmentWoDe();
        mLlbottom = (RadioGroup) findViewById(R.id.llbottom);
        mFrame = (FrameLayout) findViewById(R.id.frame);

    }



    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch(checkedId){
            case R.id.rb0:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, shouYe).commit();
                break;
            case R.id.rb1:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, fenLei).commit();
                break;
            case R.id.rb2:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, faXian).commit();
                break;
            case R.id.rb3:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, shoppingCar).commit();
                break;
            case R.id.rb4:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, woDe).commit();
                break;
        }
    }
}
