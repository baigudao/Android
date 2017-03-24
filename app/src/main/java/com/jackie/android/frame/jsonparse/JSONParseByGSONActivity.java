package com.jackie.android.frame.jsonparse;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jackie.android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 记住关键字：“from”，“to“
 */
public class JSONParseByGSONActivity extends Activity implements View.OnClickListener {

    private TextView tv_title;
    private Button btn_gson_to_java_object;
    private Button btn_gson_to_java_list;
    private Button btn_gson_java_to_json_object;
    private Button btn_gson_java_to_json_array;
    private TextView tv_gson;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();
    }

    private void initListener() {
        btn_gson_to_java_object.setOnClickListener(this);
        btn_gson_to_java_list.setOnClickListener(this);
        btn_gson_java_to_json_object.setOnClickListener(this);
        btn_gson_java_to_json_array.setOnClickListener(this);
    }

    private void initView() {
        setContentView(R.layout.activity_jsonparse_by_gson);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("GSON解析");
        btn_gson_to_java_object = (Button) findViewById(R.id.btn_gson_to_java_object);
        btn_gson_to_java_list = (Button) findViewById(R.id.btn_gson_to_java_list);
        btn_gson_java_to_json_object = (Button) findViewById(R.id.btn_gson_java_to_json_object);
        btn_gson_java_to_json_array = (Button) findViewById(R.id.btn_gson_java_to_json_array);
        tv_gson = (TextView) findViewById(R.id.tv_gson);
        tv_result = (TextView) findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_gson_to_java_object:
                jsonToJavaObjectByGson();
                break;
            case R.id.btn_gson_to_java_list:
                jsonToJavaListByGson();
                break;
            case R.id.btn_gson_java_to_json_object:
                javaToJsonObjectByGson();
                break;
            case R.id.btn_gson_java_to_json_array:
                javaListToJsonArrayByGson();
                break;
            default:
                break;
        }
    }

    /**
     * 将Java集合转换成json数组
     */
    private void javaListToJsonArrayByGson() {
        List<ShopInfo> shopInfos = new ArrayList<>();
        ShopInfo shopInfo = new ShopInfo(8, "大鱼", 441.4, "http:slfs.jpg");
        ShopInfo shopInfo1 = new ShopInfo(9, "小鱼", 21.2, "www.baidu.com");
        shopInfos.add(shopInfo);
        shopInfos.add(shopInfo1);
        Gson gson = new Gson();
        String s = gson.toJson(shopInfos);
        tv_gson.setText(shopInfos.toString());
        tv_result.setText(s);
    }

    /**
     * 将Java对象转换成json对象
     */
    private void javaToJsonObjectByGson() {
        ShopInfo shopInfo = new ShopInfo(3, "鱼翅", 88.3, "http:xxx.jpg");
        Gson gson = new Gson();
        String s = gson.toJson(shopInfo);
        tv_gson.setText(shopInfo.toString());
        tv_result.setText(s);
    }

    /**
     * 将json数组解析成Java集合
     */
    private void jsonToJavaListByGson() {
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
        Gson gson = new Gson();
        List<ShopInfo> shopInfos = gson.fromJson(json, new TypeToken<List<ShopInfo>>() {
        }.getType());
        tv_gson.setText(json);
        tv_result.setText(shopInfos.toString());
    }

    /**
     * 将json对象解析成Java对象
     */
    private void jsonToJavaObjectByGson() {
        String json = "{\n" +
                "\t\"id\":2, \"name\":\"大虾\", \n" +
                "\t\"price\":12.3, \n" +
                "\t\"imagePath\":\"http://192.168.10.165:8080/L05_Server/images/f1.jpg\"\n" +
                "}\n";
        Gson gson = new Gson();
        ShopInfo shopInfo = gson.fromJson(json, ShopInfo.class);
        tv_gson.setText(json);
        tv_result.setText(shopInfo.toString());
    }
}
