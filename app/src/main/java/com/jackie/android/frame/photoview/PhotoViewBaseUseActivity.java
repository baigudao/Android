package com.jackie.android.frame.photoview;

import android.app.Activity;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.OnMatrixChangedListener;
import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.OnSingleFlingListener;
import com.github.chrisbanes.photoview.PhotoView;
import com.jackie.android.R;
//android-floating-action-button开源库中实现控制
public class PhotoViewBaseUseActivity extends Activity {

    private TextView tv_title;
    private TextView tv_current_matrix;
    private PhotoView iv_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        usePhotoView();
    }

    private void usePhotoView() {

        //加载本地图片
//        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.check);
//        iv_photo.setImageDrawable(drawable);

        //加载网络图片
        Glide.with(this)
                .load("http://img3.imgtn.bdimg.com/it/u=1433975681,3113464827&fm=214&gp=0.jpg")
                .into(iv_photo);

        //根据实际业务中的需要，设置相应的监听
        //设置图片缩放大小改变的监听
        iv_photo.setOnMatrixChangeListener(new MatrixChangeListener());
        //设置图片上的点击监听
        iv_photo.setOnPhotoTapListener(new PhotoTapListener());
        //设置图片的滑动监听，具体是监听什么，我也没亲测
        iv_photo.setOnSingleFlingListener(new SingleFlingListener());
    }

    private class SingleFlingListener implements OnSingleFlingListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.d("PhotoView", "velocityX=" + velocityX + ", velocityY=" + velocityY);
            return true;
        }
    }

    private void initView() {
        setContentView(R.layout.activity_photo_view_base_use);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("基本用法");
        iv_photo = (PhotoView) findViewById(R.id.iv_photo);
        tv_current_matrix = (TextView) findViewById(R.id.tv_current_matrix);
    }

    private class PhotoTapListener implements OnPhotoTapListener {
        @Override
        public void onPhotoTap(ImageView view, float x, float y) {
            float xPercentage = x * 100f;
            float yPercentage = y * 100f;
            Toast.makeText(PhotoViewBaseUseActivity.this, "图片上点击的位置：" + "x=" + xPercentage + ", y= " + yPercentage + "\n" + "点击的ID：" + (view == null ? 0 : view.getId()), Toast.LENGTH_SHORT).show();
        }
    }

    private class MatrixChangeListener implements OnMatrixChangedListener {
        @Override
        public void onMatrixChanged(RectF rect) {
            tv_current_matrix.setText("图片大小：" + rect.toString());
        }
    }
}
