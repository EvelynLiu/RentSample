package com.example.tabswithswipe.adapter;

import com.example.tabswithswipe.CollectFragment;
import com.example.tabswithswipe.MemberFragment;
import com.example.tabswithswipe.MoreFragment;
import com.example.tabswithswipe.SearchFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter{

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int index) {
		// TODO Auto-generated method stub
		switch(index){
			case 0:
				return new SearchFragment();
			case 1:
				return new CollectFragment();
			case 2:
				return new MemberFragment();
			case 3:
				return new MoreFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 4;
	}
	
}
