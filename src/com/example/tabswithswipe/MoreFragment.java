package com.example.tabswithswipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

public class MoreFragment extends Fragment{
	View view;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		view = inflater.inflate(R.layout.more, container,false);
		NumberPicker np = (NumberPicker)view.findViewById(R.id.npicker);
		np.setMaxValue(10);
		np.setMinValue(0);
		return view;
	}
	
}
