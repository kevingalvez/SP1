package com.clase2.ug.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.clase2.ug.R;

public class FlagFragment extends Fragment {
	public final static String RESOURCES = "resource";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_flag, null);
		ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
		Bundle args = getArguments();
		
		imageView.setImageResource(args.getInt(RESOURCES));
		return view;
	}

}
