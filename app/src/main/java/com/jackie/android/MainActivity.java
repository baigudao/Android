package com.jackie.android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jackie.android.base.BaseAndroidFragment;
import com.jackie.android.frame.CommonFrameFragment;
import com.jackie.android.other.OtherFragment;
import com.jackie.android.senior.SeniorAndroidFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {//这里注意：是继承自FragmentActivity

    private TextView tv_title;

    private RadioGroup mRg_main;
    /**
     * 装Fragment的集合
     */
    private List<BaseFragment> mBaseFragment;

    /**
     * 选中Fragment对应的位置
     */
    private int position;

    /**
     * 上次的Fragment
     */
    private Fragment fromFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化View
        initView();
        //初始化Fragment
        initFragment();
        //设置RadioGroup的监听
        setListener();
    }

    private void setListener() {
        mRg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        //设置默认选中常用框架
        mRg_main.check(R.id.rb_base_android);
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_base_android://Android基础
                    position = 0;
                    tv_title.setText("Android基础");
                    break;
                case R.id.rb_senior_android://Android高级
                    position = 1;
                    tv_title.setText("Android高级");
                    break;
                case R.id.rb_common_frame://常用框架
                    position = 2;
                    tv_title.setText("常用框架");
                    break;
                case R.id.rb_other://其他
                    position = 3;
                    tv_title.setText("其他");
                    break;
                default:
                    position = 0;
                    tv_title.setText("Android基础");
                    break;
            }
            //根据位置得到对应的Fragment
            BaseFragment toFragment = getFragment();
            //切换Fragment
            switchFragment(fromFragment, toFragment);
        }
    }


    /**
     * @param from 刚显示的Fragment,马上就要被隐藏了
     * @param to   马上要切换到的Fragment，一会要显示
     */
    private void switchFragment(Fragment from, Fragment to) {
        if (from != to) {
            fromFragment = to;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //才切换
            //判断有没有被添加
            if (!to.isAdded()) {
                //to没有被添加
                //from隐藏
                if (from != null) {
                    ft.hide(from);
                }
                //添加to
                ft.add(R.id.fl_content, to).commit();
            } else {
                //to已经被添加
                // from隐藏
                if (from != null) {
                    ft.hide(from);
                }
                //显示to
                ft.show(to).commit();
            }
        }
    }

    /**
     * 根据位置得到对应的Fragment
     *
     * @return
     */
    private BaseFragment getFragment() {
        BaseFragment fragment = mBaseFragment.get(position);
        return fragment;
    }

    private void initFragment() {
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add(new BaseAndroidFragment());//Android基础Fragment
        mBaseFragment.add(new SeniorAndroidFragment());//Android高级Fragment
        mBaseFragment.add(new CommonFrameFragment());//常用框架Fragment
        mBaseFragment.add(new OtherFragment());//其他Fragment
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        tv_title = (TextView)findViewById(R.id.tv_title);
        mRg_main = (RadioGroup) findViewById(R.id.rg_main);
    }
}