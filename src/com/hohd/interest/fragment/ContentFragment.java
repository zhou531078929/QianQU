package com.hohd.interest.fragment;

import java.net.HttpURLConnection;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.hohd.interest.R;
import com.hohd.interest.adapter.HomeGridAdapter;
import com.hohd.interest.utils.HttpURLConnHelper;

public class ContentFragment extends Fragment implements OnRefreshListener<GridView> {
	int num = 0;
	Context context;
	PullToRefreshGridView gridHomeContent;

	public static ContentFragment create(int num) {
		ContentFragment contentFragment = new ContentFragment();
		contentFragment.num = num;
		return contentFragment;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		context = activity;

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_home_content, null);

		initView(view);

		return view;
	}

	void initView(View view) {
		gridHomeContent = (PullToRefreshGridView) view.findViewById(R.id.gridHomeContent);
		gridHomeContent.setOnRefreshListener(this);
		HomeGridAdapter adapter = new HomeGridAdapter(null, context);
		gridHomeContent.setAdapter(adapter);

	}

	@Override
	public void onRefresh(PullToRefreshBase<GridView> refreshView) {
//		HttpURLConnHelper.loadByteFromURL(url);
	}

}
