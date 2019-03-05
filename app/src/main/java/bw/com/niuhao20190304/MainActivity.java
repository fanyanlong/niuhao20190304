package bw.com.niuhao20190304;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import bw.com.niuhao20190304.fragment.FaFragment;
import bw.com.niuhao20190304.fragment.JiangFragment;
import bw.com.niuhao20190304.fragment.MineFragment;
import bw.com.niuhao20190304.fragment.StudyFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tabBar)
    BottomTabBar tabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tabBar.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setFontSize(14)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("发现", R.mipmap.fa, FaFragment.class)
                .addTabItem("讲堂", R.mipmap.teacher, JiangFragment.class)
                .addTabItem("学习", R.mipmap.study, StudyFragment.class)
                .addTabItem("我的", R.mipmap.mine, MineFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });

    }


}
