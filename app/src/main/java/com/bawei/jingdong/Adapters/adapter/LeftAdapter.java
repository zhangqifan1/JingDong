package com.bawei.jingdong.Adapters.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.jingdong.Fragments.Fragment_FenLei;
import com.bawei.jingdong.JavaBeans.LeftBean;
import com.bawei.jingdong.R;
import com.bawei.jingdong.interfaces.Myclicklistener;

/**
 * Created by 张祺钒
 * on2017/10/16.
 */

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.MyViewHolder> {
    private LeftBean bean;
    private Context context;

    private Myclicklistener myclicklistener;

    public void setMyclicklistener(Myclicklistener myclicklistener) {
        this.myclicklistener = myclicklistener;
    }

    public LeftAdapter(LeftBean bean, Context context) {
        this.bean = bean;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.leftitem, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        // 只有当更新的位置等于当前位置时，更改颜色
        if(Fragment_FenLei.Flag_Position == position){
            holder.tvLeft.setEnabled(true);
        } else {
            holder.tvLeft.setEnabled(false);
        }

        holder.tvLeft.setText(bean.datas.class_list.get(position).gc_name);
        if(myclicklistener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myclicklistener.onItemClick(v,holder.getLayoutPosition());
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    myclicklistener.onItemLongClick(v,holder.getLayoutPosition());
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return bean.datas.class_list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public final TextView tvLeft;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvLeft = itemView.findViewById(R.id.tvLeft);

        }
    }
}
