package com.du.easysignin.pager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.du.easysignin.base.BasePager;

/**
 * Created by Administrator on 2016/4/26.
 */
public class StuPager3 extends BasePager {
    public StuPager3(Activity context) {
        super(context);

    }

    @Override
    public void initData() {
        tv_title.setText("StuPager3");
        TextView tv=new TextView(mActivity);
        tv.setText("StuPager3");
        tv.setTextColor(Color.RED);
        tv.setGravity(Gravity.CENTER);
        fl_content.addView(tv);
    }
}
