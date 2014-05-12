package com.example.tasklist;


import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class TaskFragment extends Fragment { 
	private String[] data = {"Apple", "Lemon", "Orange", "Strawberry"}; 
	@Override	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// ���̃t���O�����g�p�̃��C�A�E�g���C���t���[�g����
		View v = inflater.inflate(R.layout.tasklist_fragment, container, false);
		ListView foodTaskListView = (ListView) v.findViewById(R.id.foodTaskListView);
		ArrayAdapter<String> arrayAdapter
			= new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data);
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
		return v;
	}	
}