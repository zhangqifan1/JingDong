package com.bawei.jingdong.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by 张祺钒
 * on2017/10/11.
 */

public  class fragmentReplace {
    public static void replace(FragmentActivity activity, int LayoutId, Fragment fragment){
        FragmentTransaction transaction =
                activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(LayoutId,fragment).show(fragment).commit();
    }
}


