package com.du.easysignin.base;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.du.easysignin.R;

/**
 * basepager类
 * Created by Administrator on 2016/4/26.
 */
public class BasePager {
    public Activity mActivity;
    public View mRootview;
    public  TextView tv_title;
    public FrameLayout fl_content;

    public BasePager(Activity context) {
        mActivity=  context;
        initUI();
    }

    //初始化UI
    public void initUI() {
        mRootview = View.inflate(mActivity, R.layout.base_pager, null);
        tv_title = (TextView) mRootview.findViewById(R.id.tv_title);
        fl_content = (FrameLayout) mRootview.findViewById(R.id.fl_content);

    }
    //初始化数据
    public void initData(){

    }


}
