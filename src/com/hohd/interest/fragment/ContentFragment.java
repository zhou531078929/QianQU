package com.hohd.interest.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContentFragment extends  Fragment {
	private int num = 0;

	public static ContentFragment create(int num) {
		ContentFragment contentFragment = new ContentFragment();
		contentFragment.num = num;
		return contentFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		TextView textView = new TextView(getActivity());
		textView.setText("第::" + num);
		return textView;
	}
}
