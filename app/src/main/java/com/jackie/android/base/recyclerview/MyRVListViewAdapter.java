package com.jackie.android.base.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jackie.android.R;

import java.util.List;

/**
 * Created by jackie on 2017/3/21 23:00.
 * QQ : 971060378
 * Used as : xxx
 */

public class MyRVListViewAdapter extends RecyclerView.Adapter<MyRVListViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<String> strings;

    public MyRVListViewAdapter(Context context, List<String> strings) {
        mContext = context;
        this.strings = strings;
    }

    /**
     * 渲染数据。相当于ListView中adapter的getView()和ViewHolder。
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.activity_item_rv_list, null);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return myViewHolder;
    }

    /**
     * 绑定数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //先根据位置得到数据，再设置item的数据
        holder.tv_list_item.setText(strings.get(position));
    }

    /**
     * 得到数据的总条数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return strings.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_list_item;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_list_item = (TextView) itemView.findViewById(R.id.tv_list_item);
        }
    }
}
