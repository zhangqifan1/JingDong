package com.bawei.jingdong.Activitys;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.jingdong.JavaBeans.EventMessage;
import com.bawei.jingdong.NetUrls.Const;
import com.bawei.jingdong.R;
import com.bawei.jingdong.Utils.JsonUtils;
import com.bawei.jingdong.Utils.network.OkhttpUtils;
import com.bawei.jingdong.Utils.network.ResultCallback;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.squareup.okhttp.Request;

import java.util.HashMap;
import java.util.Map;

import de.greenrobot.event.EventBus;

public class LoginActivity extends FragmentActivity implements View.OnClickListener {

    /**
     * 请输入用户名
     */
    private EditText mEtName;
    private CheckBox mPwdShow;
    /**
     * 请输入密码
     */
    private EditText mEtPwd;
    /**
     * 登录
     */
    private Button mButLog;
    /**
     * 注册
     */
    private Button mButReg;
    /**
     * 忘记密码
     */
    private Button mButForgetPwd;
    private String name;
    private String pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

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
        mPwdShow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //如果选中，显示密码
                    mEtPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    //否则隐藏密码
                    mEtPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });

    }

    private void initView() {
        mEtName = (EditText) findViewById(R.id.etName);
        mPwdShow = (CheckBox) findViewById(R.id.pwdShow);
        mEtPwd = (EditText) findViewById(R.id.etPwd);
        mButLog = (Button) findViewById(R.id.butLog);
        mButLog.setOnClickListener(this);
        mButReg = (Button) findViewById(R.id.butReg);
        mButReg.setOnClickListener(this);
        mButForgetPwd = (Button) findViewById(R.id.butForgetPwd);
        mButForgetPwd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.butLog:
                name = getEdString(mEtName);
                pwd = getEdString(mEtPwd);
                if (name == null) {
                    Toast.makeText(LoginActivity.this, "账号不为空,老铁", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pwd == null) {
                    Toast.makeText(LoginActivity.this, "密码不为空,老铁", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mEtPwd.length() < 6) {
                    Toast.makeText(LoginActivity.this, "密码至少6位", Toast.LENGTH_SHORT).show();
                    return;
                }
                //把用户名和密码发送到服务器
                Map<String, String> map = new HashMap<>();
                map.put("username", name);
                map.put("password", pwd);
                map.put("client", Const.SYSTEM_TYPE);

                OkhttpUtils.postAsyn(Const.Log, map, new ResultCallback<Object>() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(Object response) {
                        System.out.println(response.toString());
                        if(JsonUtils.isTrueJson(response.toString())){
                            EventMessage message=new EventMessage();
                            message.flag=true;
                            message.name=name;
                            EventBus.getDefault().postSticky(message );
                            Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            case R.id.butReg:
                startActivity(new Intent(this,RegActivity.class));

                break;
            case R.id.butForgetPwd:
                break;
        }
    }


    public String getEdString(EditText editText) {
        String s = editText.getText().toString();
        if (s != null && !s.equals("")) {
            return s;
        }
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
