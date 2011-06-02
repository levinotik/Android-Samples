package com.levinotik.samples.adapters;

import java.util.HashMap;

import com.levinotik.android.ui.MergeAdapter;
import com.levinotik.samples.R;
import com.levinotik.samples.views.RowView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class HashMapMergeAdapterDemo extends Activity {
	
	//key = display info, value = corresponding URL
	private static  HashMap<String, String> map1 = null;
	private static  HashMap<String, String> map2 = null;
	private static  HashMap<String, String> map3 = null;



	private MergeAdapter adapter = null;
	private ListAdapter listAdapter = null;

	@Override 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	
		ListView lv = (ListView)findViewById(android.R.id.list);

		map1 = new HashMap<String, String>();

		map1.put("key1", "http://google.com");
		map1.put("key2", "http://linkedin.com");
		map1.put("key3", "http://twitter.com");
		
		map2 = new HashMap<String, String>();

		map2.put("key1", "http://google.com");
		map2.put("key2", "http://linkedin.com");
		map2.put("key3", "http://twitter.com");
		
		map3 = new HashMap<String, String>();

		map3.put("key1", "http://google.com");   
		map3.put("key2", "http://linkedin.com"); 
		map3.put("key3", "http://twitter.com");  

		adapter = new MergeAdapter();
		listAdapter = buildFirstList();
		adapter.addView(buildFirstLabel(), true);
		adapter.addAdapter(listAdapter);
		adapter.addView(buildSecondLabel(), true);
		adapter.addAdapter(buildSecondList());
		adapter.addView(buildThirdLabel(), true);
		adapter.addAdapter(buildThirdList());

		lv.setAdapter(adapter);
		lv.setOnItemClickListener(itemClickListener);

	}


	private ListAdapter buildFirstList() {
		return(new HashMapAdapter(this, map1));

	}


	private ListAdapter buildSecondList() {
		return(new HashMapAdapter(this, map2));

	}

	private ListAdapter buildThirdList() {
		return(new HashMapAdapter(this, map3));

	}

	private View buildFirstLabel() {
		TextView text1 = new TextView(this);

		text1.setTextSize(20);
		text1.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
		text1.setTextColor(Color.BLUE);

		text1.setText("Text here");

		return text1;

	}

	private View buildSecondLabel() {
		TextView text2 = new TextView(this);

		text2.setTextSize(20);
		text2.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
		text2.setTextColor(Color.BLUE);

		text2.setText("Text here");

		return text2;

	}

	private View buildThirdLabel() {
		TextView text3 = new TextView(this);

		text3.setTextSize(20);
		text3.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
		text3.setTextColor(Color.BLUE);
		text3.setText("Text here");

		return text3;

	}

	private OnItemClickListener itemClickListener = new OnItemClickListener() {

		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

			Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(arg0.getAdapter().getItem(arg2).toString()));			
			
			startActivity(intent);


		}
	};

	private class HashMapAdapter extends BaseAdapter {

		private HashMap<String, String> mMap = new HashMap<String, String>();
		private String[] mKeys;
		private Context mContext;

		private HashMapAdapter(Context context, HashMap<String, String> map) {
			mContext = context;
			mMap = map;
			mKeys = mMap.keySet().toArray(new String[map.size()]);			
		}

		@Override
		public int getCount() {
			return mMap.size();
		}

		@Override
		public Object getItem(int position) {

			return mMap.get(mKeys[position]);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			RowView row;
			if(convertView == null) {
				row = new RowView(getBaseContext());
			} else {
				row = (RowView) convertView;
			}
			row.display(mKeys[position]);
			return row;

		}

	}

	
}

