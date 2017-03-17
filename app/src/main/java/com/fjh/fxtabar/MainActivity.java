package com.fjh.fxtabar;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fjh.fxtabar.frament.FragmentCommon;
import com.fjh.fxtabar.view.TabView;
import com.fjh.fxtabar.view.TabViewChild;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabView tabView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabView= (TabView) findViewById(R.id.tabView);

        List<TabViewChild> tabViewChildList=new ArrayList<>();
        TabViewChild tabViewChild01=new TabViewChild(R.drawable.tab01_sel,R.drawable.tab01_unsel,"首页",  FragmentCommon.newInstance("首页"));
        TabViewChild tabViewChild02=new TabViewChild(R.drawable.tab02_sel,R.drawable.tab02_unsel,"分类",  FragmentCommon.newInstance("分类"));
        TabViewChild tabViewChild04=new TabViewChild(R.drawable.tab04_sel,R.drawable.tab04_unsel,"购物车",FragmentCommon.newInstance("购物车"));
        TabViewChild tabViewChild05=new TabViewChild(R.drawable.tab05_sel,R.drawable.tab05_unsel,"我的",  FragmentCommon.newInstance("我的"));
        tabViewChildList.add(tabViewChild01);
        tabViewChildList.add(tabViewChild02);
        tabViewChildList.add(tabViewChild04);
        tabViewChildList.add(tabViewChild05);
        tabView.setTextViewSelectedColor(Color.parseColor("#ffb400"));//TextView选中颜色
        tabView.setTextViewUnSelectedColor(Color.BLACK);//TextView未选中颜色
        tabView.setTabViewBackgroundColor(Color.parseColor("#eeeeee"));//Tab背景颜色
        tabView.setTabViewHeight(dip2px(52));
        tabView.setImageViewTextViewMargin(2);
        tabView.setTextViewSize(14);
        tabView.setImageViewWidth(dip2px(30));
        tabView.setImageViewHeight(dip2px(30));
        tabView.setTabViewGravity(Gravity.TOP);
        tabView.setTabViewDefaultPosition(0);//设置默认选中的TabViewChild

        tabView.setTabViewChild(tabViewChildList,getSupportFragmentManager());
        tabView.setOnTabChildClickListener(new TabView.OnTabChildClickListener() {
            @Override
            public void onTabChildClick(int  position, ImageView currentImageIcon, TextView currentTextView) {

            }
        });
    }

    public  int dip2px(float dpValue)
    {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
