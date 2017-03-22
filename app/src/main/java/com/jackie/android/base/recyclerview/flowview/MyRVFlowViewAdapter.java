package com.jackie.android.base.recyclerview.flowview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jackie.android.R;

import java.util.List;

/**
 * Created by jackie on 2017/3/22 9:56.
 * QQ : 971060378
 * Used as : xxx
 */
public class MyRVFlowViewAdapter extends RecyclerView.Adapter<MyRVFlowViewAdapter.ViewHolder> {

    private Context context;
    private List<String> strings;


    public MyRVFlowViewAdapter(Context context, List<String> strings) {
        this.context = context;
        this.strings = strings;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(context, R.layout.activity_item_rv_flow, null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_flow_item.setText(strings.get(position));
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_flow_item;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_flow_item = (TextView) itemView.findViewById(R.id.tv_flow_item);
        }
    }
}
