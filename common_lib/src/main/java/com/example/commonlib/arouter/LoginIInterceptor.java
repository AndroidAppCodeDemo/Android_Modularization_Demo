package com.example.commonlib.arouter;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

import java.util.Random;


@Interceptor(priority = 1, name = "拦截未登录")
public class LoginIInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if (postcard.getExtra() == IInterceptorConstant.CHECK_LOGIN && !checkLoading()) {
            callback.onInterrupt(new RuntimeException("账号未登录"));
        } else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {

    }


    public boolean checkLoading() {
        return new Random().nextBoolean();
    }
}
