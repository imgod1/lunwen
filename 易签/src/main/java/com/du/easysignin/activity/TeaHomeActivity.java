package com.du.easysignin.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.du.easysignin.R;
import com.du.easysignin.base.BaseAcitivity;
import com.du.easysignin.base.BasePager;
import com.du.easysignin.pager.GovAffairsPager;
import com.du.easysignin.pager.HomePager;
import com.du.easysignin.pager.Setting;
import com.du.easysignin.pager.Smart;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class TeaHomeActivity extends BaseAcitivity implements View.OnClickListener {

    private RadioButton rad_bt_1, rad_bt_2, rad_bt_3, rad_bt_4;
    private ViewPager vp_content;
    private RadioGroup rg_group;
    private ArrayList<BasePager> pagers;
    private int[] bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea_home);
        initUI();
        initEvent();
    }

    @Override
    public void initUI() {


//        rad_bt_1 = (RadioButton) findViewById(R.id.rad_bt_1);
//        rad_bt_2 = (RadioButton) findViewById(R.id.rad_bt_2);
//        rad_bt_3 = (RadioButton) findViewById(R.id.rad_bt_3);
//        rad_bt_4 = (RadioButton) findViewById(R.id.rad_bt_4);

        rg_group = (RadioGroup) findViewById(R.id.rg_group);
        vp_content = (ViewPager) findViewById(R.id.vp_content);


//        rad_bt_1.setOnClickListener(this);
//        rad_bt_2.setOnClickListener(this);
//        rad_bt_3.setOnClickListener(this);
//        rad_bt_4.setOnClickListener(this);
    }


    @Override
    public void initEvent() {
        bt = new int[]{R.id.rad_bt_1, R.id.rad_bt_2, R.id.rad_bt_3, R.id.rad_bt_4};
        rg_group.check(bt[0]);
        pagers = new ArrayList<>();
        pagers.add(new HomePager(this));
        pagers.add(new GovAffairsPager(this));
        pagers.add(new Smart(this));
        pagers.add(new Setting(this));
        vp_content.setAdapter(new MPagerAdapter());
        pagers.get(0).initData();
        vp_content.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int
                    positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pagers.get(position).initData();
                rg_group.check(bt[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        rg_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    //设置当前页面
                    case R.id.rad_bt_1:
                        vp_content.setCurrentItem(0, false);


                        break;
                    case R.id.rad_bt_2:
                        vp_content.setCurrentItem(1, false);
                        break;
                    case R.id.rad_bt_3:
                        vp_content.setCurrentItem(2, false);
                        break;
                    case R.id.rad_bt_4:
                        vp_content.setCurrentItem(3, false);
                        break;

                }
            }

        });
    }

    class MPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return pagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(pagers.get(position).mRootview);
            return pagers.get(position).mRootview;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((View) object);
        }
    }


    /**
     * 按钮单击事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {

    }


    private static Boolean isQuit = false;
    private Timer timer = new Timer();

    /**
     * 返回键退出
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isQuit == false) {
                isQuit = true;
                Toast.makeText(getBaseContext(), "再次点击确定退出软件", Toast.LENGTH_SHORT).show();
                TimerTask task = null;
                task = new TimerTask() {
                    @Override
                    public void run() {
                        isQuit = false;
                    }
                };
                timer.schedule(task, 2000);
            } else {
                finish();
            }
        } else {
        }
        return false;
    }
}
