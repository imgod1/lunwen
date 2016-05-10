package com.du.easysignin.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.du.easysignin.R;
import com.du.easysignin.base.BaseAcitivity;
import com.du.easysignin.base.BasePager;
import com.du.easysignin.pager.GovAffairsPager;
import com.du.easysignin.pager.HomePager;
import com.du.easysignin.pager.Setting;
import com.du.easysignin.pager.Smart;
import com.du.easysignin.pager.StuPager1;
import com.du.easysignin.pager.StuPager2;
import com.du.easysignin.pager.StuPager3;
import com.du.easysignin.pager.StuPager4;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class StuHomeActivity extends BaseAcitivity {

    private RadioGroup rg_group_stu;
    private ViewPager vp_stu_home;
    private ArrayList<BasePager> pagers;
    private int[] bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_home);
        initUI();
        initEvent();
    }

    @Override
    public void initUI() {
        rg_group_stu = (RadioGroup) findViewById(R.id.rg_group_stu);
        vp_stu_home = (ViewPager) findViewById(R.id.vp_stu_home);
    }

    @Override
    public void initEvent() {

        bt = new int[]{R.id.stu_home_rd1, R.id.stu_home_rd2, R.id.stu_home_rd3, R.id.stu_home_rd4};
        rg_group_stu.check(bt[0]);
        pagers = new ArrayList<>();
        pagers.add(new StuPager1(this));
        pagers.add(new StuPager2(this));
        pagers.add(new StuPager3(this));
        pagers.add(new StuPager4(this));
        vp_stu_home.setAdapter(new MPagerAdapter());
        pagers.get(0).initData();
        vp_stu_home.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int
                    positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pagers.get(position).initData();
                rg_group_stu.check(bt[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        rg_group_stu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    //设置当前页面
                    case R.id.stu_home_rd1:
                        vp_stu_home.setCurrentItem(0, false);


                        break;
                    case R.id.stu_home_rd2:
                        vp_stu_home.setCurrentItem(1, false);
                        break;
                    case R.id.stu_home_rd3:
                        vp_stu_home.setCurrentItem(2, false);
                        break;
                    case R.id.stu_home_rd4:
                        vp_stu_home.setCurrentItem(3, false);
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

