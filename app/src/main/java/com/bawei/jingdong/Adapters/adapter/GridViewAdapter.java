package com.bawei.jingdong.Adapters.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.jingdong.JavaBeans.RightBean;
import com.bawei.jingdong.R;
import com.bawei.jingdong.Utils.GlideUtils;

/**
 * Created by 张祺钒
 * on2017/10/17.
 */

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private RightBean bean;

    public GridViewAdapter(Context context, RightBean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public int getCount() {
        return bean.datas.class_list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(context, R.layout.griditem,null);
            holder.imageView=convertView.findViewById(R.id.image_grid_item);
            holder.textView=convertView.findViewById(R.id.tv_grid_item);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        RightBean.DatasBean.ClassListBean classListBean = bean.datas.class_list.get(position);
//        ImageLoaderUtils.setImageView(classListBean.image,context,holder.imageView);
        GlideUtils.loadImageView(context,classListBean.image,holder.imageView);
        holder.textView.setText(classListBean.gc_name);

        return convertView;
    }
    static  class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
