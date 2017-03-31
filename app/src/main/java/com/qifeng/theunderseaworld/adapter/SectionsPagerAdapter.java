package com.qifeng.theunderseaworld.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.ViewGroup;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragments;
    FragmentManager Fm;

    public SectionsPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.Fm = fm;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


    public void refreshData(ArrayList<Fragment> fragments) {
        Log.d("mingyue","fragments--------------"+fragments.toString());
        this.fragments = fragments;
        Log.d("mingYue", this.fragments.toString());
        notifyDataSetChanged();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (position == 3){
            removefragment(container,position);
        }
        return super.instantiateItem(container, position);
    }

    private void removefragment(ViewGroup container, int index) {
        String tag = getFragmentTag(container.getId(), index);

        Fragment fragment = Fm.findFragmentByTag(tag);
        if (fragment == null)
            return;
        FragmentTransaction ft = Fm.beginTransaction();
        ft.remove(fragment);
        ft.commit();
        ft = null;
        Fm.executePendingTransactions();

    }

    private String getFragmentTag(int viewId, int index) {
        try {
            Class<FragmentPagerAdapter> cls = FragmentPagerAdapter.class;
            Class<?>[] parameterTypes = { int.class, long.class };
            Method method = cls.getDeclaredMethod("makeFragmentName",
                    parameterTypes);
            method.setAccessible(true);
            String tag = (String) method.invoke(this, viewId, index);
            return tag;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}