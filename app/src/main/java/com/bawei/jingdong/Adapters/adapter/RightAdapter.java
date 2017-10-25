package com.bawei.jingdong.Adapters.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.bawei.jingdong.Activitys.GoodsInfoActivity;
import com.bawei.jingdong.JavaBeans.GoodsBean;
import com.bawei.jingdong.JavaBeans.RightBean;
import com.bawei.jingdong.NetUrls.Const;
import com.bawei.jingdong.R;
import com.bawei.jingdong.Utils.network.OkhttpUtils;
import com.bawei.jingdong.Utils.network.ResultCallback;
import com.bawei.jingdong.View.MyGridView;
import com.squareup.okhttp.Request;

/**
 * Created by 张祺钒
 * on2017/10/17.
 */

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.MyViewHolder> {
    private Context context;
    private RightBean bean;
    private String id;

    public RightAdapter(Context context, RightBean bean, String id) {
        this.context = context;
        this.bean = bean;
        this.id = id;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.rightitem, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RightBean.DatasBean.ClassListBean listBean = bean.datas.class_list.get(position);
        holder.rightTitle.setText(listBean.gc_name);
        getData(holder,position);

    }

    private void getData(final MyViewHolder holder, int position) {
        OkhttpUtils.getAsyn(Const.Name_id +"=" +id, new ResultCallback<RightBean>() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(final RightBean response) {
                holder.grid.setAdapter(new GridViewAdapter(context,response));
                holder.grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                        OkhttpUtils.getAsyn(Const.Search + "=" + response.datas.class_list.get(position).gc_id, new ResultCallback<GoodsBean>() {
                            @Override
                            public void onError(Request request, Exception e) {

                            }

                            @Override
                            public void onResponse(GoodsBean response) {
                                Intent intent = new Intent(context, GoodsInfoActivity.class);
                                Bundle bundle=new Bundle();
                                bundle.putSerializable("name1",response);
                                intent.putExtras(bundle);
                                intent.putExtra("name",response.datas.goods_list.get(position).goods_id);
                                context.startActivity(intent);
                            }
                        });
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return bean.datas.class_list.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView rightTitle;
        private final MyGridView grid;

        public MyViewHolder(View itemView) {
            super(itemView);
            rightTitle = itemView.findViewById(R.id.rightTitle);
            grid = itemView.findViewById(R.id.grid);
        }
    }
}
