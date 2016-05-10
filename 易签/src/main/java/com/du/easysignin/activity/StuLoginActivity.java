package com.du.easysignin.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.du.easysignin.R;
import com.du.easysignin.base.BaseAcitivity;

public class StuLoginActivity extends BaseAcitivity implements View.OnClickListener {

    private EditText et_stu_password;//学生密码输入框
    private EditText et_stu_name;//学生学号输入框
    private Button stu_btn_regist;//学生注册按钮
    private Button stu_btn_login;//学生登录按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_denglu);

        initUI();
        initData();
    }



    @Override
    public void initUI() {
        et_stu_name = (EditText) findViewById(R.id.et_stu_name);
        et_stu_password = (EditText) findViewById(R.id.et_stu_password);
        stu_btn_login = (Button) findViewById(R.id.stu_btn_login);
        stu_btn_regist = (Button) findViewById(R.id.stu_btn_regist);
        stu_btn_regist.setOnClickListener(this);
        stu_btn_login.setOnClickListener(this);
    }



    private void initData() {

    }

    /**
     * 页面按钮响应事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //学生注册按钮
            case R.id.stu_btn_regist:
                startActivity(StuRegistActivity.class);
            break;
            //学生登录按钮
            case R.id.stu_btn_login:

                startActivity(StuHomeActivity.class);
            break;

        }
    }
}
