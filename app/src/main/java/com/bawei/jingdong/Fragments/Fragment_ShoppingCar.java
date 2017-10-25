package com.bawei.jingdong.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.jingdong.Adapters.ExpandableListViewAdapter;
import com.bawei.jingdong.JavaBeans.EventMessage;
import com.bawei.jingdong.JavaBeans.GoodsBean;
import com.bawei.jingdong.R;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_ShoppingCar extends Fragment {

    private ExpandableListView mElv;
    /**
     * 全选
     */
    private CheckBox mCheckboxAll;
    /**
     * (0)
     */
    private TextView mCheckedNum;
    /**
     * 合计:￥0.00
     */
    private TextView mHeji;
    /**
     * 结算
     */
    private TextView mJieSuan;
    private ExpandableListViewAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment__shopping_car, container, false);
        initView(inflate);
        System.out.println("Main+++++++++++++++++++++++");
        EventBus.getDefault().register(this);
        adapter = new ExpandableListViewAdapter(getContext());
        mElv.setAdapter(adapter);
        mCheckboxAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置商品全部选中
                adapter.checkAllShop(mCheckboxAll.isChecked());
                //计算选中的价格和数量
                String shopPrice = adapter.getShopPrice();
                //判断商品是否全部选中
                boolean b = adapter.selectAll();

                String[] split = shopPrice.split(",");
                mHeji.setText(split[0]);
                mCheckedNum.setText(split[1]);
                mCheckboxAll.setChecked(b);
            }
        });
        adapter.getAdapterData(new ExpandableListViewAdapter.AdapterData() {
            @Override
            public void Data(View v, String str, boolean b) {
                String[] split = str.split(",");
                mHeji.setText(split[0]);
                mCheckedNum.setText(split[1]);
                mCheckboxAll.setChecked(b);
            }
        });

        mCheckboxAll.setChecked(adapter.selectAll());
        adapter.notifyDataSetChanged();
        if(m==false){
            Toast.makeText(getContext(),"未登录",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getContext(),"已登录",Toast.LENGTH_SHORT).show();
        }
        return inflate;
    }


    private void initView(View inflate) {
        mElv = (ExpandableListView) inflate.findViewById(R.id.elv);
        mCheckboxAll = (CheckBox) inflate.findViewById(R.id.checkboxAll);
        mCheckedNum = (TextView) inflate.findViewById(R.id.checkedNum);
        mHeji = (TextView) inflate.findViewById(R.id.heji);
        mJieSuan = (TextView)inflate. findViewById(R.id.jieSuan);
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);//取消注册
    }
    private boolean m=false;

    @Subscribe(sticky = true)
    public  void Event(EventMessage eventMessage){
       m=eventMessage.flag;
    }
    @Subscribe(threadMode = ThreadMode.MainThread,sticky = true )
    public  void Event1(GoodsBean goodsBean){
        System.out.println(goodsBean.datas.goods_list.size());
        adapter.setGoodsBean(goodsBean);
    }
}