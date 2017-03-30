package com.jackie.android.other.utiltest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.jackie.android.R;
import com.jackie.android.utils.ImageFilter;

/**
 * 调用 ImageFilter 的 doBlur 静态方法，即可对图片进行高斯模糊。
 * <p>
 * doBlur 接受三个参数（图片源 Bitmap，模糊半径 Integer，处理原图 Boolean）
 * <p>
 * 由于图片处理需要时间，所以必须进行异步处理（放在子线程中运行），最终将结果返回UI线程。
 * <p>
 * 提升性能：可以将图片压缩后在进行高斯模糊。
 */
public class ImageFilterTestActivity extends Activity {

    private ImageView image_view;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_filter_test);

        image_view = (ImageView) findViewById(R.id.image_view);
        //从资源中获取Bitmap
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.check);
        //异步处理
        new Thread(new Runnable() {
            @Override
            public void run() {
                //高斯模糊处理图片
                bitmap = ImageFilter.doBlur(bitmap, 30, false);
                //处理完成后返回主线程
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        image_view.setImageBitmap(bitmap);
                    }
                });
            }
        }).start();
    }
}
