package com.tyh.datepick_dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tyh.base.BaseActivity;
import com.tyh.dialog.Dialog_Alert;
import com.tyh.view.TimePickerView;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button main_alert;
    private TextView main_dateShow;
    private Button main_date;
    private TextView main_timeShow;
    private Button main_time;
    private LinearLayout activity_main;


    private TimePickerView pvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        main_alert = (Button) findViewById(R.id.main_alert);
        main_dateShow = (TextView) findViewById(R.id.main_dateShow);
        main_date = (Button) findViewById(R.id.main_date);
        main_timeShow = (TextView) findViewById(R.id.main_timeShow);
        main_time = (Button) findViewById(R.id.main_time);
        activity_main = (LinearLayout) findViewById(R.id.activity_main);

        main_alert.setOnClickListener(this);
        main_date.setOnClickListener(this);
        main_time.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_alert:
                Dialog_Alert dialog_alert = new Dialog_Alert(this);
                break;
            case R.id.main_date:
                TimePickerView datePickerView = mBaseApp.getTimePickerView(this, main_dateShow, TimePickerView.Type.YEAR_MONTH_DAY);
                datePickerView.show();
                break;
            case R.id.main_time:
                TimePickerView timePickerView = mBaseApp.getTimePickerView(this, main_timeShow, TimePickerView.Type.HOURS_MINS);
                timePickerView.show();
                break;
        }
    }


}
