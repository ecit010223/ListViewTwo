package com.example.listviewtwo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.util.ListViewCollector;

public class MidListView extends ListView {
	private GestureDetector mGesture;
	public LinearLayout mListHead;
	// 偏移坐标
	private int mOffset = 0;
	// 屏幕宽度
	private int screenWidth;

	public MidListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mGesture = new GestureDetector(context, mOnGesture);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		super.dispatchTouchEvent(ev);
		if (ListViewCollector.sender == null) {
			ListViewCollector.isMidListView=true;
			ListViewCollector.sender = this;
			ListViewCollector.dispatchTouch(ev, this);
			ListViewCollector.sender = null;
		}
		return mGesture.onTouchEvent(ev);
	}

	private OnGestureListener mOnGesture = new GestureDetector.SimpleOnGestureListener() {
		public boolean onDown(android.view.MotionEvent e) {
			return true;
		}

		public boolean onFling(android.view.MotionEvent e1,
				android.view.MotionEvent e2, float velocityX, float velocityY) {
			return false;
		}

		public boolean onScroll(android.view.MotionEvent e1,
				android.view.MotionEvent e2, float distanceX, float distanceY) {
			return true;
		}
	};

}
