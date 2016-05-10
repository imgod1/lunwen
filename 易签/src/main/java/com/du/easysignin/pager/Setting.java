package com.du.easysignin.pager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.du.easysignin.base.BasePager;

/**
 * Created by Administrator on 2016/4/26.
 */
public class Setting extends BasePager {
    public Setting(Activity context) {
        super(context);

    }

    @Override
    public void initData() {
        tv_title.setText("设置");

        TextView tv=new TextView(mActivity);
        tv.setText("设置");
        tv.setTextColor(Color.RED);
        tv.setGravity(Gravity.CENTER);
        fl_content.addView(tv);
    }
}
