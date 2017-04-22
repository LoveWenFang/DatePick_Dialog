package com.tyh.dialog;

import android.content.Context;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tyh.base.DialogTools;
import com.tyh.datepick_dialog.R;


/**
 * 自定义的对话提示框
 */

public class Dialog_Alert implements View.OnClickListener {
    private Context mContext;
    private int mthemeId;
    private DialogTools dialogTools;

    private TextView mDialogAlertContentTV;
    private Button mDialogAlertSure;
    private Button mDialogAlertCancel;

    public Dialog_Alert(Context mContext) {
        this(mContext, R.style.Custom_AlertDialog_Theme);
    }

    public Dialog_Alert(Context mContext, int mthemeId) {
        this.mContext = mContext;
        this.mthemeId = mthemeId;
        init();
    }

    private void init() {
        dialogTools = new DialogTools(mContext, mthemeId);
        View view = dialogTools.setLayout(R.layout.dialog_alert_default);
        mDialogAlertContentTV = (TextView) view.findViewById(R.id.Dialog_Alert_contentTV);
        mDialogAlertSure = (Button) view.findViewById(R.id.Dialog_Alert_sure);
        mDialogAlertCancel = (Button) view.findViewById(R.id.Dialog_Alert_cancel);
        mDialogAlertSure.setOnClickListener(this);
        mDialogAlertCancel.setOnClickListener(this);
        dialogTools.showDialog();


//        设置窗口的大小和位置 不设置就使用默认
//        Window window = dialogTools.getWindow();
//        window.setGravity(Gravity.BOTTOM);
//        window.setLayout(-1,-2);

    }

    /**
     * 设置文本内容
     *
     * @param text
     */
    public void setContentText(CharSequence text) {
        mDialogAlertContentTV.setText(text);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Dialog_Alert_sure: //确认
                Toast.makeText(mContext, "确认", Toast.LENGTH_SHORT).show();
                dialogTools.dismiss();
                break;
            case R.id.Dialog_Alert_cancel://取消
                dialogTools.dismiss();
                break;
        }
    }
}
