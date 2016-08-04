package com.example.util;

import java.util.ArrayList;
import java.util.List;

import android.view.MotionEvent;
import android.widget.ListView;

public class ListViewCollector {
	public static List<ListView> listviews = new ArrayList<ListView>();
	public static ListView sender = null;
	public static boolean isMidListView = false;

	public static void addListView(ListView listview) {
		listviews.add(listview);
	}

	public static void dispatchTouch(MotionEvent event, ListView me) {
		for (ListView listview : listviews) {
			if (listview != me)
				listview.dispatchTouchEvent(event);
		}
	}
}
