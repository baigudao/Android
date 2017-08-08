package com.jackie.android.base.listview;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by jackie on 2017/8/8 10:03.
 * QQ : 971060378
 * Used as : ListView的通用适配器
 */
public abstract class ListViewBaseAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected ArrayList<T> mDataList;

    public ListViewBaseAdapter(Context context) {
        mContext = context;
        mDataList = new ArrayList<>();
    }

    /**
     * 设置数据集合
     *
     * @param dataList
     */
    public void setDataList(ArrayList<T> dataList) {
        mDataList = dataList;
        notifyDataSetChanged();
    }

    /**
     * 添加数据集合
     *
     * @param dataList
     */
    public void addDatas(ArrayList<T> dataList) {
        mDataList.addAll(dataList);
        notifyDataSetChanged();
    }

    /**
     * 删除某条数据
     *
     * @param data
     */
    public void removeData(T data) {
        mDataList.remove(data);
        notifyDataSetChanged();
    }

    /**
     * 根据位置删除某条数据
     *
     * @param position
     */
    public void removeData(int position) {
        mDataList.remove(position);
        notifyDataSetChanged();
    }

    /**
     * 添加一条数据
     *
     * @param data
     */
    public void addData(T data) {
        mDataList.add(data);
        notifyDataSetChanged();
    }

    /**
     * 得到数据集合
     *
     * @return
     */
    public ArrayList<T> getDatas() {
        return mDataList;
    }

    /**
     * 清除所有数据
     */
    public void clearDatas() {
        if (mDataList != null) {
            mDataList.clear();
        }
        notifyDataSetChanged();
    }

    /**
     * 是否能加载更多数据
     *
     * @return
     */
    public boolean isCanLoadMore() {
        int count = getCount();
        return (count != 0) && (count % 10 == 0);//Constant.PAGE_NUM=10
    }

    @Override
    public int getCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public T getItem(int position) {
        return mDataList == null ? null : mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
