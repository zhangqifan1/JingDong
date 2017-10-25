package com.bawei.jingdong.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.jingdong.Adapters.adapter.LeftAdapter;
import com.bawei.jingdong.Adapters.adapter.RightAdapter;
import com.bawei.jingdong.JavaBeans.LeftBean;
import com.bawei.jingdong.JavaBeans.RightBean;
import com.bawei.jingdong.NetUrls.Const;
import com.bawei.jingdong.R;
import com.bawei.jingdong.Utils.network.OkhttpUtils;
import com.bawei.jingdong.Utils.network.ResultCallback;
import com.bawei.jingdong.interfaces.Myclicklistener;
import com.squareup.okhttp.Request;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_FenLei extends Fragment  {
    private View view;
    private RecyclerView rvLeft;
    private RecyclerView rvRight;

    public static int Flag_Position;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment__fen_lei, null);
        rvLeft = view.findViewById(R.id.rvLeft);
        rvRight = view.findViewById(R.id.rvRight);
        //左边的
        RequestDataLeft();

        return view;
    }



    private void RequestDataLeft() {
        OkhttpUtils.getAsyn(Const.Left, new ResultCallback<LeftBean>() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(final LeftBean response) {
                final LeftAdapter adapter=new LeftAdapter(response,getContext());
                rvLeft.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
                rvLeft.setAdapter(adapter);
                adapter.setMyclicklistener(new Myclicklistener() {
                    @Override
                    public void onItemClick(View view, final int position) {

                        Flag_Position=position;
                        adapter.notifyDataSetChanged();
                        String s = response.datas.class_list.get(position).gc_id;
                        OkhttpUtils.getAsyn(Const.Name_id + "=" + s, new ResultCallback<RightBean>() {
                            @Override
                            public void onError(Request request, Exception e) {

                            }

                            @Override
                            public void onResponse(RightBean response) {

                                String gc_id = response.datas.class_list.get(0).gc_id;
                                //右边的
//                                RequestDataRight(gc_id);
                                RightAdapter rightAdapter = new RightAdapter(getContext(), response,gc_id);
                                rvRight.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
                                rvRight.setAdapter(rightAdapter);
                            }
                        });
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {

                    }
                });
            }
        });
    }

    private void RequestDataRight(final String id) {
        OkhttpUtils.getAsyn(Const.Name_id+"="+Flag_Position, new ResultCallback<RightBean>() {
            @Override
            public void onError(Request request, Exception e) {

            }
            @Override
            public void onResponse(RightBean response) {
                RightAdapter rightAdapter = new RightAdapter(getContext(), response,id);
                rvRight.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
                rvRight.setAdapter(rightAdapter);
            }
        });

    }
}
