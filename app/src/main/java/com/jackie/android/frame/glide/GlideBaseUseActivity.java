package com.jackie.android.frame.glide;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.jackie.android.R;

import java.io.File;

public class GlideBaseUseActivity extends Activity {

    private TextView tv_title;
    private TextView tvGlide1;
    private ImageView ivGlide1;
    private TextView tvGlide2;
    private ImageView ivGlide2;
    private TextView tvGlide3;
    private ImageView ivGlide3;
    private TextView tvGlide4;
    private ImageView ivGlide4;
    private TextView tvGlide5;
    private ImageView ivGlide5;
    private TextView tvGlide6;
    private ImageView ivGlide6;
    private TextView tvGlide7;
    private ImageView ivGlide7;
    private TextView tvGlide8;
    private ImageView ivGlide8;
    private TextView tvGlide9;
    private ImageView ivGlide9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        setContentView(R.layout.activity_glide_base_use);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tvGlide1 = (TextView) findViewById(R.id.tv_glide_1);
        ivGlide1 = (ImageView) findViewById(R.id.iv_glide_1);
        tvGlide2 = (TextView) findViewById(R.id.tv_glide_2);
        ivGlide2 = (ImageView) findViewById(R.id.iv_glide_2);
        tvGlide3 = (TextView) findViewById(R.id.tv_glide_3);
        ivGlide3 = (ImageView) findViewById(R.id.iv_glide_3);
        tvGlide4 = (TextView) findViewById(R.id.tv_glide_4);
        ivGlide4 = (ImageView) findViewById(R.id.iv_glide_4);
        tvGlide5 = (TextView) findViewById(R.id.tv_glide_5);
        ivGlide5 = (ImageView) findViewById(R.id.iv_glide_5);
        tvGlide6 = (TextView) findViewById(R.id.tv_glide_6);
        ivGlide6 = (ImageView) findViewById(R.id.iv_glide_6);
        tvGlide7 = (TextView) findViewById(R.id.tv_glide_7);
        ivGlide7 = (ImageView) findViewById(R.id.iv_glide_7);
        tvGlide8 = (TextView) findViewById(R.id.tv_glide_8);
        ivGlide8 = (ImageView) findViewById(R.id.iv_glide_8);
        tvGlide9 = (TextView) findViewById(R.id.tv_glide_9);
        ivGlide9 = (ImageView) findViewById(R.id.iv_glide_9);
    }

    private void initData() {
        tv_title.setText(R.string.glide_base_use);

        //（1）加载网络图片
        tvGlide1.setText("（1）加载网络图片");
        Glide.with(this)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490333262397&di=a3ef72a77093e431b4205c3b5573f9c8&imgtype=0&src=http%3A%2F%2Fimg.chyxx.com%2F2015%2F09%2F20150924095400mm_m.png")
                .into(ivGlide1);

        //（2）加载资源图片
        tvGlide2.setText("（2）加载资源图片");
        Glide.with(this)
                .load(R.drawable.jackie_chen)
                .into(ivGlide2);

        //（3）加载本地图片
        tvGlide3.setText("（3）加载本地图片");
        String path = Environment.getExternalStorageDirectory() + "/1107210100346.png";
        File file = new File(path);
        Uri uri = Uri.fromFile(file);
        Glide.with(this)
                .load(uri)
                .placeholder(R.drawable.my_default)//占位符
                .into(ivGlide3);

        // （4）加载网络gif
        tvGlide4.setText("（4）加载网络gif");
        String gifUrl = "http://n1.itc.cn/img8/wb/smccloud/2015/03/22/142701680733350964.GIF";
        Glide.with(this)
                .load(gifUrl)
                .placeholder(R.drawable.my_default)
                .into(ivGlide4);

        // （5）加载资源gif
        tvGlide5.setText("（5）加载资源gif");
        Glide.with(this)
                .load(R.drawable.qiushuzhen)
                .asGif()
                .placeholder(R.drawable.my_default)
                .into(ivGlide5);

        //（6）加载本地gif
        tvGlide6.setText("（6）加载本地gif");
        String gifPath = Environment.getExternalStorageDirectory() + "/mei.jpg";
        File gifFile = new File(gifPath);
        Glide.with(this)
                .load(gifFile)
                .placeholder(R.drawable.my_default)
                .into(ivGlide6);

        //（7）加载本地小视频和快照
        tvGlide7.setText("（7）加载本地小视频和快照");
        String videoPath = Environment.getExternalStorageDirectory() + "/480.mp4";
        File videoFile = new File(videoPath);
        Glide.with(this)
                .load(Uri.fromFile(videoFile))
                .placeholder(R.drawable.my_default)
                .into(ivGlide7);

        //（8）设置缩略图比例,然后，先加载缩略图，再加载原图
        tvGlide8.setText("（8）设置缩略图比例,然后，先加载缩略图，再加载原图");
        Glide.with(this)
                .load("http://upload.morningpost.com.cn/2015/0312/1426174184343.jpg")
                .thumbnail(0.1f)//设置缩略图
                .centerCrop()
                .placeholder(R.drawable.my_default)
                .into(ivGlide8);

        //（9）先建立一个缩略图对象，然后，先加载缩略图，再加载原图
        tvGlide9.setText("（9）先建立一个缩略图对象，然后，先加载缩略图，再加载原图");
        DrawableRequestBuilder thumbnailRequest = Glide.with(this).load("http://upload.morningpost.com.cn/2015/0312/1426174184343.jpg");
        Glide.with(this)
                .load("http://cdn.duitang.com/uploads/blog/201601/06/20160106212247_cNUjY.jpeg")
                .thumbnail(thumbnailRequest)
                .centerCrop()
                .placeholder(R.drawable.my_default)
                .into(ivGlide9);
    }
}
