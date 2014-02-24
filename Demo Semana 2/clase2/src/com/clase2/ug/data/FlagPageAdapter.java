package com.clase2.ug.data;

import com.clase2.ug.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.clase2.ug.fragments.FlagFragment;

public class FlagPageAdapter extends FragmentPagerAdapter {

	private int[] arrayFlags = new int[]{
			R.drawable.brazil,
			R.drawable.mexico,
			R.drawable.colombia,
			R.drawable.argentina,
			R.drawable.peru,
			R.drawable.venezuela,
			R.drawable.chile,
			R.drawable.ecuador,
			R.drawable.guatemala,
			R.drawable.cuba,
			};
	
	
	public FlagPageAdapter(FragmentManager fm) {
		super(fm);
		
	}

	@Override
	public Fragment getItem(int position) {
		Fragment fragment = new FlagFragment();
		Bundle args =  new Bundle();
		args.putInt(FlagFragment.RESOURCES,arrayFlags[position]); 
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public int getCount() {
		return arrayFlags.length;
	}

}
