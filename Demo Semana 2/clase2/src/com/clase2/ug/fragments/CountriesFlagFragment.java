package com.clase2.ug.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clase2.ug.R;
import com.clase2.ug.data.FlagPageAdapter;

public class CountriesFlagFragment extends Fragment {

	ViewPager viewPager;
	
		
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		FlagPageAdapter adapter = new FlagPageAdapter(getChildFragmentManager());
		viewPager.setAdapter(adapter);
	}



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_countries_flags, container, false);
		viewPager = (ViewPager)view.findViewById(R.id.pager);
		return view;
		
	}

}
