package com.example.arouterdemo.ui.image;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.example.arouterdemo.R;
import com.example.commonlib.arouter.ModuleUtil;


@Route(path = ModuleUtil.PATH_APP_IMAGE)
public class ImageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        String url = getIntent().getStringExtra("arg1");
        if (!TextUtils.isEmpty(url)) {
            Glide.with(this).load(url).into(((ImageView) findViewById(R.id.imageView)));
        }
    }
}
