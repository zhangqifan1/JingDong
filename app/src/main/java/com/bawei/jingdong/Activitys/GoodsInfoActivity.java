package com.bawei.jingdong.Activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.jingdong.JavaBeans.GoodsBean;
import com.bawei.jingdong.JavaBeans.InfoBean;
import com.bawei.jingdong.NetUrls.Const;
import com.bawei.jingdong.R;
import com.bawei.jingdong.Utils.network.OkhttpUtils;
import com.bawei.jingdong.Utils.network.ResultCallback;
import com.squareup.okhttp.Request;

import de.greenrobot.event.EventBus;

public class GoodsInfoActivity extends Activity implements View.OnClickListener {

    private ImageView mImageInfo;
    /**
     * aaa
     */
    private TextView mTvInfo;
    /**
     * 加入购物车
     */
    private Button mButCollect;
    private WebView mWv;
    private GoodsBean name1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_info);
        initView();
        name1 = (GoodsBean) getIntent().getSerializableExtra("name1");
//        mWv.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return super.shouldOverrideUrlLoading(view, url);
//            }
//        });
        mWv.loadUrl("http://127.0.0.1/index.php?act=goods&op=index&goods_id=100009");
        String name = getIntent().getStringExtra("name");

        OkhttpUtils.getAsyn(Const.Info + name, new ResultCallback<InfoBean>() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(InfoBean response) {
                mWv.loadUrl(response.datas.goods_info.goods_url);
                //http://127.0.0.1/index.php?act=goods&op=index&goods_id=100006
                System.out.println(response.datas.goods_info.goods_url);
//                GlideUtils.loadImageView(GoodsInfoActivity.this,response.datas.spec_image.get(0),mImageInfo);
                mTvInfo.setText(response.datas.goods_info.goods_name);
            }
        });
    }

    private void initView() {
        mImageInfo = (ImageView) findViewById(R.id.image_info);
        mTvInfo = (TextView) findViewById(R.id.tvInfo);
        mButCollect = (Button) findViewById(R.id.butCollect);
        mButCollect.setOnClickListener(this);
        mWv = (WebView) findViewById(R.id.wv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.butCollect:
                EventBus.getDefault().postSticky(name1);
                System.out.println("000000000000000000000000");
                break;
        }
    }
}
