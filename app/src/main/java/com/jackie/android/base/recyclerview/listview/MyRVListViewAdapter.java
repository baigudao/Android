package com.jackie.android.base.recyclerview.listview;

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

    public MyRVListViewAdapter(Context context, List<String> strings) {//第一步，先调用这个构造方法
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
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//第三步
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
    public void onBindViewHolder(MyViewHolder holder, int position) {//第五步，最后一步。
        //先根据位置得到数据，再设置item的数据
        holder.tv_list_item.setText(strings.get(position));
    }

    /**
     * 得到数据的总条数
     *
     * @return
     */
    @Override
    public int getItemCount() {//第二步
        return strings.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_list_item;

        public MyViewHolder(final View itemView) {//第四步
            super(itemView);
            tv_list_item = (TextView) itemView.findViewById(R.id.tv_list_item);

            // 如果设置了回调，则设置点击事件
            if (onItemClickListener != null) {

                itemView.setOnClickListener(new View.OnClickListener() {//点击之后，最先触发这个方法的监听。
                    @Override
                    public void onClick(View v) {
                        int position = getLayoutPosition();
                        onItemClickListener.onItemClick(itemView, position);//然后调用这个方法。这个onItemClick()方法可以理解成Activity中的同名匿名方法。
                    }
                });

                itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        int position = getLayoutPosition();
                        onItemClickListener.onItemLongClick(itemView, position);
                        return false;
                    }
                });
            }
        }
    }

    /**
     * 接口回调三部曲
     * 1，定义接口
     * 2，声明接口变量
     * 3，Setter接口变量
     */
    public interface OnItemClickListener {

        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {//还没点击之前，就先调用这个方法，把OnItemClickListener对象传过来
        this.onItemClickListener = onItemClickListener;
    }
}
