package com.example.listviewtwo;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.util.ListViewCollector;

public class MainActivity extends Activity {
	private LeftListView leftListView;
	private RightListView rightListView;
	private MidListView midListView;
	private LayoutInflater mInflater;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		// 为左边的ListView赋值
		leftListView = (LeftListView) findViewById(R.id.left_listview);
		ListViewCollector.addListView(leftListView);
		leftListView.lListHead = (LinearLayout) findViewById(R.id.l_items);
		leftListView.setAdapter(new LeftAdapter());

		// 为右边的ListView赋值
		rightListView = (RightListView) findViewById(R.id.right_listview);
		ListViewCollector.addListView(rightListView);
		rightListView.rListHead = (LinearLayout) findViewById(R.id.r_items);
		rightListView.setAdapter(new RightAdapter());

		midListView = (MidListView) findViewById(R.id.mid_listview);
		ListViewCollector.addListView(midListView);
		midListView.mListHead = (LinearLayout) findViewById(R.id.m_items);
		midListView.setAdapter(new MidAdapter());
	}

	private class LeftAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return 50;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.left_items, null);
			}
			for (int i = 0; i < 8; i++) {
				((TextView) convertView.findViewById(R.id.l_item1 - i))
						.setText("左边" + position);
			}
			return convertView;
		}

	}

	private class RightAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return 50;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.right_items, null);
			}
			for (int i = 0; i < 8; i++) {
				((TextView) convertView.findViewById(R.id.r_item1 + i))
						.setText("右边" + position);
			}
			return convertView;
		}

	}

	private class MidAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return 50;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.mid_items, null);
			}
			for (int i = 0; i < 8; i++) {
				((TextView) convertView.findViewById(R.id.m_item)).setText("中间"
						+ position);
			}
			return convertView;
		}

	}
}
