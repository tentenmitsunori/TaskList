package com.example.tasklist;


import com.example.tasklist.view.CustomScrollView;

import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

public class TaskFragment extends Fragment { 
	private String[] data = {"Apple", "Lemon", "Orange", "Strawberry","Apple", "Lemon", "Orange", "Strawberry"};
	private CustomScrollView scroll;
	@Override	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// このフラグメント用のレイアウトをインフレートする
		View v = inflater.inflate(R.layout.tasklist_fragment, container, false);
	    initFoodTaskListView(v);
	    initLifeStyleTaskListView(v);
	    initTrainingTaskListView(v);
	    setRadioGroupChecked(v);
	    setScrollPosition(v);
		return v;
	}
	
	public void setScrollPosition(View v){
		scroll = (CustomScrollView) v.findViewById(R.id.scrollView1);
		scroll.setScrollToBottomListener(new CustomScrollView.ScrollToBottomListener() {
			@Override
			public void onScrollToBottom(CustomScrollView scrollView, int p) {
				// TODO Auto-generated method stub
				Log.d(null, ""+p);
			}
	    });
	}
	
	public void setRadioGroupChecked(View v){
		final View view = v;
	    RadioGroup group = (RadioGroup)view.findViewById(R.id.radioGroup1);
	    group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
	    	@Override
	    	public void onCheckedChanged(RadioGroup group, int checkedId) {
	    		int fdHeight = view.findViewById(R.id.foodTaskListView).getHeight();
	    		int fdtHeight = view.findViewById(R.id.TextView02).getHeight();
	    		int lsHeight = view.findViewById(R.id.lifeStyleTaskListView).getHeight();
	    		int lstHeight = view.findViewById(R.id.textView1).getHeight();
	    		ScrollView sv = (ScrollView)view.findViewById(R.id.scrollView1);

	    		switch(checkedId){
	    			case R.id.radioFood:
	    				sv.smoothScrollTo(0, 0);	
	    				return;
	    			case R.id.radioLifeStyle:
	    				sv.smoothScrollTo(0, (fdHeight+fdtHeight));	
	    				return;
	    			case R.id.radioTraining:
	    				sv.smoothScrollTo(0, (lsHeight+fdHeight+fdtHeight+lstHeight));	
	    				return;
	    			default:
	    				return;
	    		}
	    	}
	    });	
	}

	public void initFoodTaskListView(View v){
		ListView foodTaskListView = (ListView) v.findViewById(R.id.foodTaskListView);
		ArrayAdapter<String> arrayAdapter
			= new FoodTaskAdapter();
		foodTaskListView.setAdapter(arrayAdapter);
		View lvItem = foodTaskListView.getAdapter().getView(0, null, (ViewGroup) v);
		lvItem.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
	                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
	    int lvItemHeight = lvItem.getMeasuredHeight();
	    int lvWrapperHeight = lvItemHeight * foodTaskListView.getCount();
	    ViewGroup.LayoutParams params = foodTaskListView.getLayoutParams();
	    params.height = lvWrapperHeight;
	    foodTaskListView.setLayoutParams(params);
	    foodTaskListView.requestLayout();	
	}
	public void initLifeStyleTaskListView(View v){
		ListView lifeStyleTaskListView = (ListView) v.findViewById(R.id.lifeStyleTaskListView);
		ArrayAdapter<String> arrayAdapter
			= new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data);
		lifeStyleTaskListView.setAdapter(arrayAdapter);
		View lvItem = lifeStyleTaskListView.getAdapter().getView(0, null, (ViewGroup) v);
		lvItem.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
	                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
	    int lvItemHeight = lvItem.getMeasuredHeight();
	    int lvWrapperHeight = lvItemHeight * lifeStyleTaskListView.getCount();
	    ViewGroup.LayoutParams params = lifeStyleTaskListView.getLayoutParams();
	    params.height = lvWrapperHeight;
	    lifeStyleTaskListView.setLayoutParams(params);
	    lifeStyleTaskListView.requestLayout();	
	}
	
	public void initTrainingTaskListView(View v){
		ListView trainingTaskListView = (ListView) v.findViewById(R.id.trainingTaskListView);
		ArrayAdapter<String> arrayAdapter
			= new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data);
		trainingTaskListView.setAdapter(arrayAdapter);
		View lvItem = trainingTaskListView.getAdapter().getView(0, null, (ViewGroup) v);
		lvItem.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
	                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
	    int lvItemHeight = lvItem.getMeasuredHeight();
	    int lvWrapperHeight = lvItemHeight * trainingTaskListView.getCount();
	    ViewGroup.LayoutParams params = trainingTaskListView.getLayoutParams();
	    params.height = lvWrapperHeight;
	    trainingTaskListView.setLayoutParams(params);
	    trainingTaskListView.requestLayout();	
	}
}
