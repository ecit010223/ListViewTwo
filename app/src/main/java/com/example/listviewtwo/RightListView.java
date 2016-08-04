package com.example.listviewtwo;

import com.example.util.ListViewCollector;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.OnGestureListener;
import android.widget.LinearLayout;
import android.widget.ListView;

public class RightListView extends ListView {
	private GestureDetector mGesture;
	// 横向移动方向
	private boolean isReverse = false;
	public LinearLayout rListHead;
	// 偏移坐标
	private int mOffset = 0;
	// 屏幕宽度
	private int screenWidth;

	public RightListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mGesture = new GestureDetector(context, mOnGesture);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		super.dispatchTouchEvent(ev);
		if (ListViewCollector.sender == null) {
			ListViewCollector.isMidListView=false;
			ListViewCollector.sender = this;
			ListViewCollector.dispatchTouch(ev, this);
			ListViewCollector.sender = null;
			isReverse = false;
		} else {
			isReverse = true;
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
			synchronized (RightListView.this) {
				if (isReverse)
					distanceX = -distanceX;
				// 手势沿x轴移动的距离
				int moveX = (int) distanceX;
				int dx = moveX;
				// 移动后相对于坐标原点的偏移量
				int curX = rListHead.getScrollX();
				int viewWidth = getWidth();
				// 注意越界的问题
				if (moveX + curX < 0)
					dx = 0;
				if (curX + moveX + getScreenWidth() > viewWidth)
					dx = viewWidth - getScreenWidth() - curX;
				mOffset += dx;
				for (int i = 0, j = getChildCount(); i < j; i++) {
					View child = (View) getChildAt(i);
					if (child.getScrollX() != mOffset) {
						child.scrollTo(mOffset, 0);
					}
				}
				rListHead.scrollBy(dx, 0);
			}
			requestLayout();
			return true;
		}
	};

	// 获取屏幕的宽度
	public int getScreenWidth() {
		if (screenWidth == 0) {
			screenWidth = (getContext().getResources().getDisplayMetrics().widthPixels) / 3;
		}
		return screenWidth;
	}
}
