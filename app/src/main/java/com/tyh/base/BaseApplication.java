package com.tyh.base;

import android.app.Application;
import android.content.Context;
import android.icu.text.DateFormat;
import android.view.View;
import android.view.textservice.TextInfo;
import android.widget.TextView;

import com.tyh.view.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Administrator on 17.3.15.
 */

public class BaseApplication extends Application {

    /**
     * 初始化时间选择器
     */
    public TimePickerView getTimePickerView(Context mContext, final TextView timeShow,
                                            final TimePickerView.Type type) {
        TimePickerView pvTime = new TimePickerView(mContext, type);
        pvTime.setCyclic(true);//是否循环
        pvTime.setTime(new Date());//设置时间
        pvTime.setCancelable(true);//点击外围可撤销
//        pvTime.setRange(1990,2020);
        pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date) {
                timeShow.setText(formatTime(date, type));
            }
        });

        return pvTime;
    }


    /**
     * 将时间格式化
     *
     * @param mDate
     * @return
     */
    public String formatTime(Date mDate, TimePickerView.Type type) {
        SimpleDateFormat mDateFormat = null;
        switch (type) {
            case ALL:
                mDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm");
                break;
            case YEAR_MONTH_DAY:
                mDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                break;
            case HOURS_MINS:
                mDateFormat = new SimpleDateFormat("HH:mm");
                break;
            case MONTH_DAY_HOUR_MIN:
                mDateFormat = new SimpleDateFormat("MM-dd  HH:mm");
                break;
            case YEAR_MONTH:
                mDateFormat = new SimpleDateFormat("yyyy-MM");
                break;
        }
        String dateText = mDateFormat.format(mDate);
        return dateText;
    }
}
