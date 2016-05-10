package com.du.easysignin.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.du.easysignin.R;
import com.du.easysignin.base.BaseAcitivity;

public class StuRegistActivity extends BaseAcitivity implements View.OnClickListener {

    private EditText regist_et_idcard;//学号输入框
    private EditText regist_et_password;//密码输入框
    private EditText regist_et_name;//名字输入框
    private Button regist_bt_regist;//注册按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_regist);

    }

    @Override
    public void initUI() {
        regist_et_idcard = (EditText) findViewById(R.id.regist_et_idcard);
        regist_et_password = (EditText) findViewById(R.id.regist_et_password);
        regist_et_name = (EditText) findViewById(R.id.regist_et_name);
        regist_bt_regist = (Button) findViewById(R.id.regist_bt_regist);
        regist_bt_regist.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //注册按钮
            case R.id.regist_bt_regist:

            break;
        }
    }
}
