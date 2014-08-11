package com.example.tabswithswipe;

import android.R.integer;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SearchRentFragment extends Fragment implements OnClickListener{
	SearchFragment searchFragment;
	private View view;
	private Button btn_1, btn_2, btn_3, btn_4;
	private int layout;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		view = inflater.inflate(R.layout.search, container,false);
		btn_1 = (Button)view.findViewById(R.id.nearby);
		btn_1.setOnClickListener(this);
		showToast(container.toString());
		return view;
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), "onClick", Toast.LENGTH_SHORT).show();
		switch (v.getId()){
			case R.id.nearby:
				showToast("附近搜尋");
				// Create new fragment and transaction
				Fragment newFragment = new SearchFragment();
				FragmentTransaction transaction = getFragmentManager().beginTransaction();

				// Replace whatever is in the fragment_container view with this fragment,
				// and add the transaction to the back stack
				transaction.replace(R.id.RelativeLayout1, newFragment);
				transaction.addToBackStack(null);

				// Commit the transaction
				transaction.commit();
				break;
			case R.id.rent:
				showToast("rent");
				break;
			case R.id.buy:
				showToast("buy");
				break;
			case R.id.givein:
				showToast("givein");
				break;
		}
	}

	public void showToast(String msg) {
		Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
	}
}
