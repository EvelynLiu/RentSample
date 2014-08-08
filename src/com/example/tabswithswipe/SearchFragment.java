package com.example.tabswithswipe;

import java.util.List;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class SearchFragment extends Fragment implements OnItemClickListener{
	private static final String rssFeed = "https://www.dropbox.com/s/t4o5wo6gdcnhgj8/imagelistview.xml?dl=1";
	private ListView listView;
	private View view;
	List<Item> arrayOfList;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		view = inflater.inflate(R.layout.search, container,false);
		listView = (ListView)view.findViewById(android.R.id.list);
		/*final String[] houses = new String[]{"新北市蘆州區中正路158號","B","C","D","E","F","G","H","I","J","K"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, houses);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "你選取了"+ houses[position], Toast.LENGTH_SHORT).show();
			}
		});*/
		listView.setOnItemClickListener(this);
		if (Utils.isNetworkAvailable(getActivity())) {
			new MyTask().execute(rssFeed);
		} else {
			showToast("No Network Connection!!!");
		}
		return view;
	}

	class MyTask extends AsyncTask<String, Void, Void>{
		ProgressDialog pDialog;
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(getActivity());
			pDialog.setMessage("Loading...");
			pDialog.show();
		}
		
		@Override
		protected Void doInBackground(String... params) {
			arrayOfList = new NamesParser().getData(params[0]);
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			if (null != pDialog && pDialog.isShowing()) {
				pDialog.dismiss();
			}

			if (null == arrayOfList || arrayOfList.size() == 0) {
				showToast("No data found from web!!!");
				//getActivity().finish();
			} else {
				// check data...
				/*
				 * for (int i = 0; i < arrayOfList.size(); i++) { Item item =
				 * arrayOfList.get(i); System.out.println(item.getId());
				 * System.out.println(item.getTitle());
				 * System.out.println(item.getDesc());
				 * System.out.println(item.getPubdate());
				 * System.out.println(item.getLink()); }
				 */
				setAdapterToListview();
			}

		}
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		Item item = arrayOfList.get(position);
		Intent intent = new Intent(getActivity(), DetailActivity.class);
		/*intent.putExtra("url", item.getLink());
		intent.putExtra("price", item.getPrice());
		intent.putExtra("desc", item.getDesc());
		intent.putExtra("type", item.getType());
		intent.putExtra("size", item.getSize());
		intent.putExtra("address", item.getAddress());*/
		intent.putExtra("url", item.getLink());
		intent.putExtra("title", item.getTitle());
		intent.putExtra("desc", item.getDesc());
		startActivity(intent);
	}
	
	public void setAdapterToListview() {
		NewsRowAdapter objAdapter = new NewsRowAdapter(getActivity(),
				R.layout.list_row, arrayOfList);
		listView.setAdapter(objAdapter);
	}
	
	public void showToast(String msg) {
		Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
	}
}
