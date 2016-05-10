package com.du.easysignin.pager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.du.easysignin.base.BasePager;

/**
 * Created by Administrator on 2016/4/26.
 */
public class StuPager2 extends BasePager {
    public StuPager2(Activity context) {
        super(context);

    }

    @Override
    public void initData() {
        tv_title.setText("StuPager2");
        TextView tv=new TextView(mActivity);
        tv.setText("StuPager2");
        tv.setTextColor(Color.RED);
        tv.setGravity(Gravity.CENTER);
        fl_content.addView(tv);
    }
}
