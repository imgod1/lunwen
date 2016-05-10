package com.du.easysignin.base;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import com.du.easysignin.R;

/**
 * BaseActivity
 */
public abstract class BaseAcitivity extends FragmentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * 初始化布局
     */
    public abstract void initUI();

    /**
     * 初始化控件
     */
    public void initEvent(){}


    /** 短暂显示Toast提示(来自res) **/
    protected void showShortToast(int resId) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show();
    }

    /** 短暂显示Toast提示(来自String) **/
    protected void showShortToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    /** 长时间显示Toast提示(来自res) **/
    protected void showLongToast(int resId) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_LONG).show();
    }

    /** 长时间显示Toast提示(来自String) **/
    protected void showLongToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }



    /** 含有标题和内容的对话框 **/
    protected AlertDialog showAlertDialog(String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle(title).setMessage(message)
                .show();
        return alertDialog;
    }

    /** 含有标题、内容、两个按钮的对话框 **/
    protected AlertDialog showAlertDialog(String title, String message, String positiveText,
                                          DialogInterface.OnClickListener onPositiveClickListener, String negativeText,
                                          DialogInterface.OnClickListener onNegativeClickListener) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle(title).setMessage(message)
                .setPositiveButton(positiveText, onPositiveClickListener)
                .setNegativeButton(negativeText, onNegativeClickListener).show();
        return alertDialog;
    }


    /** 通过Class跳转界面 **/
    protected void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /** 含有Bundle通过Class跳转界面 **/
    protected void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
}
