package com.example.commonlib.arouter;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;


/**
 * 页面跳转管理
 */
public class ModuleUtil {

    /**
     * app
     */
    // 主界面
    public static final String PATH_APP_MAIN = "/app/MainActivity";
    // 文本
    public static final String PATH_APP_TEXT = "/app/TextActivity";
    // 图片
    public static final String PATH_APP_IMAGE = "/app/ImageActivity";

    /**
     * 业务模块A
     */
    public static final String PATH_A_ONE = "/business_a/OneActivity";


    /**
     * 业务模块B
     */
    public static final String PATH_B_TWO = "/business_b/TwoActivity";


    /**
     * App main 页面
     *
     * @param activity
     */
    public static void gotoAppMainActivity(final Activity activity) {
        ARouter.getInstance().build(PATH_APP_MAIN).navigation(activity, new NavigationCallback() {
            @Override
            public void onFound(Postcard postcard) {

            }

            @Override
            public void onLost(Postcard postcard) {

            }

            @Override
            public void onArrival(Postcard postcard) {

            }

            @Override
            public void onInterrupt(Postcard postcard) {
                showToast(activity, postcard);
            }
        });
    }

    public static void gotoAppTextActivity(final Activity activity, String value) {
        ARouter.getInstance().build(PATH_APP_TEXT).withString("arg1", value).navigation(activity, 1001, new NavigationCallback() {
            @Override
            public void onFound(Postcard postcard) {

            }

            @Override
            public void onLost(Postcard postcard) {

            }

            @Override
            public void onArrival(Postcard postcard) {

            }

            @Override
            public void onInterrupt(Postcard postcard) {
                showToast(activity, postcard);
            }
        });
    }

    public static void gotoAppImageActivity(final Activity activity, String value) {
        ARouter.getInstance().build(PATH_APP_IMAGE).withString("arg1", value).navigation(activity, new NavigationCallback() {
            @Override
            public void onFound(Postcard postcard) {

            }

            @Override
            public void onLost(Postcard postcard) {

            }

            @Override
            public void onArrival(Postcard postcard) {

            }

            @Override
            public void onInterrupt(Postcard postcard) {
                showToast(activity, postcard);
            }
        });
    }

    // ##############################A 模块####################################

    /**
     * A 模块
     *
     * @param activity
     */
    public static void gotoBusinessAOneActivity(final Activity activity) {
        ARouter.getInstance().build(PATH_A_ONE).navigation(activity, new NavigationCallback() {
            @Override
            public void onFound(Postcard postcard) {

            }

            @Override
            public void onLost(Postcard postcard) {

            }

            @Override
            public void onArrival(Postcard postcard) {

            }

            @Override
            public void onInterrupt(Postcard postcard) {
                showToast(activity, postcard);
            }
        });
    }

    // ##############################B 模块####################################

    /**
     * B 模块
     *
     * @param activity
     */
    public static void gotoBusinessBTwoActivity(final Activity activity) {
        ARouter.getInstance().build(PATH_B_TWO).navigation(activity, new NavigationCallback() {
            @Override
            public void onFound(Postcard postcard) {

            }

            @Override
            public void onLost(Postcard postcard) {

            }

            @Override
            public void onArrival(Postcard postcard) {

            }

            @Override
            public void onInterrupt(Postcard postcard) {
                showToast(activity, postcard);
            }
        });
    }


    /**
     * 显示toast 提醒
     *
     * @param activity
     * @param postcard
     */
    private static void showToast(final Activity activity, final Postcard postcard) {
        if (postcard.getTag() != null && postcard.getTag() instanceof String) {

            // 主线程显示一个提醒
            Observable.create(new Observable.OnSubscribe<String>() {
                @Override
                public void call(Subscriber<? super String> subscriber) {
                    subscriber.onNext((String) postcard.getTag());
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<String>() {
                @Override
                public void call(String s) {
                    if (!TextUtils.isEmpty(s) && activity != null) {
                        Toast.makeText(activity, (String) postcard.getTag(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
