package com.ll.ydmusic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.ImageView;

import com.imooc.weixin6_0.R;
import com.ll.ydmusic.fragment_f4.FragmentFirst_Chat;
import com.ll.ydmusic.fragment_f4.FragmentForth_Me;
import com.ll.ydmusic.fragment_f4.FragmentSecond_Contact;
import com.ll.ydmusic.fragment_f4.FragmentThird_Find;
import com.ll.ydmusic.main.LaunchActivity;

public class MainActivity extends FragmentActivity implements OnClickListener,
		OnPageChangeListener
{

	
	private ViewPager mViewPager;
	private List<Fragment> mFragmentList = new ArrayList<Fragment>();
	/*private String[] mTitles = new String[]
	{  "Second Fragment !", "Third Fragment !",
			"Fourth Fragment !" };*/
	private FragmentPagerAdapter mAdapter;

	private List<ChangeColorIconWithText> mButtonList = new ArrayList<ChangeColorIconWithText>();
	private ImageView ic_music;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setOverflowButtonAlways();
		getActionBar().setDisplayShowHomeEnabled(false);
		//getActionBar().hide();
		//getActionBar().show();
		
		//getActionBar().setDisplayHomeAsUpEnabled(true) ;

		initView();
		initDatas();
		mViewPager.setAdapter(mAdapter);
		
		initEvent();

	}

	/**
	 * 初始化所有事件
	 */
	private void initEvent()
	{

		mViewPager.setOnPageChangeListener(this);

	}

	private void initDatas()
	{
		initFragments();

		
		
		
		
		
		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager())
		{

			@Override
			public int getCount()
			{
				return mFragmentList.size();
			}

			@Override
			public Fragment getItem(int position)
			{
				return mFragmentList.get(position);
			}
		};
	}

	/**
	 * 
	 */
	private void initFragments() {

		FragmentFirst_Chat mFragment_Chat=new FragmentFirst_Chat();
		mFragmentList.add(mFragment_Chat);
		
		FragmentSecond_Contact mFragmentSecond_Contact=new FragmentSecond_Contact();
		mFragmentList.add(mFragmentSecond_Contact);
		
		FragmentThird_Find mFragment_Find=new FragmentThird_Find();
		mFragmentList.add(mFragment_Find);
		
		FragmentForth_Me mForth_Me=new FragmentForth_Me();
		mFragmentList.add(mForth_Me);
		
		
		/*for (String title : mTitles)
		{
			Bundle bundle = new Bundle();
			bundle.putString(TabFragment.TITLE, title);
			
			TabFragment tabFragment = new TabFragment();
			tabFragment.setArguments(bundle);
			
			mFragmentList.add(tabFragment);
		}*/
	}

	private void initView()
	{
		
		
		//初始化我的自定义按钮，并给它们添加点击监听
		init_mButtons();
		//给bottombar中间的music图标添加点击监听
		init_icon_music();
	}

	private void init_icon_music() {
		// TODO 自动生成的方法存根
		ic_music = (ImageView)findViewById(R.id.id_icon_music);
		ic_music.setOnClickListener(this);
	}

	/**
	 * 
	 */
	private void init_mButtons() {
		mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

		ChangeColorIconWithText one = (ChangeColorIconWithText) findViewById(R.id.id_indicator_one);
		mButtonList.add(one);
		ChangeColorIconWithText two = (ChangeColorIconWithText) findViewById(R.id.id_indicator_two);
		mButtonList.add(two);
		ChangeColorIconWithText three = (ChangeColorIconWithText) findViewById(R.id.id_indicator_three);
		mButtonList.add(three);
		ChangeColorIconWithText four = (ChangeColorIconWithText) findViewById(R.id.id_indicator_four);
		mButtonList.add(four);

		one.setOnClickListener(this);
		two.setOnClickListener(this);
		three.setOnClickListener(this);
		four.setOnClickListener(this);

		one.setIconAlpha(1.0f);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void setOverflowButtonAlways()
	{
		try
		{
			ViewConfiguration config = ViewConfiguration.get(this);
			Field menuKey = ViewConfiguration.class
					.getDeclaredField("sHasPermanentMenuKey");
			menuKey.setAccessible(true);
			menuKey.setBoolean(config, false);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 设置menu显示icon
	 */
	@Override
	public boolean onMenuOpened(int featureId, Menu menu)
	{

		if (featureId == Window.FEATURE_ACTION_BAR && menu != null)
		{
			if (menu.getClass().getSimpleName().equals("MenuBuilder"))
			{
				try
				{
					Method m = menu.getClass().getDeclaredMethod(
							"setOptionalIconsVisible", Boolean.TYPE);
					m.setAccessible(true);
					m.invoke(menu, true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}

	//	return false;
		return super.onMenuOpened(featureId, menu);
	}

	@Override
	public void onClick(View v)
	{
		
		if(v.getId()==R.id.id_icon_music){
			Intent intent=new Intent(this, LaunchActivity.class);
			startActivity(intent);
			
		}else{
			
			clickTab(v);
		}

	}

	/**
	 * 点击Tab按钮
	 * 
	 * @param v
	 */
	private void clickTab(View v)
	{
		resetOtherTabs();

		switch (v.getId())
		{
		case R.id.id_indicator_one:
			mButtonList.get(0).setIconAlpha(1.0f);
			mViewPager.setCurrentItem(0, false);
			break;
		case R.id.id_indicator_two:
			mButtonList.get(1).setIconAlpha(1.0f);
			mViewPager.setCurrentItem(1, false);
			break;
		case R.id.id_indicator_three:
			mButtonList.get(2).setIconAlpha(1.0f);
			mViewPager.setCurrentItem(2, false);
			break;
		case R.id.id_indicator_four:
			mButtonList.get(3).setIconAlpha(1.0f);
			mViewPager.setCurrentItem(3, false);
			break;
		}
	}

	/**
	 * 重置其他的TabIndicator的颜色
	 */
	private void resetOtherTabs()
	{
		for (int i = 0; i < mButtonList.size(); i++)
		{
			mButtonList.get(i).setIconAlpha(0);
		}
	}

	@Override
	public void onPageScrolled(int position, float positionOffset,
			int positionOffsetPixels)
	{
		// Log.v("TAG-1", "position = " + position + " ,positionOffset =  "
		// + positionOffset);
		if (positionOffset > 0)
		{
			ChangeColorIconWithText left = mButtonList.get(position);
			ChangeColorIconWithText right = mButtonList.get(position + 1);
			
			//Log.v("TAG", mButtonList.get(position + 1));
			
			left.setIconAlpha(1 - positionOffset);
			right.setIconAlpha(positionOffset);
			//Log.v("TAG0", "position:"+position+"----offset"+positionOffset);
		}
		
		//Log.v("TAG+1", "position:"+position+"----offset"+positionOffset);
 
	}

	@Override
	public void onPageSelected(int position)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrollStateChanged(int state)
	{
		// TODO Auto-generated method stub

	}
	
	

}