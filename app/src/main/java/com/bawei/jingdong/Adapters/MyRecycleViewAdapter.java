package com.bawei.jingdong.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.jingdong.R;
import com.bawei.jingdong.Utils.GlideImageLoader;
import com.bawei.jingdong.interfaces.Myclicklistener;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder> {
    private List<String> list=new ArrayList<>();
    private Context context;
    private View view;
    private List<Integer> listImages=new ArrayList<>();
    public Myclicklistener onClickListener;
    public MyRecycleViewAdapter(Context context) {
        this.context = context;
        for (int i = 0; i < 20; i++) {
            if (i  % 3 ==0) {
                list.add("京东购物商城");
            } else if (i  % 3 == 1) {
                list.add("京西购物商城");
            } else if (i  % 3 == 2) {
                list.add("京南购物商城");
            } else {
                list.add("京北购物商城");
            }

        }

        listImages.add(R.drawable.xigua);
        listImages.add(R.drawable.xigua);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if(viewType==Type){
            view = View.inflate(context, R.layout.headeriew, null);
            return new MyViewHolder(view);
        }
        else if (viewType == Type0) {
            view = View.inflate(context, R.layout.item, null);
            return new MyViewHolder(view);
        } else if (viewType == Type1) {
            view = View.inflate(context, R.layout.item1, null);
            return new MyViewHolder(view);
        } else {
            view = View.inflate(context, R.layout.item2, null);
            return new MyViewHolder(view);
        }
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        int type = getItemViewType(position);
        switch (type) {
            case Type:
                holder.banner.setImageLoader(new GlideImageLoader())
//                        .isAutoPlay(false)
                        .setDelayTime(3000)
                        .setImages(listImages)
                        .start();
                break;
            case Type0:
                holder.tv_title.setText(list.get(position));
                break;
            case Type1:
                holder.tv1.setText(list.get(position));
                holder.tv2.setText(list.get((position + 2)%list.size()));
                break;
            case Type2:
                holder.image1.setImageResource(R.drawable.ma);
                holder.image2.setImageResource(R.drawable.e);
                break;
            default:
                break;
        }
;
        holder.itemView.setTag(position);
    }

    public final int Type = 212;
    public final int Type0 = 1;
    public final int Type1 = 2;
    public final int Type2 = 3;

    @Override
    public int getItemViewType(int position) {

        if (position==0) {
            return Type;
        } else if (position % 3 == 0) {
            return Type0;
        } else if (position % 3 == 1) {
            return Type1;
        } else {
            return Type2;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv_icon;
        private final TextView tv_title;
        private final ImageView image1;
        private final ImageView image2;
        private final TextView tv1;
        private final TextView tv2;
        private final Banner banner;

        public MyViewHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
            iv_icon = itemView.findViewById(R.id.iv_icon);
            tv_title = itemView.findViewById(R.id.tv_title);
            image1 = itemView.findViewById(R.id.image1);
            image2 = itemView.findViewById(R.id.image2);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }


}