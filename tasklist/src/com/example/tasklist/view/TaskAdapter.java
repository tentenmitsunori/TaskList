package com.example.tasklist.view;

import java.util.ArrayList;

import com.example.tasklist.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TaskAdapter extends ArrayAdapter {

	private Context context;
	private ArrayList<String> list;
	private LayoutInflater inflater;
	private int layout;

	public TaskAdapter(Context context, int textViewResourceId) {
		super(context, textViewResourceId);
		this.context = context;
		list = new ArrayList<String>();
		list.add("ñ{ìc å\óC");
		list.add("âìì° ï€êm");
		list.add("èºà‰ ëÂï„");
		list.add("ñ{ìc å\óC");
		list.add("âìì° ï€êm");
		list.add("èºà‰ ëÂï„");
		this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.layout = textViewResourceId;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v = convertView;
		if(convertView==null){
		  v = this.inflater.inflate(this.layout, null);
		}
		TextView textView1 = (TextView)v.findViewById(R.id.textView1);
		textView1.setText(this.list.get(position));
		return v;
	}

}
