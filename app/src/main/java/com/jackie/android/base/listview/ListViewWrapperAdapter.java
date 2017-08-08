package com.jackie.android.base.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jackie.android.R;
import com.jackie.android.bean.FuLiImageBean;

/**
 * Created by jackie on 2017/8/8 10:17.
 * QQ : 971060378
 * Used as : xxx
 */
public class ListViewWrapperAdapter extends ListViewBaseAdapter<FuLiImageBean.ResultsBean> {


    public ListViewWrapperAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ListViewWrapperAdapter.ViewHolder viewHolder = null;
        if (view == null) {
            //第一次加载布局
            view = LayoutInflater.from(mContext).inflate(R.layout.activity_list_view_base_use_item, null);
            viewHolder = new ListViewWrapperAdapter.ViewHolder();
            viewHolder.iv_item = (ImageView) view.findViewById(R.id.iv_item);
            viewHolder.tv_who = (TextView) view.findViewById(R.id.tv_who);
            viewHolder.tv_desc = (TextView) view.findViewById(R.id.tv_desc);
            //绑定viewHolder
            view.setTag(viewHolder);
        } else {
            viewHolder = (ListViewWrapperAdapter.ViewHolder) view.getTag();
        }

        FuLiImageBean.ResultsBean resultsBean = mDataList.get(i);

        Glide.with(mContext)
                .load(resultsBean.getUrl())
                .into(viewHolder.iv_item);
        viewHolder.tv_who.setText(resultsBean.getWho());
        viewHolder.tv_desc.setText(resultsBean.getDesc());
        return view;
    }

    private class ViewHolder {
        private ImageView iv_item;
        private TextView tv_who;
        private TextView tv_desc;
    }
}
