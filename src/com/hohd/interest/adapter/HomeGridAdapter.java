package com.hohd.interest.adapter;

import java.util.List;

import com.hohd.interest.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeGridAdapter extends BaseAdapter {
	List<?> list;
	Context context;

	public HomeGridAdapter(List<?> list, Context context) {
		super();
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		return 10;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView != null) {
			holder = (ViewHolder) convertView.getTag();

		} else {
			convertView = View.inflate(context, R.layout.item_grid_content, null);
			holder = new ViewHolder();

			holder.ivIcon = (ImageView) convertView.findViewById(R.id.ivIcon);

			holder.tvTime = (TextView) convertView.findViewById(R.id.tvTime);
			holder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
			holder.tvGoodNum = (TextView) convertView.findViewById(R.id.tvGoodNum);
			holder.tvCommentNum = (TextView) convertView.findViewById(R.id.tvCommentNum);

		}

		return convertView;
	}

	static class ViewHolder {
		ImageView ivIcon;
		TextView tvTitle;
		TextView tvTime;
		/**
		 * 点赞
		 */

		TextView tvGoodNum;
		/**
		 * 评论
		 */

		TextView tvCommentNum;

	}

}
