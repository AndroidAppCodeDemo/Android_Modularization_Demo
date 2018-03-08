package com.example.libraryone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlib.arouter.IInterceptorConstant;
import com.example.commonlib.arouter.ModuleUtil;


@Route(path = ModuleUtil.PATH_A_ONE, extras = IInterceptorConstant.CHECK_LOGIN)
public class OneActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_activity);
        findViewById(R.id.gotoAppMainActivity).setOnClickListener(this);
        findViewById(R.id.gotoBusinessBTwoActivity).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.gotoAppMainActivity) {
            ModuleUtil.gotoAppMainActivity(this);

        } else if (i == R.id.gotoBusinessBTwoActivity) {
            ModuleUtil.gotoBusinessBTwoActivity(this);
        }
    }
}
