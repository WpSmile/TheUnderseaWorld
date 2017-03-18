package com.qifeng.theunderseaworld.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.fragment.CommunityFragment;
import com.qifeng.theunderseaworld.fragment.HomePageFragment;
import com.qifeng.theunderseaworld.fragment.PersonalFragment;
import com.qifeng.theunderseaworld.fragment.StoreFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener/*,ViewPager.OnPageChangeListener*/ {

    @BindView(R.id.layViewPager)
    FrameLayout layViewPager;
    private Fragment[] fragments;
    //private ArrayList<Fragment> fragments;
    //private ViewPager viewPager;

    BottomNavigationBar bottomNavigationBar;
    HomePageFragment homePageFragment;
    StoreFragment storeFragment;
    CommunityFragment communityFragment;
    PersonalFragment personalFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        //用于添加底部菜单的方法
        addItem();
        getFragments();
        setDefaultFragment();
        setListener();
    }

    private void addItem() {
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .setBarBackgroundColor(R.color.bottom_blue);

        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.shouye, R.string.home_page).setActiveColorResource(R.color.littleblue))
                .addItem(new BottomNavigationItem(R.mipmap.shangcheng, R.string.store).setActiveColorResource(R.color.littleblue))
                .addItem(new BottomNavigationItem(R.mipmap.shequ, R.string.community).setActiveColorResource(R.color.littleblue))
                .addItem(new BottomNavigationItem(R.mipmap.wode, R.string.personal).setActiveColorResource(R.color.littleblue))
                .setFirstSelectedPosition(0)
                .initialise();

    }

    /*监听事件的方法*/
    private void setListener() {
        bottomNavigationBar.setTabSelectedListener(this);
    }


    private void initView() {
        //fragments = new ArrayList<>();
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        //initViewPager();
    }

    /*private void initViewPager() {

        viewPager = (ViewPager) findViewById(R.id.layViewPager);
        viewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager(), fragments));
        viewPager.addOnPageChangeListener(this);
        viewPager.setCurrentItem(0);
    }*/

    private void getFragments() {
        fragments = new Fragment[4];
        homePageFragment = new HomePageFragment();
        storeFragment = new StoreFragment();
        communityFragment = new CommunityFragment();
        personalFragment = new PersonalFragment();
        fragments[0] = homePageFragment;
        fragments[1] = storeFragment;
        fragments[2] = communityFragment;
        fragments[3] = personalFragment;
        //fragments.add(homePageFragment);
        //fragments.add(storeFragment);
        //fragments.add(communityFragment);
        //fragments.add(personalFragment);
        getSupportFragmentManager().beginTransaction().commit();
    }

    /**
     * 设置默认的fragment
     */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.layViewPager, homePageFragment);
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {
        if (fragments != null) {
            if (position < fragments/*.size()*/.length) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments/*.get(position)*/[position];
                if (fragment.isAdded()) {
                    ft.replace(R.id.layViewPager, fragment);
                } else {
                    ft.add(R.id.layViewPager, fragment);
                }
                ft.commitAllowingStateLoss();
            }
        }
        //viewPager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {
            if (position < fragments/*.size()*/.length) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments/*.get(position)*/[position];
                ft.remove(fragment);
                ft.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabReselected(int position) {

    }

   /* @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        bottomNavigationBar.selectTab(position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }*/

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(outState != null) {
            String FRAGMENTS_TAG = "android:support:fragments";
            // remove掉保存的Fragment
            outState.remove(FRAGMENTS_TAG);
        }
    }
}
