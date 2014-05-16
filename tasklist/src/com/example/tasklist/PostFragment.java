package com.example.tasklist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

public class PostFragment extends Fragment {
	@Override	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// このフラグメント用のレイアウトをインフレートする
		View v = inflater.inflate(R.layout.post_fragment, container, false);
	    setRadioGroupChecked(v);
		return v;
	}
	
	public void setRadioGroupChecked(View v){
		final View view = v;
	    RadioGroup group = (RadioGroup)view.findViewById(R.id.radioGroup2);
	    group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
	    	@Override
	    	public void onCheckedChanged(RadioGroup group, int checkedId) {
	    		View ftp = (View)view.findViewById(R.id.foodTaskPostLayout);
	    		View ltp = (View)view.findViewById(R.id.lifeStyleTaskPostLayout);
	    		View ttp = (View)view.findViewById(R.id.trainingTaskPostLayout);
	    		switch(checkedId){
	    			case R.id.radioFood2:
	    				ftp.setVisibility(View.VISIBLE);
	    				ltp.setVisibility(View.GONE);
	    				ttp.setVisibility(View.GONE);
	    				return;
	    			case R.id.radioLifeStyle2:
	    				ftp.setVisibility(View.GONE);
	    				ltp.setVisibility(View.VISIBLE);
	    				ttp.setVisibility(View.GONE);
	    				return;
	    			case R.id.radioTraining2:
	    				ftp.setVisibility(View.GONE);
	    				ltp.setVisibility(View.GONE);
	    				ttp.setVisibility(View.VISIBLE);
	    				return;
	    			default:
	    				return;
	    		}
	    	}
	    });	
	}
}
