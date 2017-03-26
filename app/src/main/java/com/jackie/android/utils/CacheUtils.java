package com.jackie.android.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jackie on 2017/3/26 15:08.
 * QQ : 971060378
 * Used as : 缓存软件的一些参数和数据
 */

public class CacheUtils {

    /**
     * 得到缓存值
     *
     * @param context 上下文
     * @param key
     * @return
     */
    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences("jackie", Context.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

    /**
     * 保存软件参数
     *
     * @param context
     * @param key
     * @param value
     */
    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences("jackie", Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).apply();
    }

}
