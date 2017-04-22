package com.tyh.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 17.3.15.
 */

public class BaseActivity extends AppCompatActivity {
    protected BaseApplication mBaseApp;
    protected Context mAppContext;//全局上下文对象

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBaseApp = (BaseApplication) getApplication();
        mAppContext = getApplicationContext();


    }
}
