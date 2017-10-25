package com.bawei.jingdong.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 张祺钒
 * on2017/10/17.
 */

public class Sp {
    public static void saveToSp(Context context,String string){
        SharedPreferences sp = context.getSharedPreferences("Content", context.MODE_PRIVATE);
        sp.edit().putString("key",string).commit();
    }
}
