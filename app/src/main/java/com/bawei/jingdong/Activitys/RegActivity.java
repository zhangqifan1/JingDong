package com.bawei.jingdong.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.jingdong.NetUrls.Const;
import com.bawei.jingdong.R;
import com.bawei.jingdong.Utils.JsonUtils;
import com.bawei.jingdong.Utils.Sp;
import com.bawei.jingdong.Utils.network.OkhttpUtils;
import com.bawei.jingdong.Utils.network.ResultCallback;
import com.squareup.okhttp.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegActivity extends Activity implements View.OnClickListener {


    /**
     * 请输入用户名
     */
    private EditText mEtNameReg;
    /**
     * 请输入密码
     */
    private EditText mEtPwdReg;
    /**
     * 注册
     */
    private Button mButRegTrue;
    /**
     * 登录
     */
    private Button mButLogTrue;
    private CheckBox mPwdShow;
    /**
     * 请输入邮箱
     */
    private EditText mEtemail;
    /**
     * 请重新输入密码
     */
    private EditText mEtPwdReg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        initView();
        mPwdShow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //如果选中，显示密码
                    mEtPwdReg.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    //否则隐藏密码
                    mEtPwdReg.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });
    }

    private void initView() {
        mEtNameReg = (EditText) findViewById(R.id.etNameReg);
        mEtPwdReg = (EditText) findViewById(R.id.etPwdReg);
        mButRegTrue = (Button) findViewById(R.id.butRegTrue);
        mButRegTrue.setOnClickListener(this);
        mButLogTrue = (Button) findViewById(R.id.butLogTrue);
        mButLogTrue.setOnClickListener(this);
        mPwdShow = (CheckBox) findViewById(R.id.pwdShowReg);
        mEtemail = (EditText) findViewById(R.id.etemail);
        mEtPwdReg2 = (EditText) findViewById(R.id.etPwdReg2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.butRegTrue:
                String name = getEdString(mEtNameReg);
                String pwd = getEdString(mEtPwdReg);
                String pwd2 = getEdString(mEtPwdReg2);
                String email = getEdString(mEtemail);

                if (name == null) {
                    Toast.makeText(RegActivity.this, "账号不为空,老铁", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pwd == null) {
                    Toast.makeText(RegActivity.this, "密码不为空,老铁", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pwd2 == null && !pwd2.equals(pwd)) {
                    Toast.makeText(RegActivity.this, "密码不对,老铁", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (email == null) {
                    Toast.makeText(RegActivity.this, "邮箱不为空,老铁", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mEtPwdReg.length() < 6) {
                    Toast.makeText(RegActivity.this, "密码至少6位", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!JsonUtils.isEmailAddress(email)) {
                    Toast.makeText(RegActivity.this, "邮箱格式不对", Toast.LENGTH_SHORT).show();
                    return;
                }
                Map<String, String> map1 = new HashMap<>();
                map1.put("username", name);
                map1.put("password", pwd);
                map1.put("password_confirm", pwd);
                map1.put("email", email);
                map1.put("client",Const.SYSTEM_TYPE);

                OkhttpUtils.postAsyn(Const.Reg, map1, new ResultCallback<Object>() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(Object response) {
                        System.out.println(response.toString());
                        if (JsonUtils.isTrueJson(response.toString())) {
                            try {
                                JSONObject jsonObject = new JSONObject(response.toString());
                                String datas = jsonObject.getString("datas");
                                String key = new JSONObject(datas).getString("key");
                                Sp.saveToSp(RegActivity.this,key);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(RegActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(RegActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                break;
            case R.id.butLogTrue:
                startActivity(new Intent(this, LoginActivity.class));
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
}
