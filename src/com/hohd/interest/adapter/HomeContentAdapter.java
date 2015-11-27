package com.hohd.interest.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class HomeContentAdapter extends FragmentPagerAdapter {
	List<Fragment> list;

	public HomeContentAdapter(FragmentManager fm, List<Fragment> list) {
		super(fm);
		this.list = list;
	}

	@Override
	public Fragment getItem(int location) {
		return list.get(location);
	}

	@Override
	public int getCount() {
		return list.size();
	}

}
