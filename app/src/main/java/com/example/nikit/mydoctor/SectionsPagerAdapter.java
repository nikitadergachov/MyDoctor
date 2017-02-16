package com.example.nikit.mydoctor;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import java.util.Dictionary;


public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private int mActualTitleListSize;
    private Dictionary mTitleList;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = (String) mTitleList.get(position % mActualTitleListSize);
        return title;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int virtualPosition = position % mActualTitleListSize;
        return super.instantiateItem(container, virtualPosition);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        int virtualPosition = position % mActualTitleListSize;
        super.destroyItem(container, virtualPosition, object);
    }



}