package com.jackie.android.frame.photoview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;
import com.jackie.android.R;

public class PhotoViewViewPagerActivity extends Activity {

    private ViewPager view_pager;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view_view_pager);

        view_pager = (ViewPager) findViewById(R.id.view_pager);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("在ViewPager中的使用");

        view_pager.setAdapter(new SamplePagerAdapter());
    }


    class SamplePagerAdapter extends PagerAdapter {

        private int[] sDrawables = {R.drawable.jackie_chen, R.drawable.jackie_chen, R.drawable.jackie_chen,
                R.drawable.jackie_chen, R.drawable.jackie_chen, R.drawable.jackie_chen};

        @Override
        public int getCount() {
            return sDrawables.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //开始使用PhotoView
            PhotoView photoView = new PhotoView(container.getContext());
            photoView.setImageResource(sDrawables[position]);

            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            return photoView;
        }
    }
}
