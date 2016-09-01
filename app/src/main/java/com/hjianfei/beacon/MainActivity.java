package com.hjianfei.beacon;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.hjianfei.beacon.view.education.EducationFragment;
import com.hjianfei.beacon.view.home.HomeFragment;
import com.hjianfei.beacon.view.navigation.NavigationFragment;
import com.hjianfei.beacon.view.person.PersonFragment;
import com.stephentuso.welcome.WelcomeScreenHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;
    private WelcomeScreenHelper welcomeScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        welcomeScreen = new WelcomeScreenHelper(this, SplashActivity.class);
        welcomeScreen.show(savedInstanceState);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "首页").setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "导航").setActiveColorResource(R.color.teal))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "教育").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "我的").setActiveColorResource(R.color.brown))
                .setFirstSelectedPosition(0)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
        setTabSelection(0);
    }

    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 0:
                setTabSelection(0);
                break;
            case 1:
                setTabSelection(1);
                break;
            case 2:
                setTabSelection(2);
                break;
            case 3:
                setTabSelection(3);
                break;

        }

    }

    private void setTabSelection(int i) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (i == 0) {

            transaction.replace(R.id.fl_content, HomeFragment.newInstance(null, null));
        } else if (i == 1) {

            transaction.replace(R.id.fl_content, NavigationFragment.newInstance(null, null));
        } else if (i == 2) {

            transaction.replace(R.id.fl_content, EducationFragment.newInstance(null, null));
        } else if (i == 3) {

            transaction.replace(R.id.fl_content, PersonFragment.newInstance(null, null));
        }
        transaction.commit();

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        welcomeScreen.onSaveInstanceState(outState);
    }
}
