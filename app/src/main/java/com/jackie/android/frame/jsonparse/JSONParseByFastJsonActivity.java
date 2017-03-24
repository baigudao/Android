package com.jackie.android.frame.jsonparse;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jackie.android.R;

import java.util.ArrayList;
import java.util.List;

public class JSONParseByFastJsonActivity extends Activity implements View.OnClickListener {

    private TextView tv_title;
    private Button btn_fastjson_to_java_object;
    private Button btn_fastjson_to_java_list;
    private Button btn_fastjson_java_to_json_object;
    private Button btn_fastjson_java_list_to_json_array;
    private TextView tv_fastjson;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();
    }

    private void initListener() {
        btn_fastjson_to_java_object.setOnClickListener(this);
        btn_fastjson_to_java_list.setOnClickListener(this);
        btn_fastjson_java_to_json_object.setOnClickListener(this);
        btn_fastjson_java_list_to_json_array.setOnClickListener(this);
    }

    private void initView() {
        setContentView(R.layout.activity_jsonparse_by_fast_json);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("FastJson解析");
        btn_fastjson_to_java_object = (Button) findViewById(R.id.btn_fastjson_to_java_object);
        btn_fastjson_to_java_list = (Button) findViewById(R.id.btn_fastjson_to_java_list);
        btn_fastjson_java_to_json_object = (Button) findViewById(R.id.btn_fastjson_java_to_json_object);
        btn_fastjson_java_list_to_json_array = (Button) findViewById(R.id.btn_fastjson_java_list_to_json_array);
        tv_fastjson = (TextView) findViewById(R.id.tv_fastjson);
        tv_result = (TextView) findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_fastjson_to_java_object:
                jsonToJavaObjectByFastJson();
                break;
            case R.id.btn_fastjson_to_java_list:
                jsonToJavaListByFastJson();
                break;
            case R.id.btn_fastjson_java_to_json_object:
                javaToJsonObjectByFastJson();
                break;
            case R.id.btn_fastjson_java_list_to_json_array:
                javaToJsonArrayByFastJson();
                break;
            default:
                break;
        }
    }

    /**
     * 将Java集合转换成json数组
     */
    private void javaToJsonArrayByFastJson() {
        List<ShopInfo> shopInfos = new ArrayList<>();
        ShopInfo shopInfo = new ShopInfo(8, "大鱼", 441.4, "http:slfs.jpg");
        ShopInfo shopInfo1 = new ShopInfo(9, "小鱼", 21.2, "www.baidu.com");
        shopInfos.add(shopInfo);
        shopInfos.add(shopInfo1);
        String string = JSON.toJSONString(shopInfos);
        tv_fastjson.setText(shopInfos.toString());
        tv_result.setText(string);
    }

    /**
     * 将java对象转换成json对象
     */
    private void javaToJsonObjectByFastJson() {
        ShopInfo shopInfo = new ShopInfo(5, "海带", 12.3, "http://alds.jpg");
        String string = JSON.toJSONString(shopInfo);
        tv_fastjson.setText(shopInfo.toString());
        tv_result.setText(string);
    }

    /**
     * 将json数组转换成Java集合
     */
    private void jsonToJavaListByFastJson() {
        String json = "[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"imagePath\": \"http://192.168.10.165:8080/f1.jpg\",\n" +
                "        \"name\": \"大虾1\",\n" +
                "        \"price\": 12.3\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"imagePath\": \"http://192.168.10.165:8080/f2.jpg\",\n" +
                "        \"name\": \"大虾2\",\n" +
                "        \"price\": 12.5\n" +
                "    }\n" +
                "]";
        List<ShopInfo> shopInfos = JSON.parseArray(json, ShopInfo.class);
        tv_fastjson.setText(json);
        tv_result.setText(shopInfos.toString());
    }

    /**
     * 将json对象转换成Java对象
     */
    private void jsonToJavaObjectByFastJson() {
        String json = "{\n" +
                "\t\"id\":2, \"name\":\"大虾\", \n" +
                "\t\"price\":12.3, \n" +
                "\t\"imagePath\":\"http://192.168.10.165:8080/L05_Server/images/f1.jpg\"\n" +
                "}\n";
        ShopInfo shopInfo = JSON.parseObject(json, ShopInfo.class);
        tv_fastjson.setText(json);
        tv_result.setText(shopInfo.toString());
    }
}
