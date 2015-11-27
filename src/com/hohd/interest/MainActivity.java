package com.hohd.interest;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.hohd.interest.adapter.HomeContentAdapter;
import com.hohd.interest.fragment.ContentFragment;

public class MainActivity extends FragmentActivity {
	ViewPager vpContent;

	List<Fragment> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list = new ArrayList<Fragment>(5);

		initView();
	}
	public void click(View view){
		
	}

	private void initView() {
		// initView
		vpContent = (ViewPager) findViewById(R.id.vpContent);

		for (int i = 0; i < 5; i++) {
			ContentFragment fragment = ContentFragment.create(i);
			list.add(fragment);

		}

		HomeContentAdapter adapter = new HomeContentAdapter(getSupportFragmentManager(), list);

		vpContent.setAdapter(adapter);
	}

}
