package com.hohd.interest;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.hohd.interest.adapter.HomeContentAdapter;
import com.hohd.interest.fragment.ContentFragment;
import com.hohd.interest.fragment.LeftMenuFragment;

public class MainActivity extends FragmentActivity implements OnCheckedChangeListener, OnPageChangeListener {
	ViewPager vpContent;
	RadioGroup rgTitle;
	List<Fragment> list;
	int[] ids = { R.id.radio0, R.id.radio1, R.id.radio2, R.id.radio3, R.id.radio4 };
	DrawerLayout drawerLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list = new ArrayList<Fragment>(5);

		initView();
	}

	public void click(View view) {
		switch (view.getId()) {
		case R.id.ivHeadIcon:// 头部按钮，跳到左边的侧滑页
			// 打开侧滑页
			drawerLayout.openDrawer(Gravity.LEFT);

			break;

		default:
			break;
		}

	}

	private void initView() {
		// initView
		vpContent = (ViewPager) findViewById(R.id.vpContent);
		vpContent.setOnPageChangeListener(this);

		rgTitle = (RadioGroup) findViewById(R.id.rgTitle);
		rgTitle.setOnCheckedChangeListener(this);

		// 侧滑页
		drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

		LeftMenuFragment fragmentMenu = new LeftMenuFragment();
		getSupportFragmentManager().beginTransaction().replace(R.id.drawer, fragmentMenu).commit();

		for (int i = 0; i < 5; i++) {
			ContentFragment fragment = ContentFragment.create(i);
			list.add(fragment);

		}

		HomeContentAdapter adapter = new HomeContentAdapter(getSupportFragmentManager(), list);

		vpContent.setAdapter(adapter);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.radio0:// 最新
			Log.d("print", "打印");
			vpContent.setCurrentItem(0);
			break;
		case R.id.radio1:// 热门

			vpContent.setCurrentItem(1);
			break;
		case R.id.radio2:// 娱乐

			vpContent.setCurrentItem(2);
			break;
		case R.id.radio3:// 生活

			vpContent.setCurrentItem(3);
			break;
		case R.id.radio4:// 科技
			vpContent.setCurrentItem(4);

			break;

		default:
			break;
		}
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int arg0) {
		rgTitle.check(ids[arg0]);
	}

}
