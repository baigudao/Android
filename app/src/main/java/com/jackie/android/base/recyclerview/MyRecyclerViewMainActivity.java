package com.jackie.android.base.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jackie.android.R;
import com.jackie.android.base.recyclerview.flowview.MyRVFlowViewActivity;
import com.jackie.android.base.recyclerview.gridview.MyRVGridViewActivity;
import com.jackie.android.base.recyclerview.listview.MyRVListViewActivity;

public class MyRecyclerViewMainActivity extends Activity implements View.OnClickListener {

    private Button btn_recycler_list;
    private Button btn_recycler_grid;
    private Button btn_recycler_flow;
    private Button btn_reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recycler_view_main);

        btn_recycler_list = (Button) findViewById(R.id.btn_recycler_list);
        btn_recycler_grid = (Button) findViewById(R.id.btn_recycler_grid);
        btn_recycler_flow = (Button) findViewById(R.id.btn_recycler_flow);
        btn_reference = (Button)findViewById(R.id.btn_reference);

        btn_recycler_list.setOnClickListener(this);
        btn_recycler_grid.setOnClickListener(this);
        btn_recycler_flow.setOnClickListener(this);
        btn_reference.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_recycler_list:
                startActivity(new Intent(this,MyRVListViewActivity.class));
                break;
            case R.id.btn_recycler_grid:
                startActivity(new Intent(this,MyRVGridViewActivity.class));
                break;
            case R.id.btn_recycler_flow:
                startActivity(new Intent(this,MyRVFlowViewActivity.class));
                break;
            case R.id.btn_reference:
                startActivity(new Intent(this,RecyclerViewReferenceActivity.class));
            default:
                break;
        }
    }
}
