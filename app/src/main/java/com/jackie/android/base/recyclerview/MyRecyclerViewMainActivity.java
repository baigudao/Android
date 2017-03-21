package com.jackie.android.base.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jackie.android.R;

public class MyRecyclerViewMainActivity extends Activity implements View.OnClickListener {

    private Button btn_recycler_list;
    private Button btn_recycler_grid;
    private Button btn_recycler_flow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recycler_view_main);

        btn_recycler_list = (Button) findViewById(R.id.btn_recycler_list);
        btn_recycler_grid = (Button) findViewById(R.id.btn_recycler_grid);
        btn_recycler_flow = (Button) findViewById(R.id.btn_recycler_flow);

        btn_recycler_list.setOnClickListener(this);
        btn_recycler_grid.setOnClickListener(this);
        btn_recycler_flow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_recycler_list:
                Toast.makeText(this, "list", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,MyRVListViewActivity.class));
                break;
            case R.id.btn_recycler_grid:
                Toast.makeText(this, "grid", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_recycler_flow:
                Toast.makeText(this, "flow", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
