package com.jackie.android;

import android.app.Application;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.MemoryCategory;

/**
 * Created by jackie on 2017/7/31 21:31.
 * QQ : 971060378
 * Used as : 应用的入口
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化Android工具库
        Utils.init(this);

        //动态设置内存缓存size
        Glide.get(this).setMemoryCategory(MemoryCategory.HIGH);

        //对LogUtils的配置
        configLogUtils();
    }

    private void configLogUtils() {
        LogUtils.Builder lBuilder = new LogUtils.Builder()
                .setLogSwitch(BuildConfig.DEBUG)// 设置log总开关，默认开
                .setGlobalTag("数据>>>")// 设置log全局标签，默认为空
                // 当全局标签不为空时，我们输出的log全部为该tag，
                // 为空时，如果传入的tag为空那就显示类名，否则显示tag
                .setLog2FileSwitch(false)// 打印log时是否存到文件的开关，默认关
                .setBorderSwitch(false)// 输出日志是否带边框开关，默认开
                .setFileFilter(LogUtils.E);// log过滤器，和logcat过滤器同理，默认Verbose
    }
}
