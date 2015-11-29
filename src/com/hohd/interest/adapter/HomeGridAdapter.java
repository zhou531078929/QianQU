package com.hohd.interest.adapter;

import java.util.List;

import com.hohd.interest.R;
import com.hohd.interest.bean.NewsItem;
import com.hohd.interest.utils.ImageCacheHelper;
import com.hohd.interest.utils.ImageCacheHelper.OnImageDownloadListener;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeGridAdapter extends BaseAdapter {
	List<NewsItem> list;
	Context context;

	public HomeGridAdapter(List<NewsItem> list, Context context) {
		super();
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		return list.size();
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
			convertView.setTag(holder);

			holder.ivIcon = (ImageView) convertView.findViewById(R.id.ivIcon);

			holder.tvTime = (TextView) convertView.findViewById(R.id.tvTime);
			holder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
			holder.tvGoodNum = (TextView) convertView.findViewById(R.id.tvGoodNum);
			holder.tvCommentNum = (TextView) convertView.findViewById(R.id.tvCommentNum);

		}
		holder.tvTitle.setText(list.get(position).title);
		final ImageView iv = holder.ivIcon;
		new ImageCacheHelper().imageDownload("http://www.qianqu.cc"+list.get(position).thumbnail, holder.ivIcon, new OnImageDownloadListener() {

			@Override
			public void onImageDownload(Bitmap bitmap) {
				iv.setImageBitmap(bitmap);
			}

		});

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
