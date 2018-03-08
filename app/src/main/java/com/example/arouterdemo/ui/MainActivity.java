package com.example.arouterdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.arouterdemo.R;
import com.example.commonlib.arouter.ModuleUtil;

@Route(path = ModuleUtil.PATH_APP_MAIN)
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.gotoAppTextActivity).setOnClickListener(this);
        findViewById(R.id.gotoAppImageActivity).setOnClickListener(this);
        findViewById(R.id.gotoBussinessAoneActivity).setOnClickListener(this);
        findViewById(R.id.gotoBussinessBtwoActivity).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gotoAppTextActivity:
                ModuleUtil.gotoAppTextActivity(this, "测试文本");
                break;
            case R.id.gotoAppImageActivity:
                ModuleUtil.gotoAppImageActivity(this, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492584424522&di=5dcde77431914e0b944b8af9ff5f9277&imgtype=jpg&src=http%3A%2F%2Fimg3.imgtn.bdimg.com%2Fit%2Fu%3D1489971249%2C1618541505%26fm%3D214%26gp%3D0.jpg");
                break;
            case R.id.gotoBussinessAoneActivity:
                ModuleUtil.gotoBusinessAOneActivity(this);
                break;
            case R.id.gotoBussinessBtwoActivity:
                ModuleUtil.gotoBusinessBTwoActivity(this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1002) {
            Toast.makeText(this, data.getStringExtra("arg2"), Toast.LENGTH_SHORT).show();
        }
    }
}
