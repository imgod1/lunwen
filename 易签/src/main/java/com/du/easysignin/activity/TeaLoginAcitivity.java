package com.du.easysignin.activity;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.du.easysignin.R;
import com.du.easysignin.base.BaseAcitivity;
import com.du.easysignin.consts.WifiApConst;
import com.du.easysignin.dialog.AddClassDialog;
import com.du.easysignin.sql.DbHelper;

import org.xutils.DbManager;
import org.xutils.x;

import java.io.File;
import java.util.ArrayList;

/**
 * 教师登录类
 */
public class TeaLoginAcitivity extends BaseAcitivity implements View.OnClickListener{

    private EditText et_tea_pass;
    private EditText et_tea_name;
    private Button bt_add_class;
    private Button tea_bt_login;
    private Spinner sp_class;
    ArrayList<String> spname=new ArrayList<>();
    private AddClassDialog addClassDialog;
    private Mhandler mhandler;
    private String name;//添加的班级的名字
    private ArrayAdapter<String> adapter;
    private String login_pass;//教师名字
    private String login_name;//教师密码


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea_denglu_acitivity);
        initUI();
        initEvent();
        initData();
    }



    @Override
    public void initUI() {
        et_tea_pass = (EditText) findViewById(R.id.et_tea_pass);
        et_tea_name = (EditText) findViewById(R.id.et_tea_name);
        bt_add_class = (Button) findViewById(R.id.bt_add_class);
        tea_bt_login = (Button) findViewById(R.id.tea_bt_login);
        sp_class = (Spinner) findViewById(R.id.sp_class);


    }

    /**
     * 初始化事件
     */
    @Override
    public void initEvent() {
        bt_add_class.setOnClickListener(this);
        tea_bt_login.setOnClickListener(this);
        adapter = new ArrayAdapter<String>(this, R.layout.simple_spinner,spname);

        mhandler = new Mhandler();
        sp_class.setAdapter(adapter);
        addClassDialog = new AddClassDialog(this,mhandler);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        //初始化班级信息
        getNameOfClass();
    }

    /**
     * 页面点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
             switch(v.getId()){
            case R.id.bt_add_class:
                //添加新班级
                addClassDialog.setTitle("添加新的班级：");
                addClassDialog.show();



            break;
            case R.id.tea_bt_login:
                //登录按钮
                 //获得名字和密码

                getNameAndPass();
                String  first = (String) sp_class.getSelectedItem();
//                System.out.println("first"+first);
                if(TextUtils.isEmpty(first)){
                    showShortToast("请添加一个新班级");
                    break;
                }

                login();
                    startActivity(TeaHomeActivity.class);
                break;
        }
    }

    /**
     * 登录到主页面
     */
    private void login() {
            //创建数据库
        System.out.println(login_name);

//        File file=new File("/sdcard");
            File file=new File(Environment.getExternalStorageDirectory().getPath());
        if(!file.exists()){
            file.mkdirs();
        }
        System.out.println(file.toString());
            DbManager.DaoConfig daoconfig = DbHelper.getDaoconfig(login_name, file, 1);
            DbManager db = x.getDb(daoconfig);



    }


    class Mhandler extends Handler{


        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case WifiApConst.ADDCLASS_NAME:
                    name = (String) msg.obj;
                    spname.add(name);
                    adapter.notifyDataSetChanged();
                    break;
            }

        }
    }

    /**
     * 初始化班级信息
     */
    public void getNameOfClass() {
        spname.add("杜江龙大队1");
        spname.add("杜江龙大队2");
        spname.add("杜江龙大队3");
        spname.add("杜江龙大队4");
    adapter.notifyDataSetChanged();
    }

    /**
     * 获得教师名字和密码
     */
    private void getNameAndPass() {
        login_pass = et_tea_pass.getText().toString().trim();
        login_name = et_tea_name.getText().toString().trim();
        if(TextUtils.isEmpty(login_name)||TextUtils.isEmpty(login_pass)){
            showShortToast("输入的内容不能为空");
            return;
        }
        if(login_pass.length()<8){
            showShortToast("输入的密码长度不能小于8位");
            return ;
        }
    }
}
