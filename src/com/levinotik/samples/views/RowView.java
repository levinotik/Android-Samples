package com.levinotik.samples.views;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RowView extends RelativeLayout {
	
	private TextView _textView;

	public RowView(Context context) {
		super(context);
		createLayout(context);
	}

	private void createLayout(Context context) {
		this.setPadding(10, 10, 10, 10);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT);
		_textView = new TextView(context);
		params.addRule(RelativeLayout.ALIGN_PARENT_TOP,1);
		_textView.setLayoutParams(params);
		this.addView(_textView);
				
	}
	
	public void display(String info) {
		_textView.setVisibility(View.VISIBLE);
		_textView.setText(info);
		
	}

}
