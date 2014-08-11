package com.example.tabswithswipe;

import com.example.tabswithswipe.adapter.TabsPagerAdapter;

import android.R.anim;
import android.app.Activity;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.ColorDrawable;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

	private ViewPager viewPager;
	private TabsPagerAdapter mAdapter;
	private ActionBar actionBar;
	
	//tab titles
	private String[] tabs = {"搜尋","收藏案件","會員刊登","更多"};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_PROGRESS);//loading進度表
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Initialization
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        //actionBar.setBackgroundDrawable(new ColorDrawable(0xddd));
        actionBar.setStackedBackgroundDrawable(new ColorDrawable(0xccc));
        
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        
        viewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        //Customize Action Bar
        getActionBar().setIcon(android.R.color.transparent);
        actionBar.setLogo(android.R.color.transparent);
        actionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);
        View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);
        actionBar.setCustomView(mCustomView);
        actionBar.setDisplayShowCustomEnabled(true);
        
        //Adding Tabs
        for(String tab_name: tabs){
        	actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(this));
        }
        
        //on swiping the viewpager make respective tab selected
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				actionBar.setSelectedNavigationItem(position);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
    }

    public void clickEvent(View v) {
		if(v.getId() == R.id.rechoose){
			Toast.makeText(MainActivity.this, "reChoose", Toast.LENGTH_SHORT).show();
		}
    	if(v.getId() == R.id.map){
			Toast.makeText(MainActivity.this, "showMap", Toast.LENGTH_SHORT).show();
			showMapActivity(v);
		}
	}
    
    public void showMapActivity(View view) {
		Intent intent = new Intent(this, MapActivity.class);
		//傳List內容到Map or server重新撈資料
		//ListView listView = (ListView) findViewById(R.id.listView1);
		startActivity(intent);
	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
    	WebView wv = (WebView) findViewById(R.id.wv);
    	if(keyCode == KeyEvent.KEYCODE_BACK && wv.canGoBack()){
			wv.goBack();
			return true;
		}
		return onKeyDown(keyCode, event);
    }
    
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
}
