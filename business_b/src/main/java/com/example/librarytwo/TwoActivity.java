package com.example.librarytwo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlib.arouter.ModuleUtil;


@Route(path = ModuleUtil.PATH_B_TWO)
public class TwoActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_activity);
        //
        findViewById(R.id.gotoAppMainActivity).setOnClickListener(this);
        findViewById(R.id.gotoBusinessAOneActivity).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.gotoAppMainActivity) {
            ModuleUtil.gotoAppMainActivity(this);

        } else if (i == R.id.gotoBusinessAOneActivity) {
            ModuleUtil.gotoBusinessAOneActivity(this);
        }
    }
}
