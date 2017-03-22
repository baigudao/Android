package com.jackie.android.base.recyclerview.gridview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jackie.android.R;

import java.util.List;

/**
 * Created by jackie on 2017/3/22 9:17.
 * QQ : 971060378
 * Used as : xxx
 */
public class MyRVGridViewAdapter extends RecyclerView.Adapter<MyRVGridViewAdapter.ViewHolder> {

    private Context context;
    private List<String> strings;

    public MyRVGridViewAdapter(Context context, List<String> strings) {//第一步，先调用这个构造方法
        this.context = context;
        this.strings = strings;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//第三步
        View itemView = View.inflate(context, R.layout.activity_item_rv_grid, null);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {//第五步，最后一步。
        holder.tv_grid_item.setText(strings.get(position));
    }

    @Override
    public int getItemCount() {//第二步
        return strings.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_grid_item;

        public ViewHolder(View itemView) {//第四步
            super(itemView);
            //初始化itemView中的TextView
            tv_grid_item = (TextView) itemView.findViewById(R.id.tv_grid_item);
        }
    }
}
