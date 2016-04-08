package com.littlejie.android.demo;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import com.littlejie.android.demo.manager.ActivityManager;
import com.littlejie.android.demo.modules.base.BaseActivity;
import com.littlejie.android.demo.modules.other.OtherActivity;
import com.littlejie.android.demo.modules.widget.WidgetActivity;

public class MainActivity extends BaseActivity {

    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;

    @Override
    protected int getPageLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation);
        //禁止系统对item的图标进行着色
        mNavigationView.setItemIconTintList(null);
    }

    @Override
    protected void initViewListener() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.navigation_other) {
                    ActivityManager.startActivity(MainActivity.this, OtherActivity.class);
                    mDrawerLayout.closeDrawers();
                    return true;
                } else if (item.getItemId() == R.id.navigation_widget) {
                    ActivityManager.startActivity(MainActivity.this, WidgetActivity.class);
                    mDrawerLayout.closeDrawers();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void initData() {

    }
}
