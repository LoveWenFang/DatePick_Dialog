package com.tyh.base;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

/**
 * Created by Administrator on 17.3.11.
 */

public class DialogTools extends Dialog {
    private Context mContext;
    private View view;
    private LayoutInflater mInflater;


    public DialogTools(Context context, int themeResId) {
        super(context, themeResId);
        mContext = context;
        Window window = this.getWindow();
        window.setGravity(Gravity.CENTER);
        window.setLayout(500, 200);
    }

    /**
     * 对话框的显示方法
     */
    public void showDialog() {
        //设置显示的自定义布局
        this.setContentView(view);
        //设置点击对话框之外取消对话框
        this.setCanceledOnTouchOutside(true);
        //显示对话框
        this.show();
    }

    /**
     * 设置自定义布局
     * @param mLayout
     * @return
     */
    public View setLayout(int mLayout) {
        mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(mLayout, null);
        return view;
    }


}
