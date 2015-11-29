package com.hohd.interest.fragment;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.hohd.interest.R;
import com.hohd.interest.adapter.HomeGridAdapter;
import com.hohd.interest.bean.Any;
import com.hohd.interest.bean.NewsItem;
import com.hohd.interest.utils.Constants;
import com.hohd.interest.utils.HttpURLConnHelper;

public class ContentFragment extends Fragment implements OnItemClickListener{
	int num = 0;
	Context context;
	PullToRefreshGridView gridHomeContent;
	int page = 1;
	List<NewsItem> list;
	Handler handler = new Handler();

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

	private HomeGridAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_home_content, null);

		initView(view);

		return view;
	}

	void initView(View view) {
		gridHomeContent = (PullToRefreshGridView) view.findViewById(R.id.gridHomeContent);
		gridHomeContent.setOnRefreshListener(new OnRefreshListener2<GridView>() {

			@Override
			public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
				getData();
			}

			@Override
			public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
				gridHomeContent.onRefreshComplete();
			}

		});

	}

	private void getData() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				
				byte[] loadByteFromURL = HttpURLConnHelper.loadByteFromURL(Constants.urlNews);

				if (loadByteFromURL != null) {
					// 请求成功
					String json = new String(loadByteFromURL);
					Log.i("print", "json::" + json);
					Gson gson = new Gson();
					Any any = gson.fromJson(json, Any.class);
					if (page == 1)
						list = any.discovers;
					else {
						list.addAll(any.discovers);
					}

					Log.i("print", "list::" + list);

					// handler.post(new Runnable() {
					//
					// @Override
					// public void run() {
					//
					// }
					// });
					((Activity) context).runOnUiThread(new Runnable() {

						@Override
						public void run() {
							gridHomeContent.onRefreshComplete();
							if (page == 1) {
								adapter = new HomeGridAdapter(list, context);
								gridHomeContent.setAdapter(adapter);

							} else {
								 adapter.notify();
							}

							page++;
						}

					});
				} else {
					// 请求失败
					Log.i("print", "网络错误");
				}

			}
		}).start();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
	}

}
