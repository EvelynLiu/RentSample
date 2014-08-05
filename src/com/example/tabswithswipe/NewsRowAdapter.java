package com.example.tabswithswipe;

import java.util.List;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.ImageLoadingListener;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class NewsRowAdapter extends ArrayAdapter<Item>{

	private Activity activity;
	private List<Item> items;
	private Item objBean;
	private int row;
	private DisplayImageOptions options;
	ImageLoader imageLoader;
	
	public NewsRowAdapter(Activity act, int resource, List<Item> arrayList) {
		super(act, resource, arrayList);
		// TODO Auto-generated constructor stub
		this.activity = act;
		this.row = resource;
		this.items = arrayList;

		options = new DisplayImageOptions.Builder()
				.showStubImage(R.drawable.profile)
				.showImageForEmptyUrl(R.drawable.profile).cacheInMemory()
				.cacheOnDisc().build();
		imageLoader = ImageLoader.getInstance();
	}
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View view = convertView;
		ViewHolder holder;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(row, null);

			holder = new ViewHolder();
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		if ((items == null) || ((position + 1) > items.size()))
			return view;

		objBean = items.get(position);

		/*holder.tvPrice = (TextView) view.findViewById(R.id.tvprice);
		holder.tvDesc = (TextView) view.findViewById(R.id.tvdesc);
		holder.tvAddress = (TextView) view.findViewById(R.id.tvaddress);
		holder.tvSize = (TextView) view.findViewById(R.id.tvsize);
		holder.tvType = (TextView) view.findViewById(R.id.tvtype);
		holder.imgView = (ImageView) view.findViewById(R.id.image);
		holder.pbar = (ProgressBar) view.findViewById(R.id.pbar);

		if (holder.tvPrice != null && null != objBean.getPrice()
				&& objBean.getPrice().trim().length() > 0) {
			holder.tvPrice.setText(Html.fromHtml(objBean.getPrice()));
		}
		if (holder.tvSize != null && null != objBean.getSize()
				&& objBean.getSize().trim().length() > 0) {
			holder.tvSize.setText(Html.fromHtml(objBean.getSize()));
		}
		if (holder.tvType != null && null != objBean.getType()
				&& objBean.getType().trim().length() > 0) {
			holder.tvType.setText(Html.fromHtml(objBean.getType()));
		}
		if (holder.tvDesc != null && null != objBean.getDesc()
				&& objBean.getDesc().trim().length() > 0) {
			holder.tvDesc.setText(Html.fromHtml(objBean.getDesc()));
		}
		if (holder.tvAddress != null && null != objBean.getAddress()
				&& objBean.getAddress().trim().length() > 0) {
			holder.tvAddress.setText(Html.fromHtml(objBean.getAddress()));
		}*/
		holder.tvTitle = (TextView) view.findViewById(R.id.tvtitle);
		holder.tvDesc = (TextView) view.findViewById(R.id.tvdesc);
		holder.tvDate = (TextView) view.findViewById(R.id.tvdate);
		holder.imgView = (ImageView) view.findViewById(R.id.image);
		holder.pbar = (ProgressBar) view.findViewById(R.id.pbar);

		if (holder.tvTitle != null && null != objBean.getTitle()
				&& objBean.getTitle().trim().length() > 0) {
			holder.tvTitle.setText(Html.fromHtml(objBean.getTitle()));
		}
		if (holder.tvDesc != null && null != objBean.getDesc()
				&& objBean.getDesc().trim().length() > 0) {
			holder.tvDesc.setText(Html.fromHtml(objBean.getDesc()));
		}
		if (holder.tvDate != null && null != objBean.getPubdate()
				&& objBean.getPubdate().trim().length() > 0) {
			holder.tvDate.setText(Html.fromHtml(objBean.getPubdate()));
		}
		if (holder.imgView != null) {
			if (null != objBean.getLink() && objBean.getLink().trim().length() > 0) {
				final ProgressBar pbar = holder.pbar;

				imageLoader.init(ImageLoaderConfiguration
						.createDefault(activity));
				imageLoader.displayImage(objBean.getLink(), holder.imgView,
						options, new ImageLoadingListener() {
							@Override
							public void onLoadingComplete() {
								pbar.setVisibility(View.INVISIBLE);
							}
							@Override
							public void onLoadingFailed() {
								pbar.setVisibility(View.INVISIBLE);
							}
							@Override
							public void onLoadingStarted() {
								pbar.setVisibility(View.VISIBLE);
							}
						});
			} 
			else {
				holder.imgView.setImageResource(R.drawable.ic_launcher);
			}
		}
		return view;
	}

	public class ViewHolder {
		public TextView tvPrice, tvDesc, tvType, tvSize, tvAddress,tvTitle,tvDate;
		private ImageView imgView;
		private ProgressBar pbar;
	}

}
