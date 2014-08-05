package com.example.tabswithswipe;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.ImageLoadingListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DetailActivity extends Activity{
	private DisplayImageOptions options;
	private ImageLoader imageLoader;
	private ProgressBar pbar;
	private TextView tvPrice, tvDesc, tvType, tvSize, tvAddress, tvTitle;
	private ImageView imgView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_detail);

		/*pbar = (ProgressBar) findViewById(R.id.pbardesc);
		tvPrice = (TextView) findViewById(R.id.tvprice);
		tvDesc = (TextView) findViewById(R.id.tvdesc);
		tvAddress = (TextView) findViewById(R.id.tvaddress);
		tvType = (TextView) findViewById(R.id.tvtype);
		tvSize = (TextView) findViewById(R.id.tvsize);
		imgView = (ImageView) findViewById(R.id.imgdesc);

		Bundle b = getIntent().getExtras();

		String price = b.getString("price");
		String desc = b.getString("desc");
		

		tvPrice.setText(price);
		tvDesc.setText(desc);
		tvAddress.setText(b.getString("address"));
		tvType.setText(b.getString("type"));
		tvSize.setText(b.getString("size"));*/
		pbar = (ProgressBar) findViewById(R.id.pbardesc);
		tvTitle = (TextView) findViewById(R.id.tvtitle);
		tvDesc = (TextView) findViewById(R.id.tvdesc);
		imgView = (ImageView) findViewById(R.id.imgdesc);

		Bundle b = getIntent().getExtras();

		String title = b.getString("title");
		String desc = b.getString("desc");

		tvTitle.setText(title);
		tvDesc.setText(desc); //delete

		String url = b.getString("url");
		loadImageFromURL(url);

	}

	private void loadImageFromURL(String url) {
		options = new DisplayImageOptions.Builder()
				.showStubImage(R.drawable.profile)
				.showImageForEmptyUrl(R.drawable.profile).cacheInMemory()
				.cacheOnDisc().build();
		imageLoader = ImageLoader.getInstance();
		imageLoader.init(ImageLoaderConfiguration.createDefault(this));
		imageLoader.displayImage(url, imgView, options,
				new ImageLoadingListener() {
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
}
